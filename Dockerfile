FROM maven:3.8.4-openjdk-11

COPY ./tools/settings.xml /root/.m2/settings.xml

RUN mkdir -p /app

# COPY ./app-root/simulator /app

WORKDIR /app/simulator

# RUN mvn clean install && mvn clean package

ENTRYPOINT [ "tail", "-f", "/dev/null" ]

