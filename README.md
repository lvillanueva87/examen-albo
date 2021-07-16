## test-abo

Este microservicio tiene dos API's

***/marvel/colaborators/{character}***
 - Se encarga de obtener la información asociada a los colaboradores de
   comics del heroe seleccionado.

***/marvel/characters/{character}***
 - Se encarga de obtener todos los personajes con los que ha
   interactuado el héroe así como los comics de aparición.

Se ejecuta un Cron cada 5 minútos que realiza el llamado a la Api de Marvel y realiza la actualización de la BD.

## Versión 1.0

 1. Maven
 2. Spring
 3. SpringBoot
 4. Spring Tools Suite
 5. Lombok
 6. H2
 7. Marvel API
 8. Llave pública API: 92d978f0c99ccc8d55a93505d4275315
 9. Llave privada API: e7bcafcd6d0b973a89b12c830dd80ce931dc100b

## Bases de Datos H2:

	-Tablas:
		

 1. HEROS 										--Almacena los héroes, de momento solo son Capitán América y Iron Man.
 2. COLABORATORS					--Almacena la información de los colaboradores que han participado en la creación de los comics de los héroes.
 3. CHARACTERS 							--Almacena los personajes con los que los que los héroes antes mencionados han tenido interacción en los comics.
 4. SYNC											--Almacena las fechas y horas de actualización del servicio.
 5. HEROS_CHARACTERS 			--Relación de heroes/personajes
 6. HEROS_COLABORATORS 	--Relación de heros/colaboradores

Para ingresar a la consola de H2 puede ser medienta el siguiente enlace, una vez deplegado el proyecto.
http://localhost:8080/h2-console
user: sa
password: (vacío)

Para cambiar la frecuencia de llamado del corn, modificar el valor de la propiedad: constants.api.cron.expression en el archivo application.properties

Para modificar en nivel de log, modificar el valor de la propiedad: logging.level.com.jvillanueva.albo.test en el archivo application.properties

Se necesita tener instalado:
		
 - Java 1.8  		
 - Maven 		

**Construir el proyecto**
   ejecutar el script assemble.sh
   ./assemble.sh

**Desplegar en local**
   ejecutar el script avengers.sh
   ./avengers.sh