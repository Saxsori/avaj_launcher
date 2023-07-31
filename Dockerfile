FROM maven:3.8.4-openjdk-11

COPY ./tools/settings.xml /root/.m2/settings.xml

RUN mkdir -p /app

# COPY ./app-root/simulator /app

WORKDIR /app

# RUN mvn clean install && mvn clean package

# ENTRYPOINT ["java", "--module-path=/javafx-sdk-17.0.7/lib", "-jar", "target/app-1.0-SNAPSHOT.jar"]

ENTRYPOINT [ "tail", "-f", "/dev/null" ]

