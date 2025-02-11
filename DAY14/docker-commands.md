# List of docker commands

## Docker container command

### Docker version

    docker version

### List active docker container

    docker ps

### List all docker container

    docker ps -a

### Get all container ID

    docker ps -aq

### Stop all docker container all docker container

    docker stop $(docker ps -aq)

### Delete all docker container

    docker rm $(docker ps -aq)

### stop docker container

    docker stop <conrainer_id>

### start docker container

    docker start container_id

### Restart running docker container

    docker restart container_id

### Log the docker container

    docker logs container_id

### Access the running docker container

    docker exec -it <conytainer_id> /bin/bash

### Inspect container to verify all details

    docker inspect container_id

## Docker image commands

### Build your docker image

    docker build -t <name> .

### Download the docker image

    docker pull <image>
### Login to docker hub

    docker login -u <user-name>

### Upload the docker image

    docker push <image>

### Delete all docker images

    docker rmi $(docker images -q) -f

### Remove dangling 

    docker images prune -a -f

### List all docker images

    docker images

### Delete docker image

    docker rmi <image_id>

## Docker Networks Command

### List Docker Network

    docker network ls

### Create docker network

    docker network create <network_name>

### Delete all networks

    docker network rm $(docker network ls -q)

## Docker volume command

### List available volume  in docker

    docker volume ls

### Create new volume

    docker volume create

### Remove all volumes

    docker volume rm $(docker volume ls -q)

## Docker compose command

### Start the all service defined

    docker-compose up

### If docker compose file is other the standard (docker-compose.yml)

    docker-compose -f <file_name> up

### Stop and remove all docker running container and service network

    docker-compose down

    docker-compose -f <file_name> down


