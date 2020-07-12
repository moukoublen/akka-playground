## Scala Akka playground

`docker-compose -f .docker/docker-compose.yml up --build`


`docker-compose -f .docker/docker-compose.yml down --volumes`


to scale the node `docker-compose -f .docker/docker-compose.yml up --scale node=10`

to get cluster status `curl http://localhost:9000/cluster/members`
