FROM alpine:latest
COPY glibc-2.30-r0.apk /usr/local/
ADD jre1.8.0_231.tar.gz /usr/local/

#glibc 安装
RUN apk add --no-cache --allow-untrusted /usr/local/glibc-2.30-r0.apk \
&& rm -rf /usr/local/glibc-2.30-r0.apk \
&& chmod u+x /usr/local/jre1.8.0_231/bin/* 

#java 环境变量 设置

ENV JAVA_HOME /usr/local/jre1.8.0_231/
ENV PATH ${PATH}:${JAVA_HOME}/bin