eureka.tar.gz:
	docker build -t eureka . 
	docker save eureka|gzip -c > eureka.tar.gz

all: eureka.tar.gz
