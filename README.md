Issue Tracker
==============================================
## Prerequisites
You need the following tools to build the project:
  * JDK 8 (**not 10**): http://www.oracle.com/technetwork/java/javase/downloads/index.html
  * Maven (3.5+ recommended): https://maven.apache.org/download.cgi
  
When everything is installed and `PATH` is configured, run `mvn -version` to make sure that it is using JDK 8.

## Building
Run the following command to build the project:
```
mvn clean install
```

## Running
Run the following command:
```
mvn exec:java
```

Open your web browser and visit http://localhost. If everything is fine, you should see `Hello, world`.
