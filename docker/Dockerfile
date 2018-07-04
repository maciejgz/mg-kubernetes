## server dockerfile
FROM alpine:edge
MAINTAINER mg

COPY files/mg-kubernetes.jar /opt/mg-kubernetes/lib/

RUN apk add --no-cache openjdk8

#ENTRYPOINT ["/usr/bin/java"]
CMD ["java", "-version"]
#CMD ["ls", "/opt/mg-kubernetes/lib/"]
CMD ["java", "-jar", "/opt/mg-kubernetes/lib/mg-kubernetes.jar"]


EXPOSE 8080
