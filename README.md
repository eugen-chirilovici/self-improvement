
# Guide

#### !!! To run self-improvement-service on local machine is necessary to specify active profile 'local'

```shell
docker-compose up
```

```shell
cd ./self-improvement-service/
docker build -t self-improvement-app-image .

cd ../
docker-compose up
```

Maven wrapper plugin config:

```bash
mvn -N wrapper:wrapper -Dmaven=3.9.3
```
