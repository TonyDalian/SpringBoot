# Redis

* Installation
	* > apt-get install redis-server
	* > redis-cli (ping)
	* > configuration file location: /path/to/redis.conf
	
* 5 Data Types and Basic Commands in Redis
	* > String
		* >> get
		* >> set 
		* >> del
	* > Linked-list
		* >> lpush
		* >> rpush
		* >> lpop
		* >> rpop
		* >> lindex
		* >> lrange
	* > Set
		* >> sadd
		* >> srem
		* >> smembers
		* >> sismember
		* >> sinter
		* >> sunion
		* >> sdiff
	* > Hash
		* >> hset
		* >> hget
		* >> hdel
		* >> hgetall
	* > Zset
		* >> zadd
		* >> zrem
		* >> zrange
		* >> zrangebyscore
