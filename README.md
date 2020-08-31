### Microservices with Spring Boot

**I. Architecture Design.**
  
  ![Architecture](./screenshots/Artchitecture.png)
  
**II. Services**

1. Naming Server - This is a Eureka Service
2. Api Gateway -  This is a Zuul Service
3. Auth Service - This is a Spring Boot Web service
4. Currency Exchange Service - This is a Spring Boot Web service
5. Currency Conversion Service  - This is a Spring Boot Web service

**III. How to run**

Run the Naming Server, Api Gateway, Auth Service, Currency Exchange, Currency Conversion Service in order. 

- Naming Server [http://localhost:8761/](http://localhost:8761/)
- Api Gateway: [http://localhost:8765/](http://localhost:8765/)
- Auth Service: [http://localhost:9100/](http://localhost:9100/)
- Currency Exchange Service: [http://localhost:8000/](http://localhost:8000/)
- Currecy Conversion Service: [http://localhost:8100/](http://localhost:8100/)

**Run Auth Service to get th JWT token**
![](./screenshots/auth-service.png)
**Run Currency Exchange Service Standalone**
![](./screenshots/currency-exchange-single.png)
**Run Currency Exchange via Api Gateway using JWT token from Auth Service**
![](./screenshots/currency-exchange-via-api-gateway.png)
**Run Currency Conversion Service via API Gateway using JWT token from Auth Service**
![](./screenshots/currency-conversion-via-api-gateway.png)

**REFERENCES**

- https://www.udemy.com/course/microservices-with-spring-boot-and-spring-cloud/
- https://medium.com/omarelgabrys-blog/microservices-with-spring-boot-intro-to-microservices-part-1-c0d24cd422c3 
- https://stackoverflow.com/questions/36359915/authorization-header-not-passed-by-zuulproxy-starting-with-brixton-rc1
- https://medium.com/@IlyasKeser/feignclient-interceptor-for-bearer-token-oauth-f45997673a1
- https://www.baeldung.com/spring-mvc-handlerinterceptor
- https://spring.io/guides/topicals/spring-security-architecture/

