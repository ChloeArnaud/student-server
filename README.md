# student-server
Cloud integration personal project

Commands to execute :
Build : ./gradlew build
Launch : ./gradlew bootrun

To launch the server locally: 
./gradlew bootJar
java -jar filepath

To launch the server on docker
Create the dockerfile
docker build --tag=server:latest .
docker run -d -p 8080:8080 server