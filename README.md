# bookshelf-service-demo
Demo of a RESTful service implemented with Spring Boot, JPA, and H2 embedded database.

Once you build it with maven you can then run this application as a Spring Boot App.

There are at least a couple ways to run an application as a Spring Boot App:

1. In Eclipse, you can right-click the project and Choose Run As -> Spring Boot App.
2. You can also run the jar file from the command line.

Example:
```sh
java -jar bookshelf-service-0.0.1-SNAPSHOT.jar
```

The default port that this application runs on is 8081.

You can change the default port number in /src/main/resources/application.properties and you can also override the port number on the commandline at startup.  Example:

```sh
java -jar bookshelf-service-0.0.1-SNAPSHOT.jar --server.port=8083
```
