# Spring integration with Kubernetes and Docker
Sample Spring Boot app packed into Docker image with Minikube deployment description.

# Docker 
konfiguracja w docker/dockerfile
najlepiej wykorzystywać obraz alpine linux, który jest najmniejszym dostępnym obrazem linuxa w repo dockera.

Instalacja dockera na windows wymaga koniecznie: 
1. Instalacji z docker tools.
2. Wywołania: `docker-machine create box`
3. Wywoływania komend dockera z konsoli wymagają uprawnień administratora.

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

# kubernetes setup - minikube

1. Instalacja minikube http://www.baeldung.com/spring-boot-minikube<br />
**Ważne, żeby ustawić odpowiednie zmienne dokera w minikube, aby były widoczne obrazy lokalne wygenerowane w dockerze**:<br />
`minikube docker-env` <br />
Potem w power shellu:<br />
`& minikube docker-env | Invoke-Expression` <br />
lub w konsoli:<br />
`eval $(minikube docker-env)`<br />
Dzięki temu obrazy tworzone w doker lokalnym będą widoczne przez minikube. **Ważne, żeby ustawić zmienne i dopiero później dodawać obraz** i tylko wtedy będzie go widać w tym lokalnym repo. Wszystko trzeba wykonywać w jednej instancji konsoli.
Standardowo docker ma własną przestrzeń obrazów, którą można sprawdzić przez:<br />
`docker images`<br />

2. Z utworzonego obrazu (jak w punkcie 1.2) tworzymy deployment w minikube:<br />
`kubectl.exe run mg-kubernetes --image=mg-kubernetes:latest --port=8080 --image-pull-policy Never`

3. Wyrzucamy serwis na zewnątrz:<br />
`kubectl.exe expose deployment mg-kubernetes --type=NodePort`

4. Aplikacja powinna być dostępna pod adresem wirtualki minikube i porcie pokazanym pod komendą:<br />
`kubectl.exe get services`<br />
np.<br />
`http://192.168.99.101:30322/actuator/health`


# kubernetes - konfiguracja klastrów
- można ręcznie pisać YAMLe do tworzenia deploymentów, podów i serwisów i łądować je kubectl poprzez komendę<br />
`kubectl.exe create -f <plik>`<br />
daje to więcej możliwości konfiguracji

MAIN CHANGES


# TODO:<br />
- SIDE update samego image oraz podmianki image w deploymencie kubernetesa
- update strategies - różne rodzaje
- dodać do repo yamle i przerobić sposób deploymentu na podstawie konfiguracji YAML


