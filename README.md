- 使用SpringBoot 3.x+JDK17实现 midjourney接入功能
- 最近发现很多人不知道如何接入midjourney绘图，因此我开发了这个中间件

## 开源不易



​                

老板打赏<img src="https://gitee.com/qi_jianchun/midjourney-bot-api/raw/master/source/%E8%B5%9E%E8%B5%8F%E7%A0%81.jpg" alt="赞赏码" style="zoom:10%;" />

## 项目背景介绍

### 需求产生

由于接入midjourney绘图，官方没有提供API接口，很多人问我怎么接入midjourney绘图，我通过文章查找以及抓取生成图片的接口，使用官方接口请求生成图片，通过Discord机器人监听频道获取信息，进行生成图片。实现了较简单的功能：

### 功能列表：

1.	GPT翻译。
2.	generate：生成图片。
3.	upscale：选中对应的图片变大。
4.	variation：选中其中的一张图，生成四张相似的。
5.	reset：按照你的提示词重新生成。
6.	 maxUpscale：后只有一张图返回，此时你是使用这张图再生成四张类似的。



### 配置信息 application.yml

```
discord:
  user-token: 用户token
  bot-token: 机器人token
  server-id: 服务id
  channel-id: 频道id
call-back:
  url: 回调地址

chatgpt:
  token: 用户token  chagpt的可以不填写此处用来翻译，也可以自己翻译好，之所以没有整合到一块，考虑着通用模块
```

### 获取配置信息

请看这篇文章

https://www.yuque.com/xiaoqi-vgsag/bn9t8h/wzg5kluuzzgd22m7?singleDoc# 《web服务接入discord midjourney》



### 项目流程图

![image.png](https://gitee.com/qi_jianchun/midjourney-bot-api/raw/master/source/image.png)



## 安装部署

以下方案针对于Linux服务器：

安装JDK17环境 此处可以不按照我的方式来 

```
cd /usr/local
wget https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.tar.gz
tar -zxvf jdk-17_linux-x64_bin.tar.gz #解压
mv jdk-17_linux-x64_bin jdk17 #修改名称
------------------------------------------------------
#配置jdk环境变量
#/etc/profile文件的改变会涉及到系统的环境，也就是有关Linux环境变量的东西
#所以，我们要将jdk配置到/etc/profile，才可以在任何一个目录访问jdk

vim /etc/profile

#按i进入编辑，在profile文件尾部添加如下内容
export JAVA_HOME=/usr/local/jdk17  #jdk安装目录
 
export JRE_HOME=${JAVA_HOME}/jre
 
export CLASSPATH=.:${JAVA_HOME}/lib:${JRE_HOME}/lib:$CLASSPATH
 
export JAVA_PATH=${JAVA_HOME}/bin:${JRE_HOME}/bin
 
export PATH=$PATH:${JAVA_PATH}

---------------------------------------------------------------
#Esc --> :wq
#保存并退出编辑
#通过命令source /etc/profile让profile文件立即生效
source /etc/profile #环境完成

java -version  #显示版本号说明成功
```

上传jar包

```

cd /usr/local/
mkdir project
cd project
将 jar包上传  source下的service.sh与application.yml 放在同级目录
vim application.yml  进行将那些记录的token  频道 卸载yml即可

sh service.sh start 
```

扫码体验mj

<img src="https://gitee.com/qi_jianchun/midjourney-bot-api/raw/master/source/%E5%B0%8F%E7%A8%8B%E5%BA%8F%E7%A0%81.jpg" alt="赞赏码" style="zoom:10%;" />