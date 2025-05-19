
FROM eclipse-temurin:24 AS build


ARG MAVEN_VERSION=3.9.7
RUN apt-get update && apt-get install -y wget tar && \
    wget https://downloads.apache.org/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz && \
    tar -xzf apache-maven-${MAVEN_VERSION}-bin.tar.gz -C /opt && \
    ln -s /opt/apache-maven-${MAVEN_VERSION}/bin/mvn /usr/bin/mvn


WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests


FROM eclipse-temurin:24-jre

WORKDIR /app
COPY --from=build /app/target/pokemonmovebackend-0.0.1-SNAPSHOT.jar demo.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "demo.jar"]