# docker-demo

## docker 集成java开发小例子

### dockerdemo 
单体 springboot 配合idea 部署到docker主机


* dockerdemo/docker 为dockerfile文件路径
* dockerdemo/docker/Dockerfile-jre 使用jre8镜像部署
* dockerdemo/docker/Dockerfile 使用jdk8镜像部署
* dockerdemo/docker/start.sh 为镜像启动脚本,(包含启动,状态监测)

```shell
1. idea docker 预览脚本
docker build -f Dockerfile-jre -t dockerdemo-jre:01 .
&& docker run
-p localhost:3600:8080
--name dockerdemo-service
dockerdemo-jre:01 
```

idea部署图:</br>
![avatar](https://github.com/dushitaoyuan/docker-demo/blob/master/imgs/idea-docker-deploy.png)

程序运行结果:</br>

![avatar](https://github.com/dushitaoyuan/docker-demo/blob/master/imgs/dockerdemo-result.png)



