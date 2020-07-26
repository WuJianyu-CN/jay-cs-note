

# 计算机网络

## TCP 

### TCP 三次握手 

![image-20200722170737339](interview_note.assets/image-20200722170737339.png)

RTT = 1.5

### TCP 四次挥手

![image-20200722170839929](interview_note.assets/image-20200722170839929.png)

RTT = 2

### LTS 建立安全链接

**LTS 1.2 版本：** RTT = 1.5

浏览器 **Client** 和 服务器 **Server** 之间建立安全链接的过程

1. 浏览器给服务器发送的 **Client Hello** 消息（一去）

2. 服务器给浏览器发送的 **Server Hello** 消息（二回）（包含 Key Exchange）
3. 浏览器给服务器发送的 **Key Exchange** 消息（三去）

![image-20200722170140045](interview_note.assets/image-20200722170140045.png)



**LTS 1.3 版本：** RTT = 1

浏览器 **Client** 第一次就把自己的密钥交换 （**Key Exchange**） 的素材发给服务器 **Server**。





## DHCP

`DHCP` 协议采用 `UDP` 作为传输协议，主机发送请求消息到 `DHCP` 服务器的 `67` 号端口，`DHCP` 服务器回应应答消息给主机的 `68` 号端口。详细的交互过程如下图。

![dhcp](interview_note.assets/clip_image002.jpg)



1. `DHCP Client` 以广播的方式发出 `DHCP Discover` 报文。

2. 所有的 `DHCP Server` 都能够接收到 `DHCP Client` 发送的 `DHCP Discover` 报文，所有的 `DHCP Server` 都会给出响应，向 `DHCP Client` 发送一个 `DHCP Offer` 报文。`DHCP Offer` 报文中 `Your(Client) IP Address` 字段就是 `DHCP Server` 能够提供给`DHCP Client` 使用的 `IP` 地址，且 `DHCP Server` 会将自己的 IP 地址放在 `option` 字段中以便 `DHCP Client` 区分不同的 `DHCP Server`。`DHCP Server` 在发出此报文后会存在一个已分配 `IP` 地址的纪录。

3. `DHCP Client` 只能处理其中的一个 `DHCP Offer` 报文，一般的原则是 `DHCP Client` 处理最先收到的 `DHCP Offer` 报文。`DHCP Client` 会发出一个广播的 `DHCP Request` 报文，在选项字段中会加入选中的 `DHCP Server` 的 `IP` 地址和需要的 `IP` 地址。
4. `DHCP Server` 收到 `DHCP Request` 报文后，判断选项字段中的IP地址是否与自己的地址相同。如果不相同，`DHCP Server` 不做任何处理只清除相应 `IP` 地址分配记录；如果相同，`DHCP Server` 就会向 `DHCP Client` 响应一个 `DHCP ACK` 报文，并在选项字段中增加 `IP` 地址的使用租期信息。 
5. `DHCP Client` 接收到 `DHCP ACK` 报文后，检查 `DHCP Server` 分配的 `IP` 地址是否能够使用。如果可以使用，则 `DHCP Client` 成功获得 `IP` 地址并根据 `IP` 地址使用租期自动启动续延过程；如果 `DHCP Client` 发现分配的 `IP` 地址已经被使用，则 `DHCP Client` 向 `DHCPServer` 发出 `DHCP Decline` 报文，通知 `DHCP Server` 禁用这个IP地址，然后 `DHCP Client` 开始新的地址申请过程。
6. `DHCP Client` 在成功获取IP地址后，随时可以通过发送 `DHCP Release` 报文释放自己的 `IP` 地址，`DHCP Server` 收到 `DHCP Release` 报文后，会回收相应的 `IP` 地址并重新分配。



在使用租期超过50%时刻处，DHCP Client会以单播形式向DHCP Server发送DHCPRequest报文来续租IP地址。如果DHCP Client成功收到DHCP Server发送的DHCP ACK报文，则按相应时间延长IP地址租期；如果没有收到DHCP Server发送的DHCP ACK报文，则DHCP Client继续使用这个IP地址。

在使用租期超过87.5%时刻处，DHCP Client会以广播形式向DHCP Server发送DHCPRequest报文来续租IP地址。如果DHCP Client成功收到DHCP Server发送的DHCP ACK报文，则按相应时间延长IP地址租期；如果没有收到DHCP Server发送的DHCP ACK报文，则DHCP Client继续使用这个IP地址，直到IP地址使用租期到期时，DHCP Client才会向DHCP Server发送DHCP Release报文来释放这个IP地址，并开始新的IP地址申请过程。

需要说明的是：DHCP客户端可以接收到多个DHCP服务器的DHCPOFFER数据包，然后可能接受任何一个DHCPOFFER数据包，但客户端通常只接受收到的第一个DHCPOFFER数据包。另外，DHCP服务器DHCPOFFER中指定的地址不一定为最终分配的地址，通常情况下，DHCP服务器会保留该地址直到客户端发出正式请求。

正式请求DHCP服务器分配地址DHCPREQUEST采用广播包，是为了让其它所有发送DHCPOFFER数据包的DHCP服务器也能够接收到该数据包，然后释放已经OFFER（预分配）给客户端的IP地址。

如果发送给DHCP客户端的地址已经被其他DHCP客户端使用，客户端会向服务器发送DHCPDECLINE信息包拒绝接受已经分配的地址信息。

在协商过程中，如果DHCP客户端发送的REQUEST消息中的地址信息不正确，如客户端已经迁移到新的子网或者租约已经过期，DHCP服务器会发送DHCPNAK消息给DHCP客户 端，让客户端重新发起地址请求过程。

 

 