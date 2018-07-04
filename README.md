# Spring integration with Kubernetes and Docker

Sample Spring Boot app packed into Docker image with Minikube deployment description.


# Docker 
konfiguracja w docker/dockerfile
najlepiej wykorzystywać alpine linux, który jest najmniejszym dostępnym obrazem linuxa w repo dockera.

Instalacja dockera na windows wymaga koniecznie: 
1. Instalacji z docker tools
2. wywołania: `docker-machine create box`
3. Wywoływania komend dockera z konsoli z uprawnieniami administratora


# Howto
1. Dockerize app http://www.baeldung.com/dockerizing-spring-boot-application#Dockerize
 Stworzyć obraz base alpine zawierający minimum po Spring boot:
Z katalogu:  <br />
`docker build --file=Dockerfile.alpine --tag=alpine-java:base --rm=true .`
2. Stworzyć obraz z mikroserwisem Spring boot:
`docker build --file=Dockerfile --tag=mg-kubernetes:latest --rm=true .`

3.  uruchommić obraz ze stworzonym mikroserwisem
`docker run --name=mg-kubernetes --publish=8080:8080 \
      config-server:latest`
4. 
