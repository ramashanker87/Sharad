## Spring Basic Security

### Build Maven Project

```bash
    mvn clean install
```
### Start Project

```bash
    mvn spring-boot:run
```

### Actuator endpoint with curl (works with command prompt)

    curl --location http://localhost:8080/actuator/health -u patient1:password1

### Test REST endpoint with curl (works with command prompt)

#### Create Patient Record Using POST Method

    curl -X POST -H "Content-type:application/json" \ 
        --data-binary "{\"name\":\"patient1\", \"id\":\"p1\", \"hospitalName\":\"hospital1\", \"age\":40, \"gender\":\"F\"}" \ 
        http://localhost:8080/patient/create/patient -u doctor1:password1
    
    Sample JSON Data:

    {
     "name":"patient1",
     "id": "p1",
     "hospitalName":"hospital1",
     "age": 20,
     "gender": "M"
    }

#### Read All Patient Records Using GET Method

    curl --location "http://localhost:8080/patient/get/all/patient" -u patient1:password1

#### Read Specific Patient Record With Parameter ID Using GET Method

    curl --location "http://localhost:8080/patient/get/patient?id=p1" -u patient1:password1

#### Update Specific Patient Record With Parameters ID and Age Using PUT Method

    curl --location --request PUT "http://localhost:8080/patient/update/patients?id=p2&age=31" -u doctor1:password1

#### Delete Specific Patient Record With Parameter ID Using DELETE Method

    curl --location --request DELETE "http://localhost:8080/patient/delete/patients?id=p2" -u doctor1:password1