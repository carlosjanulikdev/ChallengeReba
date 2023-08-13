# ChallengeReba
Desafío técnico enviado por Luis

<hr/>

### Objetivo:
El principal objetivo es construir una API REST con las operaciones CRUD
necesarias para gestionar el recurso Persona.
Se divide en 3 niveles de complejidad para que puedas demostrar tu experiencia y
conocimientos.
Se evaluará por cada nivel completo, pudiéndose entregar el desafío en forma
parcial incluyendo solo nivel 1 o solo nivel 1 y 2, o los 3 niveles completos.

### Consigna: 
<ul>
<li> No puede haber personas repetidas (las personas se identifican por Tipo de
documento, número de documento, país).</li>
<li> Las personas deben tener al menos un dato de contacto.</li>
<li> No pueden crearse personas menores de 18 años.</li>
<li> Pueden tener cualquier nacionalidad.</li>
<li>Las entidades complementarias a Personas deben estar pre-cargadas al
momento de usar la API.</li>
</ul>

### Desafíos:
#### Nivel 1:
<ul>
<li> Desarrollo que cumpla con la consigna inicial, que pueda
descargarse y ejecutarse localmente.</li>
<li> Documentación para configurar el entorno local.</li>
</ul>

#### Nivel 2:
<ul>
<li> Extender la API para que permita relacionar personas.</li>
<li> Se debe crear el endpoint /personas/:id1/padre/:id2</li>
<li> Debe soportar el método POST cuyo resultado es indicar
que ":id1" es padre de ":id2".</li>
<li> Se debe crear el endpoint /relaciones/:id1/:id2
Debe soportar el método GET que retorne la relación que
existe entre ambas personas.</li>
<li> Las relaciones posibles para retornar son: {“HERMAN@”, “PRIM@”,
“TI@”}</li>
</ul>

#### Nivel 3:
<ul>
<li> API REST publicada en algún servicio free de cloud computing
(Google App Engine, Heroku, Amazon AWS, Azure, etc)</li>
<li> Agregar el recurso /stats que devuelva cifras totalizadoras de
cantidad de porcentaje de personas por país.</li>
<li> Ejemplo:
[{
“country”:”Argentina”,
“percentage”:”82.75”
},{
“country”:”Brasil”,
“percentage”:”17.25”
}]</li>
<li> Desarrollar Test de performance considerando que la API pueda
recibir fluctuaciones de tráfico (Entre 1 y 500 request por
segundo).</li>
</ul>

#### Entregar:
<ul>
<li> Documentación de desarrollo, debes incluir toda la documentación que creas
necesaria, para que el código entregado se ejecute sin errores.</li>
<li> Código Fuente accesible en GitHub, Bitbucket o GitLab, donde se registren
desde el commit inicial hasta el último de la versión productiva.</li>
Opcionalmente puede dejar en un Branch los features sin terminar.</li>
<li> Además del código fuente, cualquier pieza adicional que consideres aporta a
la calidad del software construido.</li>
<li> URL de la API (Nivel 3) y credenciales en caso de ser necesario, para poder
invocar la API desde Internet.</li>
</ul>

#### Tecnología:

<ul>
<li> Lenguaje: JAVA 11+</li>
<li> Frameworks: Spring Boot, JPA, etc.</li>
<li> Base de datos: libre elección.</li>
</ul>

<hr/>

### Documentación para configurar el entorno local
<ul>
<li> $ git clone https://github.com/carlosjanulikdev/ChallengeReba</li>
<li> $ cd ChallengeReba</li>
<li> $ mvn spring-boot:run</li>
</ul>

### Documentación de API:
http://localhost:5000/swagger-ui/index.html

### Tecnologías empleadas en el proyecto
<ul>
<li> Java 17</li>
<li> Maven</li>
<li> JPA</li>
<li> Spring Boot</li>
<li> Swagger</li>
<li> Base de datos MySql</li>
<li> Lombok</li>
<li> Log4J</li>
</ul>