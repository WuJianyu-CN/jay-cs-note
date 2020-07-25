# TCP 

## TCP 三次握手 

![image-20200722170737339](interview_note.assets/image-20200722170737339.png)

RTT = 1.5

## TCP 四次挥手

![image-20200722170839929](interview_note.assets/image-20200722170839929.png)

RTT = 2

## LTS 建立安全链接

**LTS 1.2 版本：** RTT = 1.5

浏览器 **Client** 和 服务器 **Server** 之间建立安全链接的过程

1. 浏览器给服务器发送的 **Client Hello** 消息（一去）

2. 服务器给浏览器发送的 **Server Hello** 消息（二回）（包含 Key Exchange）
3. 浏览器给服务器发送的 **Key Exchange** 消息（三去）

![image-20200722170140045](interview_note.assets/image-20200722170140045.png)



**LTS 1.3 版本：** RTT = 1

浏览器 **Client** 第一次就把自己的密钥交换 （**Key Exchange**） 的素材发给服务器 **Server**。