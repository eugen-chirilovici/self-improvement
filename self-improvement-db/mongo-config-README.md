### Follow the guide

enter the mongo-db container

```shell
docker exec -it 'docker_id' bash
```

log in mongo shell

```
mongosh admin -u root -p 'secret' (same u & p as in resource-compose.yaml spec)
```

create user and attach it to self-db, which is used by liquibase config

```mongodb-json
self_db = db.getSiblingDB("self-db");
self_db.createUser({
    user: "self_user",
    pwd: "self_pwd",
    roles: [
      {
        role: "dbOwner",
        db: "self-db"
      }
    ]
});
```

run the migration 

```shell
mvn liquibase:update
```

### Useful information
* [Introduction to MongoDB](https://www.mongodb.com/docs/manual/introduction/)
* [How to Create a Postgres Database in Docker](https://1kevinson.com/how-to-create-a-postgres-database-in-docker/)