FROM alpine:latest
COPY glibc-2.30-r0.apk /usr/local/
ADD jdk-8u231-linux-x64.tar.gz /usr/local/

#glibc 安装
RUN apk add --no-cache --allow-untrusted /usr/local/glibc-2.30-r0.apk \
&& rm -rf /usr/local/glibc-2.30-r0.apk

#java 环境变量 设置

ENV JAVA_HOME=/usr/local/jdk1.8.0_231
ENV PATH ${PATH}:${JAVA_HOME}/bin