Para lanzar la práctica se puede importar la práctica desde Eclipse y ejecutarla, o directamente desde línea de comandos.
Para ello primero habría que compilar el proyecto con la ayuda de un bat:
	compila.bat
	
Este script genera un .war

Para ejecutar desde línea de comandos:
	java -jar <nombre del war>
	
Una vez arrancado, empezará a cargar tweets en la BD, según los criterios espcificados en el fichero de configuración:

	ConfigurationData.json
	
Los parámetros de interés a efectos de la práctica son:
	NumMinSuscriptoresUsuarioParaPersistir
	IdiomasPermitidosParaPersistir
	MaxNumHashTags
	
El resto son parámetros adicionales de la arquitectura.

La BD es org.hsqldb. Es una BD SQL en memoria que viene embebida en Spring.

El acceso a los servicios vendrá a través de las siguientes urls:

	http://localhost:8080/api/gestiontweets.Tweets              (Get)
	http://localhost:8080/api/gestiontweets.ValidarTweet/200    (Post) --> Cambiar el valor (200) por el id del tweet. Es un id secuencial, no el id real del tweet. Está hecho así para facilitar el uso del api rest en las pruebas
	http://localhost:8080/api/gestiontweets.TweetsValidos       (Get)
	http://localhost:8080/api/gestiontweets.TweetsMasUsados     (Post) --> Poner content-type = application/json. Requiere un parámetro en el body: {"maxHashtags":<num_máximo>}  ; donde <num_máximo> es el número máximo de hashtags que se devuelven. Si no se especifica (null), se toma el valor indicado en el fichero de configuración