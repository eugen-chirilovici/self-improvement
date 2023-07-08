FROM liquibase/liquibase:4.19

ARG LIQUIBASE_VERSION=4.19.1
ARG MONGODB_DRIVER_VERSION=4.9.0
ARG JACKSON_VERSION=2.14.2

ADD --chown=liquibase:liquibase "https://repo1.maven.org/maven2/org/liquibase/ext/liquibase-mongodb/${LIQUIBASE_VERSION}/liquibase-mongodb-${LIQUIBASE_VERSION}.jar" /liquibase/classpath/liquibase-mongodb.jar
ADD --chown=liquibase:liquibase "https://repo1.maven.org/maven2/org/mongodb/mongodb-driver-core/${MONGODB_DRIVER_VERSION}/mongodb-driver-core-${MONGODB_DRIVER_VERSION}.jar" /liquibase/classpath/mongodb-driver-core.jar
ADD --chown=liquibase:liquibase "https://repo1.maven.org/maven2/org/mongodb/mongodb-driver-sync/${MONGODB_DRIVER_VERSION}/mongodb-driver-sync-${MONGODB_DRIVER_VERSION}.jar" /liquibase/classpath/mongodb-driver-sync.jar
ADD --chown=liquibase:liquibase "https://repo1.maven.org/maven2/org/mongodb/bson/${MONGODB_DRIVER_VERSION}/bson-${MONGODB_DRIVER_VERSION}.jar" /liquibase/classpath/bson.jar
ADD --chown=liquibase:liquibase "https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-annotations/${JACKSON_VERSION}/jackson-annotations-${JACKSON_VERSION}.jar" /liquibase/classpath/jackson-annotations.jar
ADD --chown=liquibase:liquibase "https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-core/${JACKSON_VERSION}/jackson-core-${JACKSON_VERSION}.jar" /liquibase/classpath/jackson-core.jar
ADD --chown=liquibase:liquibase "https://repo1.maven.org/maven2/com/fasterxml/jackson/core/jackson-databind/${JACKSON_VERSION}/jackson-databind-${JACKSON_VERSION}.jar" /liquibase/classpath/jackson-databind.jar

ARG SERVICE_DOMAIN_NAME='self-improvement'
ARG DB_ARTIFACT_REGEX="${SERVICE_DOMAIN_NAME}-db-*[0-9].jar"

COPY --chown=liquibase:liquibase "target/${DB_ARTIFACT_REGEX}" "/liquibase/classpath/${SERVICE_DOMAIN_NAME}-db.jar"
COPY --chown=liquibase:liquibase target/classes/liquibase.properties /liquibase/liquibase.docker.properties

RUN echo '' >> /liquibase/liquibase.docker.properties && echo "classpath=/liquibase/changelog:/liquibase/classpath:/liquibase/classpath/jackson-annotations.jar:/liquibase/classpath/${SERVICE_DOMAIN_NAME}-db.jar:/liquibase/classpath/jackson-core.jar:/liquibase/classpath/jackson-databind.jar:/liquibase/classpath/liquibase-mongodb.jar:/liquibase/classpath/mongodb-driver-core.jar:/liquibase/classpath/mongodb-driver-sync.jar:/liquibase/classpath/bson.jar" >> /liquibase/liquibase.docker.properties
