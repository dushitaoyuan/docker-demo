# 基于 alpine 构建 oracle-jre8镜像

## 构建流程

* 下载 alpine

```shell
docker pull alpine:latest
```

* 下载 oracle jre   [jre下载路径](https://www.java.com/en/download/manual.jsp)

* 下载 alpine glibc 文件 [glibc3.2](https://github-production-release-asset-2e65be.s3.amazonaws.com/33333969/946dab00-c1b4-11e9-987e-da37e3103482?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIWNJYAX4CSVEH53A%2F20191210%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20191210T025057Z&X-Amz-Expires=300&X-Amz-Signature=382969fe40830a64ac18a0e38a0751a15a787e2a040a8d2e2e8dcb15b4c16c68&X-Amz-SignedHeaders=host&actor_id=18512626&response-content-disposition=attachment%3B%20filename%3Dglibc-2.30-r0.apk&response-content-type=application%2Fvnd.android.package-archive)

* 编写dockerfile

  ```dockerfile
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
  ```

  

* 进入dockefile 目录执行构建

  ```shell
  docker build -t alpine-oracle-jre8:latest .
  ```

  ## 构建说明

  

  1.也可以对java目录进行瘦身处理

  ##  jre 瘦身说明
  
  * 解压 jre
  
  * 进入 jre目录
  
  * 删除非必须文件,并重新压缩
  
    ```shell
    #删除
    rm -rf COPYRIGHT LICENSE README release THIRDPARTYLICENSEREADME-JAVAFX.txtTHIRDPARTYLICENSEREADME.txt Welcome.html
    rm -rf     lib/plugin.jar \
               lib/ext/jfxrt.jar \
               bin/javaws \
               lib/javaws.jar \
               lib/desktop \
               plugin \
               lib/deploy* \
               lib/*javafx* \
               lib/*jfx* \
               lib/amd64/libdecora_sse.so \
               lib/amd64/libprism_*.so \
               lib/amd64/libfxplugins.so \
               lib/amd64/libglass.so \
               lib/amd64/libgstreamer-lite.so \
               lib/amd64/libjavafx*.so \
               lib/amd64/libjfx*.so
               
     #压缩
     tar zcvf jre1.8.0_231.tar.gz jre1.8.0_231
    ```
  
    
  
    