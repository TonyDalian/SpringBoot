## Spring Properties

* @Value
	* > ${ property : default_value }, load value from .properties file such as __application.properties__ or __PropertiesFactoryBean__. @Value("${jdbc.driverClass}")
	* > #{ obj.property? : default_value }, Spring Expression Language (SpEL), load value from configuration bean. Value inside configuration bean is from .properties file.
	
* @ConfigurationProperties("greeting")
	* > Read properties from __application.properties__ whose prefix is __greeting__