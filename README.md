# Ámbitos (Scopes) de CDI en Quarkus

En este repositorio se documentan los distintos ámbitos de inyección de dependencias (Beans) en Java con Quarkus. Para evitar redundancias, se presentan 7 casos de uso prácticos orientados a escenarios reales de ingeniería de software para cada ámbito.

## 1. `@ApplicationScoped`
**Qué es:** Crea una única instancia para toda la aplicación. Es ideal para servicios de negocio sin estado (stateless).

**Ejemplos:**
1. **ProcesadorPagosService:** Un servicio pesado para comunicarse con pasarelas de pago. Como no guarda datos de una transacción en específico en sus atributos, una sola instancia basta para miles de peticiones concurrentes.
2. **MotorReglasFraude:** Mantiene en caché un árbol de reglas leído de la base de datos para evaluar transacciones en tiempo real sin golpear la BD en cada validación.
3. **GestorConexionesIntegracion:** Mantiene el pool de conexiones y el control del estado (Circuit Breaker) hacia un ERP corporativo de terceros.
4. **AgendadorTareasLote:** Controla el temporizador para procesos programados, como una conciliación bancaria nocturna. Si hubiera más de una instancia, los procesos se lanzarían duplicados por error.
5. **GestorNotificacionesPush:** Mantiene abierto un socket TCP persistente hacia los servidores de Apple/Google y reutiliza la misma conexión para mandar notificaciones desde cualquier parte del sistema.
6. **AnalizadorMetricasNegocio:** Acumula métricas en memoria (ej. contadores de latencias) recopiladas de todos los hilos, para luego mandarlas en bloque a un servicio de telemetría.
7. **CatalogoDivisasGlobal:** Guarda las tasas de cambio de monedas del día para tenerlas disponibles instantáneamente en cualquier módulo que procese pagos.

## 2. `@Singleton`
**Qué es:** Una sola instancia compartida en toda la aplicación, pero a diferencia del anterior, se inyecta la referencia directa de memoria. Se utiliza para centralizar **lógica utilitaria** (Utility classes) pura.

**Ejemplos:**
1. **ValidadorIdentidadUtil:** Contiene el algoritmo matemático (módulo 10) para validar cédulas y RUCs. Cualquier módulo que necesite verificar un documento llama a esta única herramienta.
2. **GeneradorHashSeguridadUtil:** Centraliza los algoritmos de criptografía. Recibe contraseñas en texto plano de los servicios de negocio y devuelve los hashes listos para guardarse en la BD.
3. **CalculadoraDiasLaborablesUtil:** Una herramienta de fechas que recibe un rango y calcula los días hábiles transcurridos, descontando automáticamente fines de semana.
4. **FormateadorFinancieroUtil:** Estandariza la presentación de valores monetarios. Se encarga de aplicar los redondeos, símbolos de moneda y separadores de miles para que toda la app muestre el dinero de la misma forma.
5. **SanitizadorEntradasUtil:** Un filtro de limpieza que recibe cadenas de texto enviadas por los usuarios y elimina caracteres extraños para prevenir vulnerabilidades de inyección.
6. **ExtractorMetadatosArchivoUtil:** Un procesador que lee los primeros bytes de un archivo subido y determina su extensión real y tipo MIME para validar si es un formato admitido.
7. **TraductorCodigosErrorUtil:** Centraliza un diccionario en memoria que mapea códigos de error técnicos de la base de datos a mensajes legibles para mostrar al cliente final.

## 3. `@Dependent`
**Qué es:** Es el scope por defecto. Se crea una nueva instancia cada vez que se inyecta, y su ciclo de vida muere junto con el objeto que lo llamó. Es obligatorio para componentes que mantienen estados (stateful).

**Ejemplos:**
1. **GeneradorReporteFinanciero:** Acumula datos internos temporales para generar un PDF. Si este bean fuera global, los datos de dos usuarios pidiendo reportes al mismo tiempo se mezclarían.
2. **TransaccionCompensatoria:** Guarda el historial de los pasos que se deben deshacer en una compra específica si el pago final falla (Patrón Saga).
3. **ConstructorConsultaDinamica:** Una clase que encadena métodos para armar sentencias SQL complejas. Necesita instanciarse limpia para no arrastrar basura de la consulta anterior.
4. **ValidadorReglasNegocio:** Acumula un listado de errores de dominio específicos de un solo cliente mientras se evalúa, por ejemplo, su solicitud de crédito.
5. **ClienteCifradoSesion:** Maneja llaves efímeras de encriptación. Cuando su clase padre termina la operación, la instancia y su llave se recolectan automáticamente de la memoria.
6. **ParseadorArchivosLote:** Guarda internamente en qué línea se quedó leyendo de un archivo grande y cuántos registros con error lleva acumulados.
7. **ContextoFirmaDigital:** Representa el estado de una firma electrónica en proceso, manejando arreglos de bytes temporales que pertenecen exclusivamente a ese documento.

## 4. `@RequestScoped` (Adicional)
**Qué es:** Se crea una instancia nueva al iniciar una petición HTTP y se destruye al enviar la respuesta. Comparte estado solo durante ese flujo.

**Ejemplos:**
1. **ContextoUsuarioAutenticado:** Guarda el ID del usuario y sus roles extraídos del JWT, permitiendo que cualquier capa inferior sepa quién ejecutó la acción sin pasar parámetros.
2. **TrazabilidadRequest:** Genera un UUID único al entrar la petición para etiquetar todos los logs generados en ese flujo.
3. **CarritoComprasValidacion:** Cachea las reglas de descuento calculadas al inicio de la petición para no tener que procesarlas de nuevo en el paso de cobro.
4. **CachéConsultasRequest:** Evita consultar la misma tabla de la base de datos varias veces si diferentes servicios la necesitan durante el mismo flujo HTTP.
5. **GestorTransaccionBaseDatos:** Controla la conexión de la BD para asegurar que todas las operaciones del request se hagan en el mismo *commit*.
6. **ManejadorMultiTenant:** Determina a qué esquema de base de datos apuntar basándose en el subdominio desde el que se hizo la petición.
7. **AcumuladorMensajesFlash:** Recolecta advertencias generadas en distintas partes del proceso para empaquetarlas juntas en el JSON de respuesta.