## Spring Properties

* @Value
	* > ${ property : default_value }, load value from .properties file such as __application.properties__ or __PropertiesFactoryBean__. @Value("${jdbc.driverClass}")
	* > #{ obj.property? : default_value }, Spring Expression Language (SpEL), load value from configuration bean. Value inside configuration bean is from .properties file.
	
* @ConfigurationProperties("greeting")
	* > Read properties from __application.properties__ whose prefix is __greeting__
	
* @PropertySource({"classpath:site-jdbc.properties", "classpath:site-social.properties"})
	* > Load properties from files
	* > Properties are loaded into Spring Environment bean
	* > Properties can also be loaded into PropertySourcesPlaceholderConfigurer for ${…} placeholder
	'''java
		@Configuration
		@ComponentScan(basePackages = "com.websystique.spring")
		@PropertySource(value = { "classpath:application.properties" })
		public class AppConfig {		 
		    /*
		     * PropertySourcesPlaceHolderConfigurer Bean only required for @Value("{}") annotations.
		     * Remove this bean if you are not using @Value annotations for injecting properties.
		     */
		    @Bean
		    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		        return new PropertySourcesPlaceholderConfigurer();
		    }
		}
	'''