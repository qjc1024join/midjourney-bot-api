- 使用SpringBoot 3.x+JDK17实现 midjourney接入功能
- 最近发现很多人不知道如何接入midjourney绘图，因此我开发了这个中间件

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

![image.png](https://cdn.nlark.com/yuque/0/2023/png/21704577/1683654109570-3baee4f8-2fd0-4fbf-a544-ef29bd281927.png)



## 安装部署

以下方案针对于Linux服务器：

- 安装JDK17环境 此处可以不按照我的方式来 

  下载 *wget h*ttps://download.java.net/openjdk/jdk17/ri/openjdk-17+35_linux-x64_bin.tar.gz

  安装jdk环境 参考 https://note.youdao.com/s/btPICkAZ

  然后sh service.sh start 

