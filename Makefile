# Makefile for DealCluster

# vars
JAR=target/dealcluster-0.0.1-SNAPSHOT.jar
PORT?=8080

.PHONY: all build test run docker-up docker-down clean coverage

all: build

build:
	mvn clean package -DskipTests

test:
	mvn test

coverage:
	mvn jacoco:report

run: build
	java -jar $(JAR) --server.port=$(PORT)

docker-up:
	docker compose up --build -d

docker-down:
	docker compose down --volumes

clean:
	mvn clean
	docker compose down --volumes
