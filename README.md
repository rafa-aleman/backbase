# backbase

#Repository
https://github.com/rafa-aleman/backbase

#Requirrements
* JDK 8+
* Maven 3.2.5+

#Build
mvn clean package

#Deployment
java -jar application-web/target/application-web-1.0.0.jar --server.port=8989

#Execution
Open a brower the url:

Get info of the application:
http://localhost:8989/info  

Get the info of the atms
http://localhost:8989/atms/ing 
Will be need user and password (u:user p:passwrod)
