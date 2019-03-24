#/bin/bash

cd blog-server
mvn clean package -U -Dmaven.test.skip

cd ..

docker image build -t blog.heleeos.com .

docker run -it -p 5000:80 blog.heleeos.com