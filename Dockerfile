FROM openjdk:17-jdk-alpine
CMD ["echo", "Hello world"]
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY build/libs/shareLiving-0.0.1-SNAPSHOT.jar shareliving.jar
EXPOSE 80
# ENTRYPOINT exec java $JAVA_OPTS -jar shareliving.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar shareliving.jar
