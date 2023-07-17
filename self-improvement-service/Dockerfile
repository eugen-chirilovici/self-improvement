FROM --platform=linux/x86_64 eclipse-temurin:17-jre-alpine
LABEL groupId="com.echirilovici" application="self-improvement-service"
EXPOSE 8080

ARG MONGODB_DRIVER_VERSION=4.9.1
ARG MONGODB_DRIVER="https://repo1.maven.org/maven2/org/mongodb/mongodb-driver-core/${MONGODB_DRIVER_VERSION}/mongodb-driver-core-${MONGODB_DRIVER_VERSION}.jar"
ARG MONGODB_DRIVER_SYNC="https://repo1.maven.org/maven2/org/mongodb/mongodb-driver-sync/${MONGODB_DRIVER_VERSION}/mongodb-driver-sync-${MONGODB_DRIVER_VERSION}.jar"
ARG MONGODB_BSON="https://repo1.maven.org/maven2/org/mongodb/bson/${MONGODB_DRIVER_VERSION}/bson-${MONGODB_DRIVER_VERSION}.jar"
ARG MONGODB_REACTIVE_DRIVER="https://repo1.maven.org/maven2/org/mongodb/mongodb-driver-reactivestreams/${MONGODB_DRIVER_VERSION}/mongodb-driver-reactivestreams-${MONGODB_DRIVER_VERSION}.jar"

ARG CONTAINER_LIB_PATH="/opt/java/openjdk/lib"
ADD --chmod=644 ${MONGODB_DRIVER} ${CONTAINER_LIB_PATH}
ADD --chmod=644 ${MONGODB_DRIVER_SYNC} ${CONTAINER_LIB_PATH}
ADD --chmod=644 ${MONGODB_BSON} ${CONTAINER_LIB_PATH}
ADD --chmod=644 ${MONGODB_REACTIVE_DRIVER} ${CONTAINER_LIB_PATH}

COPY target/self-improvement-service-*.jar /opt/app/self-improvement-service.jar

ENTRYPOINT ["java","-jar","/opt/app/self-improvement-service.jar"]
