# java 环境准备
FROM dushitaoyuan/alpine-oracle-java8:jdk
# 设置时区
ENV TZ='Asia/Shanghai'

RUN mkdir -p /opt/java

ADD target/thin/root /opt/java/
ADD docker/start.sh /opt/java/
RUN dos2unix /opt/java/start.sh
#启动
EXPOSE 8080
CMD ./opt/java/start.sh start
