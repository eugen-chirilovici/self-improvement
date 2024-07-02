
```shell
# get pet
curl --location 'http://localhost:8080/pets'
```

```shell
# post pet
curl --location 'http://localhost:8080/pets' \
--header 'Content-Type: application/json' \
--data '{
    "name": "E1"
}'
```