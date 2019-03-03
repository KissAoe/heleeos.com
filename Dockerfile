############################################################
# Dockerfile to build Blog
# Based on kissaoe/java-node-alpine
############################################################

# 使用 jre8 基础镜像
# FROM kissaoe/java-node-alpine:1.0.0
FROM java-node
LABEL maintainer "KissAoe <kissaoe@gmail.com>"

# 复制应用到 app 目录中
COPY ./blog-service/target/heleeos-service.jar /app/
COPY ./blog-manager/dist /app/blog-manager

# 复制 nginx 文件
COPY ./nginx/blog.nginx.conf /etc/nginx/conf.d/blog.nginx.conf
RUN rm -f /etc/nginx/conf.d/default.conf

# 暴露给外部的端口
EXPOSE 3000 6000 8000

# 启动应用
CMD "java -jar /app/heleeos-service.jar"