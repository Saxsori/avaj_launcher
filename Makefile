IMAGE_NAME=avaj
CONTAINER_NAME=avaj

build :
	docker build -t $(IMAGE_NAME) .

run :
	docker run -it -d --rm -v ./simulator:/app  --name $(CONTAINER_NAME) $(IMAGE_NAME)

clean : stop
	docker rmi $(IMAGE_NAME)

stop :
	docker stop $(CONTAINER_NAME)

bash :
	docker exec -it $(CONTAINER_NAME) /bin/sh

all: build run bash