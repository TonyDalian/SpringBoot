## Spring Session

* @EnableRedisHttpSession
	* > Creates a Spring Bean with the name of springSessionRepositoryFilter that implements Filter. The filter is what is in charge of replacing the HttpSession implementation to be backed by Spring Session. In this instance Spring Session is backed by Redis.