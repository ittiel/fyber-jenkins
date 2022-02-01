# Jenkins on Docker example    

Dockerfile includes a section to add the relevant jobs.jobs for Fyber (see jobs.jobs.groovy):
1. Start the consul (server and agent) - Dockers on local network
2. CI for fyber-consul-service - Build the docker image locally
3. CD for the fyber-consul-service - Deploy the service as Docker on local machine

## Run Jenkins and Consul 
From shell script:
```
./environment-setup/start-env.sh

```

## Run Jenkins docker image locally: 
**without:**
- persistency
- authentication (for simplicity)
- docker in docker**
```
docker run -d -v /var/run/docker.sock:/var/run/docker.sock  -p 8080:8080 -p 50000:50000 ittiel/jenkins-fyber:1.0.0
``` 

## Build and Push Jenkins docker image
```
VERSION=1.0.0
docker build -t ittiel/jenkins-fyber:$VERSION .
docker push ittiel/jenkins-fyber:$VERSION
```