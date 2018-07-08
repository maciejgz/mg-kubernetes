# Spring integration with Kubernetes and Docker
--master
Sample Spring Boot app packed into Docker image with Minikube deployment description.

# Docker 
Konfiguracja w docker/dockerfile.
Najlepiej wykorzystywać obraz alpine linux, który jest najmniejszym dostępnym obrazem linuxa w repo dockera.

Instalacja dockera na windows wymaga koniecznie: 
1. Instalacji z docker tools
2. Wywołania: `docker-machine create box`
3. Wywoływania komend dockera z konsoli wymagają uprawnień administratora

# Przygotowanie obrazów dockera i uruchomienie

1. Dockerize app http://www.baeldung.com/dockerizing-spring-boot-application#Dockerize
 Można stworzyć, ale niekoniecznie, obraz base alpine (prosty linux) zawierający minimum po Spring boot:
Z katalogu:  <br />
`docker build --file=Dockerfile.alpine --tag=alpine-java:base --rm=true .`

2. Stworzyć obraz z mikroserwisem Spring boot. dockerfile: /docker/Dockerfile <br />
`docker build --file=Dockerfile --tag=mg-kubernetes:latest --rm=true .` <br />
Pole tag to nazwa obrazu po której będziemy odwoływać się do konkrentej wersji.

3.  uruchommić obraz stworzony w punkcie 2
`docker run --name=mg-kubernetes --publish=8080:8080 mg-kubernetes:latest` <br />
port forwarding musi być ustawiony tak jak port w aplikacji

4. Kontener zostaje utworzony/apka uruchomiona pod adresem kontenera (z przekierowanym portem). Adres kontenera można odczytać w <br />
`docker container ls --all` <br /> 
przykład: <br />
`http://192.168.99.100:8080`



