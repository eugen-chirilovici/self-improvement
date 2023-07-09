enter the docker

```shell
docker exec -it docker_id bash
```

log in mongo shell (useful link: https://www.mongodb.com/docs/manual/introduction/)

```
mongosh admin -u root -p 'secret' (same u & p as in compose.yaml spec)
```

create user and attach it to self-db, which is used by liquibase config

```
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
