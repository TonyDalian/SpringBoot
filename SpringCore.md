## Spring Core Annotation
* @ComponentScan(basePackages = { "com.apress.prospringmvc.bookstore.web" }) 
	* > Tell Spring under which package, beans should be scanned into container	
	
* @Import(CDConfig.class)
	* > Import configuration from config class

* @ImportResource("classpath:cons-injec.xml") 
	* > Import configuration from XML file
	
* @Autowired
	* > for bean injection on variable & setter method
	* > variable must exist
	* > byType injection

* @Resource
	* > for bean injection on variable & setter method
	* > on setter method is recommended
	* > byName injection

* @Qualifier
	* > for bean byType injection @Autowired	
	* > specify bean name to be injected		

* @Configuration	
	* > Same as __beans...\beans__ in spring XML configuration
	
* @Bean
	* > @Bean is used to explicitly declare a single bean, rather than letting Spring do it automatically as above. It decouples the declaration of the bean from the class definition, and lets you create and configure beans exactly how you choose.

* @Scope(value = BeanDefinition.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
	* > Define bean's lifecycle
	* > Have 5 defined values:
		* >> singleton, before spring2.0
		* >> prototype, before spring2.0
		* >> request, after spring2.0 for web application
		* >> session, after spring2.0 for web application
		* >> global session, after spring2.0 for web application
	* > Use proxyMode when bean and subbean to be injected have different lifecycle, singleton vs. session. Use CGLib to create delegation, base on interface or class:
		* >> ScopedProxyMode.INTERFACES, when subbean has interface
		* >> ScopedProxyMode.TARGET_CLASS, when subbean is class
		
* @Component
	* > @Component (and @Service and @Repository) are used to auto-detect and auto-configure beans using classpath scanning. There's an implicit one-to-one mapping between the annotated class and the bean (i.e. one bean per class). Control of wiring is quite limited with this approach, since it's purely declarative.
	
* @Service
	
* @Repository
	
* @Controller

* @Conditional(WindowsCondition.class)
	* > Create bean when condition is satisfied
	* > Put @Conditional on class which has @Component (Having @Configuration)
	* > Put @Conditional on method which has @Bean
	* > 
		```java
			public class WindowsCondition implements Condition {
			    @Override
			    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
			        return conditionContext.getEnvironment().getProperty("os.name").contains("Windows");
			    }
			}
		```