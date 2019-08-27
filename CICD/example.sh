# Page 3
docker pull ubuntu

docker run ubuntu "printenv"

docker run --name my_container ubuntu 

docker ps

docker ps -a

docker run --name my_container ubuntu "printenv"

docker rm my_container

#interactive terminal 
docker run --name my_container -it ubuntu /bin/bash

#Start a new terminal window
docker exec my_container "printenv"

docker stop my_container

docker start my_container

docker exec -it my_container /bin/bash

# Page 2

docker build -t my_image .

# Page 3

docker build --build-arg ARG_1=world -t my_image .

docker run my_image "printenv"