# Bootstrap Java Backend

A template repository for backend Java REST API server with a database

Stack: Ratpack Server, Postgres DB, Gradle, Docker, Shell

## Prerequisites

- [Java 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
- [Docker](https://docs.docker.com/get-docker/)

## Development

For Windows, use `gradlew.bat` instead of `./gradlew`

#### Refresh Gradle Dependencies & Build Source

```shell script
./gradlew --refresh-dependencies clean build -x test
```

#### Run Unit Tests

```shell script
./gradlew clean test
```

#### Refresh & List Gradle Dependencies without Building Source 

```shell script
./gradlew dependencies --refresh-dependencies
```

## Running

#### Start Application

This will boot up the entire application along with DB by performing the following tasks in the given order:
  - Build the source code
  - Run unit tests
  - Build backend-api docker image
  - Build and start Postgres and Postgres Admin containers
  - Start backend-api server container

Make sure you have `DATA_DIR` environment variable set. This directory will be used as a persistent 
volume mount for Postgres DB.

```shell script
./gradlew fireUp
```

This will start three containers on same virtual network. Postgres Admin console will be available on 
`http://localhost:5433` and REST API server will be available on `http://localhost:5050`

To inspect the network use the following command:
```shell script
docker inspect <container-name> -f "{{json .NetworkSettings.Networks }}" | jq .
```

Here, `<container-name>` can be one of the three, {`backend-api`, `postgres-db`, `postgres-admin`} and 
[`jq`](https://stedolan.github.io/jq/download/) is just used to format the json output.

#### Stop Application

```shell script
./gradlew shutDown
```

#### Build Backend API Docker Image

```shell script
./gradlew buildDockerImage
```

#### Start REST API Server (only API server, no DB)

```shell script
./gradlew runServer
```
