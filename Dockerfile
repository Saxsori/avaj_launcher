FROM alpine:latest

RUN apk update && apk add openjdk11 make

RUN mkdir -p /app

# COPY ./app-root/simulator /app

WORKDIR /app/

ENTRYPOINT [ "tail", "-f", "/dev/null" ]

