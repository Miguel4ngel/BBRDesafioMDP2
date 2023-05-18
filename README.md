# Desafío Spring boot Medios de Pago

Tecnologías involucradas: Spring Boot, Rest, jpa, h2 y Swagger

El desafío consiste en las siguientes etapas:


1. - Configurar y correr el proyecto Spring Boot BBRDesafioMDP
    	-   Actualmente se encuentra presentando una excepción
    	
2. - Existe un servicio REST al que llamaremos generador de transacciones (trx) el cual permite insertar transacciones en una base de datos en memoria
		- Se puede acceder a él mediante el siguiente endpoint http://localhost:8080/api/v1/desafio/mdp/create
		- Se deben incorporar 2 nuevos campos (user y datetrx) los cuales deben ser persistidos en la tabla TRANSACTIONS y retornados en la respuesta del servicio
    	- La base de datos es h2 y se encuentra en memoria
    	- Los campos (commerce y user deben ser llenados con sus respectivas propiedades en el archivo application.properties )
		- El campo (datetrx) debe ser llenado con la fecha y hora actual del sistema
Este es un ejemplo de la respuesta actual que entrega este servicio:

```json
{
  "id": 21,
  "commerce": "BBR Spa",
  "amount": 10241,
  "type": "CHEQUE"
}
```

Así debería ser la respuesta del servicio después de las modificaciones:

```json
{
  "id": 21,
  "commerce": "BBR Spa",
  "amount": 10241,
  "type": "CHEQUE"
  "user": "uBBR",
  "datetrx": "2022-03-03T18:32:50.320+00:00"
}
```
3. - Crear un nuevo servicio basado en método GET 
		- EL endpoint debe llamarse search ejemplo: http://localhost:8080/api/v1/desafio/mdp/search
		- Debe recibir como parámetro el tipo de medio de pago (DEBITO, CREDITO, CHEQUE o EFECTIVO) y buscar en la tabla TRANSACTIONS, filtrando el resultado según el parámetro recibido
		- En caso de no recibir ningún parámetro debe listar todos los registros insertados
    	
Así debería ser la respuesta del servicio search sin filtrar:  

```json  	
[
  {
	  "id": 1,
	  "commerce": "BBR Spa",
	  "amount": 3700,
	  "type": "DEBITO"
	  "user": "uBBR",
	  "datetrx": "2022-03-03T18:32:50.320+00:00"
  },
  {
	  "id": 2,
	  "commerce": "BBR Spa",
	  "amount": 15000,
	  "type": "CHEQUE"
	  "user": "uBBR",
	  "datetrx": "2022-03-03T18:33:50.320+00:00"
  },
  {
	  "id": 3,
	  "commerce": "BBR Spa",
	  "amount": 5000,
	  "type": "CREDITO"
	  "user": "uBBR",
	  "datetrx": "2022-03-03T18:34:50.320+00:00"
  }
]
```
4. - Documentar los servicios create y search implementando Swagger 


REQUISITOS:
-   La solución debe ser enviada vía pull request a este repositorio.
-   La solución debe contener un README.md con las instrucciones para compilar e instalar en caso de incorporar componentes adicionales.
- Por último en el detalle del commit debes indicar los siguientes datos
   - Nombre Completo.
   - Correo Electrónico.

NOTA:
Todos los pull requests serán rechazados, esto no quiere decir que ha sido rechazada la solución, sino que es una forma de que otros postulantes no copien tu código.



