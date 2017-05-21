
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
		* >> 左侧 P 代表 生产者，也就是往 RabbitMQ 发消息的程序。
		* >> 中间即是 RabbitMQ，其中包括了 交换机 和 队列。
		* >> 右侧 C 代表 消费者，也就是往 RabbitMQ 拿消息的程序。
		* >> 虚拟主机：一个虚拟主机持有一组交换机、队列和绑定。为什么需要多个虚拟主机呢？很简单，RabbitMQ当中，用户只能在虚拟主机的粒度进行权限控制。 因此，如果需要禁止A组访问B组的交换机/队列/绑定，必须为A和B分别创建一个虚拟主机。每一个RabbitMQ服务器都有一个默认的虚拟主机“/”。
		* >> 交换机：Exchange 用于转发消息，但是它不会做存储 ，如果没有 Queue bind 到 Exchange 的话，它会直接丢弃掉 Producer 发送过来的消息。这里有一个比较重要的概念：路由键 。消息到交换机的时候，交互机会转发到对应的队列中，那么究竟转发到哪个队列，就要根据该路由键。交换机有四种类型：Direct, topic, Headers and Fanout.
			* >>> Direct：direct 类型的行为是"先匹配, 再投送". 即在绑定时设定一个 routing_key, 消息的routing_key 匹配时, 才会被交换器投送到绑定的队列中去.
			* >>> Topic：按规则转发消息（最灵活）
			* >>> Headers：设置header attribute参数类型的交换机
				* >>>> fanout，direct，topic exchange的routingKey都需要要字符串形式的，而headers exchange则没有这个要求，因为键值对的值可以是任何类型。
				* >>>> 在做绑定的时候有两种匹配方式供选择。x-match (all/any)意思就是键值对中所有的项都要匹配与只要有一个匹配就可以。
			* >>> Fanout：转发消息到所有绑定队列
				* >>>> Fanout 就是我们熟悉的广播模式或者订阅模式，给Fanout交换机发送消息，绑定了这个交换机的所有队列都收到这个消息。
				* >>>> 发送端的routing_key写任何字符都会被忽略.
		* >> 绑定：也就是交换机需要和队列相绑定，这其中如上图所示，是多对多的关系。
	
* Installation
	* > apt-get install rabbitmq-server 
	* > rabbitmqctl add_user sam0411 testing1234
	* > rabbitmqctl set_permissions sam0411 ".*" ".*" ".*"
	* > rabbitmq-plugins enable rabbitmq_management (http://localhost:15672 guest:guest)
	
* Command
	* > rabbitmqctl status
	* > rabbitmqctl add_user sam0411 testing1234
	* > rabbitmqctl set_user_tags admin administrator