# 基于酷Q的聊天机器人

## 简介

之前的web链接都已经失效，所以找到通过插件方式，对QQ进行增强服务开发。

## 系统架构

Spring Boot

Mybatis Plus

Redis

Jsoup

Httpclient

除了以上，还有酷Q的支持

## 启动

安装酷Q，然后登陆输入手机验证以后，就能不再验证，然后登陆以后会产生文件夹，找到config文件，配置localhost服务的访问：

```
"post_url": "http://127.0.0.1:8080/msg/receive",
```

以上完成了QQ对本地服务的访问，然后通过拿到的raw_message，根据关键字提取，群聊与私聊信息，根据群聊和私聊提供服务，比如群聊只能@触发，私聊则无需。