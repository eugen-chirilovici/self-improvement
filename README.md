
# Guide

#### !!! To run self-improvement-service on local machine is necessary to specify spring active profile _local_

#### For the first run, follow the guide _self-improvement-db/readme-mongo-config.md_

Start the container's application resources
```shell
cd ./docker/
docker-compose -f resource-compose.yaml up
```

Build the service image
```shell
cd ./self-improvement-service/
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
