"# REST_Users" 
El proyecto se ha realizado con Spring Boot, Spring Data y JPA. Como BBDD se ha utilizado MySQL. 
Para probar la persistencia habría que crear una conexion con la BBDD con las propiedades 
que se indican en el application.properties, con rest como nombre del esquema de BBDD.
Las pruebas del proyecto se pueden realizar con Postman:

Headers: Content-Type ---> application/json
POST: http://localhost:8080/api/user/ (con valores en el Body)
GET:  http://localhost:8080/api/user/{id}
GET (all): http://localhost:8080/api/user
PUT: http://localhost:8080/api/user (con el valor del id a modificar en el Body)
DELETE: http://localhost:8080/api/user/{id}

