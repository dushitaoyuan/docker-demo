# docker-demo

## docker 集成java开发小例子

### dockerdemo 
单体 springboot 配合idea 部署到docker主机

```shell
1. idea docker 预览脚本
docker build -f Dockerfile-jre -t dockerdemo-jre:01 .
&& docker run
-p localhost:3600:8080
--name dockerdemo-service
dockerdemo-jre:01 
```


