# practice projects
- sandbox
	showcases simple h2 db usage, ComponentScan scan for Spring-managed components and register the corresponding beans
	Bean Scopes, singleton = default, prototype, request, session, application, websocket: ProtoService
	spring.profiles.active e.g.:dev, read property file config settings: FactoryDemoService
- web-app-main
	showcases spring amqp (Rabbit MQ, see RoomCleanerListener, AsyncConfig), 
	basic security at SecurityConfig.java
	spring data rest, spring web, thymeleaf, data-jpa, web, actuator, open-ai-webmvc-ui-lombok
	note: launch rabbitmq container set at docker-compose.yml
- web-app-second
	amqp client, sends messages to web-app-main, both apps need rabbitmq container running
- micro
	showcases a simple microservice demo, used to showcase apigateway
	it also showcases some actuator capabilities e.g: GreetingEndpoint
	as well as swagger-ui (e.g. swaggerHeader, springdoc.swagger-ui.path)
- apigateway
	showcases spring api-gateway usage
	application.yml setup and latest libraries
- authsrvr
	simple oauth 2 server ()
	https://spring.io/projects/spring-authorization-server#overview
- ldap 
	ldap sample

Spring Boot Projects
Spring offers many distinct projects for use with Spring Boot-based applications. These projects can be added to your application to enhance the functionality and improve your delivery speed of development.

Spring Data
Spring offers several different data access technologies to leverage in your Spring Boot application.

Spring Data JDBC: A very low-level implementation of Spring Data that autowires a Java DataSource into a JDBC template for use with raw SQL queries
Spring Data JPA: A Java Persistence API (JPA)-based implementation of Spring Data that implements dynamic, repository-based consumption of a relational database management system (RDBMS)
Spring Data LDAP: A repository-based implementation of Spring Data that allows for use with Lightweight Directory Access Protocol (LDAP) systems
Spring Data MongoDB: A repository-based implementation of Spring Data for use with MongoDB NoSQL databases
Spring Data Redis: A project with configuration and both low- and high-level abstractions for interacting with Redis as a data source
Spring Data Apache Cassandra: A repository-based implementation of Spring Data for use with Apache Cassandra NoSQL databases
Others: Spring Data R2DBC, Spring Data REST, Spring Data Couchbase, Spring Data Elasticsearch, Spring Data Neo4j

Spring Cloud
Spring offers several different cloud offerings, including hypervisor-specific abstractions and Netflix additions to the Spring ecosystem.

Spring Cloud Azure: Spring-focused abstractions and integrations with the Microsoft Azure hypervisor
Spring Cloud for Amazon Web Services: Spring-focused abstractions and integrations with the Amazon Web Services hypervisor
Spring Cloud Circuit Breaker: Spring abstraction of various implementation of the circuit breaker patterns for cloud-based systems
Spring Cloud Config: Spring client and server functionality for building and consuming externalized config in a cloud-native system using Spring Boot
Spring Cloud Function: An abstraction layer to enable the development of Spring Boot-based functions as service or serverless operations
Spring Cloud Gateway: A library for building an API gateway on top of WebFlux when the implementation of a packaged API gateway is not desired
Spring Cloud GCP: Spring abstractions and integration with the Google Cloud Platform hypervisor
Spring Cloud Open Service Broker: A framework for building Open Service Broker API-based Spring Boot applications
Others: Spring Cloud Alibaba, Spring Cloud Bus, Spring Cloud Consul, Spring Cloud Contract, Spring Cloud OpenFeign

HikariDataSource
a high-performance database connection pool implementation, part of the HikariCP library. 

Configure Two DataSources
https://docs.spring.io/spring-boot/how-to/data-access.html

docker run -p 8080:8080 -d booting



see a full list of all tomcat properties:
org.springframework.boot.autoconfigure.web.ServerProperties 

compression:
- `server.compression.enabled=true`


implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'org.apache.groovy:groovy'
	compileOnly 'org.projectlombok:lombok'
	runtimeOnly 'com.h2database:h2'
	annotationProcessor 'org.projectlombok:lombok'


Course Spring Security
use Bcrypt = industry standard !


Spring Actuator
provides insights into your running applications
provides configuration settings, usually thru JMX
allows to monitor running applications...
healh endpoint
	up/down status of app
	up/down status of dependencies
Beans
Env variables available to app
Info about services
Metrics details about running app 

## Security and Customization
- default is relatively locked down
- ensure its not publicly available
- only configure what you need
- customizable down to endpoint
- can be extended with custom endpoints
spring-boot-starter-actuator



Extend the actuator in a library class TODO!


When building a producer, what is one object that isn't needed but is needed for the consumer?

MessageListenerAdapter





https://hub.docker.com/_/rabbitmq

8080/swagger-ui/index.html


Spring security
https://docs.spring.io/spring-security/reference/servlet/oauth2/index.html
https://docs.spring.io/spring-security/reference/servlet/saml2/index.html



## The twelve-factor app is a methodology for building software-as-a-service apps that:

Use declarative formats for setup automation, to minimize time and cost for new developers joining the project;
Have a clean contract with the underlying operating system, offering maximum portability between execution environments;
Are suitable for deployment on modern cloud platforms, obviating the need for servers and systems administration;
Minimize divergence between development and production, enabling continuous deployment for maximum agility;
And can scale up without significant changes to tooling, architecture, or development practices.