
# RabbitMQ

* Background
	* > RabbitMQ 即一个消息队列，主要是用来实现应用程序的异步和解耦，同时也能起到消息缓冲，消息分发的作用。
		* >> 消息中间件最主要的作用是解耦，中间件最标准的用法是生产者生产消息传送到队列，消费者从队列中拿取消息并处理，生产者不用关心是谁来消费，消费者不用关心谁在生产消息，从而达到解耦的目的。
		* >> 在分布式的系统中，消息队列也会被用在很多其它的方面，比如：分布式事务的支持，RPC的调用等等。		
	* > AMQP，即Advanced Message Queuing Protocol，高级消息队列协议，是应用层协议的一个开放标准，为面向消息的中间件设计。
		* >> RabbitMQ是实现AMQP（高级消息队列协议）的消息中间件的一种，最初起源于金融系统，用于在分布式系统中存储转发消息，在易用性、扩展性、高可用性等方面表现不俗。RabbitMQ主要是为了实现系统之间的双向解耦而实现的。当生产者大量产生数据时，消费者无法快速消费，那么需要一个中间层。保存这个数据。
		* >> AMQP的主要特征是面向消息、队列、路由（包括点对点和发布/订阅）、可靠性、安全。
		* >> RabbitMQ是一个开源的AMQP实现，服务器端用Erlang语言编写，支持多种客户端，如：Python、Ruby、.NET、Java、JMS、C、PHP、ActionScript、XMPP、STOMP等，支持AJAX。用于在分布式系统中存储转发消息，在易用性、扩展性、高可用性等方面表现不俗。
		
* RabbitMQ Architecture
	* > 通常我们谈到队列服务, 会有三个概念： 发消息者、队列、收消息者，RabbitMQ 在这个基本概念之上, 多做了一层抽象, 在发消息者和 队列之间, 加入了交换器 (Exchange). 这样发消息者和队列就没有直接联系, 转而变成发消息者把消息给交换器, 交换器根据调度策略再把消息再给队列。
	* > ![RabbitMQ Architecture](https://github.com/sam0411/SpringBoot/blob/master/src/main/resources/static/images/rabbitMQ_Arch.png)
	
	
* Installation
	* > apt-get install rabbitmq-server 
	* > rabbitmqctl add_user sam0411 testing1234
	* > rabbitmqctl set_permissions sam0411 ".*" ".*" ".*"
	* > rabbitmq-plugins enable rabbitmq_management (http://localhost:15672 guest:guest)
	
* Command
	* > rabbitmqctl status
	* > rabbitmqctl add_user sam0411 testing1234
	* > rabbitmqctl set_user_tags admin administrator