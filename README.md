# SOCCER CLUB ADMINISTRACION APP. 🚀

[![Java versions](https://img.shields.io/badge/JAVA-v8-blue)](https://www.java.com/es/download/) [![version](https://img.shields.io/badge/Version-v1.0-blue)](https://github.com/valdeortiz/SoccerClubWebApp)

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/a460577315c6434a96a79218ef4858fd)](https://www.codacy.com?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=valdeortiz/SoccerClubWebApp&amp;utm_campaign=Badge_Grade)

## Descarga de Repositorio :arrow_backward:

Ejecutar:``` git clone https://github.com/valdeortiz/SoccerClubWebApp.git ```

o decargar en el repositorio. En la seccion de clone, click en ***Descargar en zip***

### Importar al STS.
En la pestaña file, luego la opcion de importar y elegimos existing Meaven Project y finalizamos escogiendo la carpeta donde descargamos el repositorio.

***
## Pre-requisitos 📋.
Se necesita tener instalado Java 8 junto con spring. Recomendamos el uso de Spring tools IDE.
- [Java Download](https://www.java.com/es/download/)
- [Spring Tools](https://spring.io/tools)
- [Proyecto Spring Sin IDE(En caso de no usar STS)](https://hackerdev.net/viewtopic.php?t=7)
- [Insomnia Rest client](https://insomnia.rest/)

Seguir las intruciones del enunciado anterior para la Descarga del repositorio.


### Ejecucion 🔩
Ejecutamos el siguiente comando en el directorio ***app*** para compilar y levantar nuestro servidor.
> ```$ ./mvnw clean package -DskipTests -Dmaven.javadoc.skip=true -B -V```

> ```$ java -jar target/democlub-0.0.1-SNAPSHOT.jar ```

***

## Construido con 🛠️

- [Java](https://www.java.com/es/download/ "Pagina oficial del lenguaje de programacion Java")
- [Spring](https://spring.io/ "Framework Spring")


## Observacion 📢 

> ***En el democlub.json cambiar 192.168.0.11 por localhost***

> ***Contruido con Sring Tools. En caso de no usar recomiendo leer el siguiente enlace***
[Proyecto Spring Sin IDE](https://hackerdev.net/viewtopic.php?t=7)

> ***Si al ejecutar `java --version`, no retorna un valor. Asegurate de tener descargado y vuelve a ejecutar `java --version` hasta que devuelva una version.***

> ***En la carpeta scripts se encuentra un script para la ejecucion***

## Documentacion oficial 📄
[JavaDoc](https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javadoc.html "Documentacion oficial de java")

***

## EndPoints ⌨️

1. Motrar todos los dato de una entidad(findAll).

<details>

**Descripcion:**
Muestra en formato tipo json todos los miembros de la entidad. 

**Argumentos:**
- nombre de la entidad. OBS: LA BARRA AL FINAL ES NECESARIA.

Ejemplos:

``` http://localhost:8080/{nombre de la entidad}/ ```

**Metodo HTTP:**
GET

</details>

2. Mostrar un miembro especifico de una entidad(findById).

<details>

**Descripcion:**
Muestra los datos de un miembro especifico de la entidad

**Argumentos:**
- nombre de la entidad: la entidad donde se encuentra el miembro.
- id: id unico del miembro.OBS: en caso de no saber el id, ejecutar el findAll.

Ejemplos:

``` http://localhost:8080/{nombre de la entidad}/{id} ```

**Metodo HTTP:**
GET

</details>

3. Borrar un miembro segun su id(deleteById).

<details>

**Descripcion:**
Borra un miembro de la base de datos de la entidad.

**Argumentos:**
- nombre de la entidad: la entidad donde se encuentra el miemebro.
- id: id unico del miembro a ser eliminado.

Ejemplos:

``` http://localhost:8080/{nombre de la entidad}/id ```

**Metodo HTTP:**
DELETE

</details>

4. Enviar un miembro a la base de datos de una entidad(save).

<details>

**Descripcion:**
Creamos y guardamos un nuevo miembro en la base de datos.

**Argumentos:**
- nombre de la entidad: el nombre de la entidad donde vamos a guardar.

Ejemplos:

``` http://localhost:8080/{nombre de la entidad}/ ```

**Metodo HTTP:**
POST

**OBSERVACION:**
- Puedes importar democlub.json(se encuentra en la carpeta raiz del repositorio) en tu interfaz grafica de envios de peticiones http tipo insomnia o postman.En el archivo se encuentra varios ejemplos de peticiones http con sus correspondiente cuerpo en json.

</details>

5. Eliminar todos(deleteAll)(OBS: SOLO ALGUNOS SOPORTAN ESTA PETICION).

<details>

**Descripcion:**
Borra todas las tablas(miembros) de una entidad.

**Argumentos:**
- nombre : nombre del directorio a ser creado.

Ejemplos:

``` http://localhost:8080/{nombre de la entidad}/delete ```

**Metodo HTTP:**
DELETE

</details>

6. Mostrar el salario promedio de todos los miembros de un club.
<details>

**Descripcion:**
Muestra el salario promedio de todos los empleados de un club.

**Argumentos:**
- nombre del equipo: equipo a mostrar el salario promedio de todos sus empleados.

Ejemplos:

``` http://localhost:8080/team/av/{nombre del equipo} ```

**Metodo HTTP:**
GET

</details>

7. Mostrar los equipos segun su division(findByDivision).

<details>

**Descripcion:**
Muestra todos los equipos de la division.

**Argumentos:**
- division: La division a ser impreso en pantalla.

Ejemplos:

``` http://localhost:8080/team/div/{division} ```

**Metodo HTTP:**
GET

</details>

8. Inscripcion a un empleado a una asociacion.

<details>

**Descripcion:**
Inscripcion de un empleado a alguna asociacion(hasta ahora solo existe la Aso de empleados).

**Argumentos:**
- id del empleado: id unico del empleado a ser inscripto.
- nombre de la asociacion: La asociacion a ser inscripto(OBS: El unico que existe es la aso de empleados).

Ejemplos:

``` http://localhost:8080/association/ins/{id del empleado} /{nombre de la asociacion} ```

**Metodo HTTP:**
PUT

</details>

9. Agregar un Dt a un equipo:

<details>

**Descripcion:**
Agregar a un equipo un dt. OBS: Debe de ser jugador y con mas de un trofeo ganado.

**Argumentos:**
- ninguno.

Ejemplos:

``` http://localhost:8080/dt ```

**Metodo HTTP:**
PUT

</details>

10. Mostrar el salario promedio de un empleado.

<details>

**Descripcion:**
Mostrar el salario promedio de un empleado.

**Argumentos:**
- id: id del empleado a ser impreso su salario promedio.

Ejemplos:

``` http://localhost:8080/employee/prom/{id} ```

**Metodo HTTP:**
GET

</details>

11. Agregar un directivo a un equipo.

<details>

**Descripcion:**
Agregar un directivo a un equipo.OBS: Mirar el democlub.json para ver el body del request.

**Argumentos:**
- ninguno.

Ejemplos:

``` http://localhost:8080/executive/```

**Metodo HTTP:**
PUT

</details>

12. Mostrar el salario promedio de un jugador.

<details>

**Descripcion:**
Mostrar el salario promedio de un jugador.

**Argumentos:**
- id: id del jugador a ser impreso su salario promedio.

Ejemplos:

``` http://localhost:8080/player/prom/{id} ```

**Metodo HTTP:**
GET

</details>

***

## Recomendaciones 📦

- Aegurarse de tener todo descargado correctamente.
- Tener conocimientos basicos en el protocolo http.
- Asegurarse de tener todo lo necesario instalado en su dispositivo, recomendamos la lectura de pre-requisitos.

## Autores ✒️

* **Valdemar Ortiz** - [valdeortiz](https://github.com/valdeortiz)
* **Marcelo Baez** -  [MBaez](https://github.com/Mbaez97)