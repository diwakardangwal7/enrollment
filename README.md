# enrollment
Enrollment is a spring boot based microservice for tracking the status of enrollees in a health care program.

Prerequisites To Run the Microservice
1. Maven
2. Java Run Time
3. Mongo DB Installation
4. Docker and Kubernetes (If needed to execute as standalone pod of microservice for scaling)


Steps: 
1. Download the code zip file or clone from github 
2.  Lets say D:\sample is the filepath where file is unzipped.
3 Please ensure to configure below mongo DB properties mentioned in the application.properties (src\main\resources\application.properties)
If mongo db is installed locally localhost will work otherwise IP can be provided. Default port is 27017 and DB name is enrollment. Collections will be created inside this DB automatically when we perform create operation from API.

spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=enrollment

4. Open command prompt and  Run mvn clean install (Please make sure that maven is in path)
https://user-images.githubusercontent.com/53266389/93021254-5e8d3700-f5ff-11ea-841a-096956393a25.png

4. Executable jar will be present in D:\Sample\enrollment-master\target

Run below command from D:\Sample\enrollment-master\target
java -jar enrollmentservice-0.0.1-SNAPSHOT.jar
 

Now the embedded tom cat server is started and microservice is up and running. Documentation for API can be checked using Swagger by hitting below url.
http://localhost:8080/enrollment/swagger-ui/

 
