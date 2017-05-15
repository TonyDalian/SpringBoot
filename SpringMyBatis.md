## Spring MyBatis

* @MapperScan(basePackages="com.boot.test.mapper",sqlSessionTemplateRef="sqlSessionTemplate")
	* > Tell Spring under which package, MyBatis mapper should be scanned into container

* @Insert
 	* > @Insert("insert into t_user(name,age,gender) values (#{name},#{age},#{gender})")
 	* > public int addUser(User user) throws DataAccessException;
 	
* @Select	
 	* > @Select("select age,gender from t_user where name={name}")
 	* > public User queryUser(String name) throws DataAccessException;

* @SelectKey	
 	* > @SelectKey(statement = "select max(id) from t_id", before = true, resultType = long.class, keyProperty = "id")
 	* > @Insert("insert into t_user(id,name,age,gender) values (#{id},#{name},#{age},#{gender})")
 	* > public int addUser(User user) throws DataAccessException;
 	
[MyBatis Annotation Ref](http://www.mybatis.org/mybatis-3/java-api.html)