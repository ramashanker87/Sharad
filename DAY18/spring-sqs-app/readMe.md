
## Spring Boot SQS Application with Two MicroServices - Patient and Doctor App


### On parent project spring-sqs-application
```
mvn clean install
```

### Start localstack container using docker-compose
```
docker-compose up
```

### Start microservice patient-sqs-app
```
mvn spring-boot:run
```

### Send Post API request using postmane
```
url: http://localhost:8081/patient/send
```
Json Type:
```
{
"name": "John",
"id": "1",
"hospitalName": "NewHosptial",
"age": 25,
"gender": "M"
}
```
Header: disease
Value: fever

BasicAuth: username <patient>; password <password>

### Verity in localstack application whether the message in queue received

```
https://app.localstack.cloud/inst/default/resources/sqs/message-in-queue
```

### Start microservice doctor-sqs-app
```
mvn spring-boot:run
```

### Receive Get API request using postman
```
url: http://localhost:8082/doctor/receive
```
BasicAuth: username <doctor>; password <password>

### Verity in localstack application whether the message in deleted
```
https://app.localstack.cloud/inst/default/resources/sqs/message-in-queue
```

### To stop localstack container
```
docker-copose down
```