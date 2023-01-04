Spring Hibernate example
=

Small example how to use Hibernate ORM in Spring application.

It also shows the old way of configuring Spring Context for deployable `.war` - using XML.

## Technical information

| Piece of tech | Version |
|---------------|---------|
| Java          | 17      |
| Spring        | 5.3.x   |
| Hibernate     | 5.6.x   |

## Deploy

Examples were tested with Wildfly 26.1.2.

### Database

Even with this old-style example, I will still suggest you to use Docker to run PostgreSQL server.

#### Server

This was my container:

```shell
docker run -d --name postgres15 \
      -e POSTGRES_USER=REPLACE_WITH_ACTUAL_USER \
      -e POSTGRES_PASSWORD=REPLACE_WITH_ACTUAL_PASSWORD \
      --network=localnet \
      -p 5432:5432 \
      postgres:15-alpine
```

#### Schema and table

Pretty simple and straightforward script to create basic objects.

```postgresql
create database examples;

create schema examples.spring_hibernate;

create table if not exists examples.spring_hibernate.users
(
    id         serial  not null,
    first_name varchar not null,
    last_name  varchar not null
);

alter table examples.spring_hibernate.users
    owner to postgres;
```

## Endpoints

After deployment, see table with sample users under following endpoint:

```
http://localhost:8080/hibernate-examples-1.0.0-SNAPSHOT/
```
