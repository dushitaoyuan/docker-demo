# 基于 alpine 构建 oracle-java8镜像

## 构建流程

* 下载 alpine

```shell
docker pull alpine:latest
```

* 下载 oracle jdk   [完整版jdk8(https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

  [jre8](https://www.java.com/en/download/manual.jsp)

* 下载 alpine glibc 文件 [glibc3.2](https://github-production-release-asset-2e65be.s3.amazonaws.com/33333969/946dab00-c1b4-11e9-987e-da37e3103482?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIWNJYAX4CSVEH53A%2F20191210%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20191210T025057Z&X-Amz-Expires=300&X-Amz-Signature=382969fe40830a64ac18a0e38a0751a15a787e2a040a8d2e2e8dcb15b4c16c68&X-Amz-SignedHeaders=host&actor_id=18512626&response-content-disposition=attachment%3B%20filename%3Dglibc-2.30-r0.apk&response-content-type=application%2Fvnd.android.package-archive)

* 编写dockerfile

  ```dockerfile
  FROM alpine:latest
  COPY glibc-2.30-r0.apk /usr/local/
  ADD jdk-8u231-linux-x64.tar.gz /usr/local/
  
  #glibc 安装
  RUN apk add --no-cache --allow-untrusted /usr/local/glibc-2.30-r0.apk \
  && rm -rf /usr/local/glibc-2.30-r0.apk
  
  #java 环境变量 设置
  
  ENV JAVA_HOME=/usr/local/jdk1.8.0_231
  ENV PATH ${PATH}:${JAVA_HOME}/bin
  ```

  

* 进入dockefile 目录执行构建

  ```shell
  docker build -t alpine-oracle-jdk8:latest .
  ```

  ## 构建说明

  1. 也可以对java目录进行瘦身处理

  