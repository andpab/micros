# Simplistic example project for microservices with declarative REST clients

technologies demonstrated:
- Spring Boot
- Spring Cloud
- Spring MVC
- Netflix Eureka
- Netflix Feign
- JavaFX

Modules: 
- The **discovery** module is a simplistic service discovery
- The **supermarket-service** module is a microservice providing access to a REST repository resource
- The **pasta-service** module is a microservice offering a REST interface and utilizing another microservice via REST
- The **javafx-client** module is a JavaFX client application utilizing the above services via REST

