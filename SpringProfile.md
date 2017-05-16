## Spring Profile

* @Profile
	* > @Profile annotation should be used for loading application configuration based on conditional logic
	* > @Profile annotation is restricted to write conditional checking based on predefined properties. @Conditional annotation does not have this restriction
	* > Specify __spring.profiles.active__ in __application.properties__ for profile to be loaded
	* > Specify __spring.profiles.include__ in __application.properties__ for those profile to be loaded without condition
	* > Specify JVM parameter __-Dspring.profiles.active__ for profile to be loaded
	* > For different {__profile__}, it has different application-{__profile__}.properties
	* > __application.properties__ will be loaded anyway
	