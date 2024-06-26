
# Guide

#### !!! To run self-improvement-service on local machine is necessary to specify spring active profile _local_

#### For the first run, follow the guide _self-improvement-db/readme-mongo-config.md_

Start the container's application resources
```shell
cd ./docker/
docker-compose -f resource-compose.yaml up
```

Build the latest service image
```shell
cd ./self-improvement-service/
mvn clean install
docker build -t self-improvement-app-image .
```

Start the application itself into container
```shell
cd ./docker/
docker-compose -f service-compose.yaml up
```

Maven wrapper plugin config:
```bash
mvn -N wrapper:wrapper -Dmaven=3.9.3
```

Swagger [link](http://localhost:9090/actuator/webjars/swagger-ui/index.html)

OpenApi spec [link](http://localhost:9090/actuator/openapi/springdocDefault)

## Useful information
* [OpenAPI Guide](https://swagger.io/docs/specification/about/)
* [springdoc-openapi Actuator support](https://springdoc.org/v1/#actuator-support)
* [Swagger-Open API to Spring Boot 3 Application(Web Flux)](https://pranavkhodanpur.medium.com/swagger-open-api-to-spring-boot-3-application-web-flux-2e99bb112151)
* [Monitoring and Management over HTTP](https://docs.spring.io/spring-boot/docs/2.1.1.RELEASE/reference/html/production-ready-monitoring.html)
* [Spring Boot: Client - and server code generation using OpenAPI 3 Specs](https://blog.palo-it.com/en/spring-boot-client-and-server-code-generation-using-openapi-3-specs)
* [Generate Server Code Using OpenAPI Generator](https://mydeveloperplanet.com/2022/02/08/generate-server-code-using-openapi-generator/)
* [API-First with Spring WebFlux and OpenAPI Generator](https://boottechnologies-ci.medium.com/api-first-with-spring-webflux-and-openapi-generator-38b7804c4ed4)
* [3 techniques to stream JSON in Spring WebFlux](https://nurkiewicz.com/2021/08/json-streaming-in-webflux.html)
* [One-Stop Guide to Mapping with MapStruct](https://reflectoring.io/java-mapping-with-mapstruct/)
* [Spring Boot @WebFluxTest and WebTestClient with JUnit 5](https://howtodoinjava.com/spring-boot2/testing/webfluxtest-with-webtestclient/)
* [Writing Unit Test in Reactive Spring Boot Application](https://medium.com/@BPandey/writing-unit-test-in-reactive-spring-boot-application-32b8878e2f57)
* [Spring Tips: Testing Reactive Code](https://www.youtube.com/watch?v=RPmTXiw-dHA&ab_channel=SpringDeveloper)


