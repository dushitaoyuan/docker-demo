#!/bin/sh
APP_DIR="/opt/java/"
cd $APP_DIR
JAR_NAME=`ls ./ | grep .jar$`
JAVA_OPS="-Dthin.root=. -server"

#启动程序
function start() {
   java $JAVA_OPS -jar  $JAR_NAME
}
# 判断进程是否存活
function isAlive() {
# alpine 容器查询 进程id方法
    local pid=`ps aux | grep JAR_NAME |grep -v "grep" | grep  $JAR_NAME | awk '{ print $1 }'`
    if [ -z $pid ];then
       echo 0
    else
      echo $pid
    fi
}


case $1 in
    "start" ) start;;
    "isAlive" ) isAlive;;
    * ) echo "$0 start"
        echo "$0 isAlive"
esac
exit 0