代理模式目标<br>
1、掌握代理模式的应用场景和实现原理。<br>
2、了解静态代理和动态代理的区别。<br>
>>静态代理只能通过手动去完成代理操作，如果被代理的对象有新增的方法，代理类需要去同步去更新，违背了开闭原则<br>
>>动态代理在运行时去动态生成代码的方式，取消了对被代理类扩展的限制<br>
3、了解CGLib和JDK Proxy的根本区别。<br>
>>jdk是根据实现的接口来定义那些方法需要被覆盖，CGlib则是通过动态继承你的类。但是他们的目的相同都是生成一个新的类去实现代码逻辑的功能<br>
>>JDK proxy对于用户而言，必须有一个接口实现，目标类相对来说更复杂一点，Proxy生成代理的逻辑简单，调用效率相对要低，每次都要反射动态调用<br>
>>CGLIB则可以代理任何一个普通的类，没有任何要求。生成代理的逻辑更复杂，但是调用效率更高，生成了一个包含所有逻辑的FastClass，不需要再通过反射调用<br>
>>CGlib不能代理final的方法
4、手写实现定义的动态代理。<br>

实践<br>
1、仿JDK动态代理实现原理，自己手写一遍。<br>
>>拿到被代理的引用,并获取它的所有接口(反射获取)<br>
>>JDK proxy类重新生成一个新的累，实现了被代理类所有接口的方法<br>
>>动态生成java代码，把我们增强逻辑加入到新生成的代码中。<br>
>>编译生产新的java代码的class文件。<br>
>>加载并运行新的class,得到的类就是全新的类。<br>s
2、思考：为什么JDK动态代理中要求目标类实现的接口数量不能超过65535个？<br>
>>JDK底层定义的接口计数interface_count的类型是两个字节的无符号数，即2的16次方减1个。<br>
3、结合自身的业务场景用代理模式进行重构。<br>


代理模式的优点:<br>
>>代理模式能够将代理对象与真实被调用的目标对象分离<br>
>>一定程度上降低了系统的耦合程度，易于扩展<br>
>>代理可以起到保护目标对象的作用<br>
>>增强目标对象的职责<br>

代理模式的缺点:<br>
>>代理模式会造成系统设计中类的数目增加<br>
>>在客户端和目标对象之间增加了一个代理对象，会造成请求处理速度变慢<br>
>>增加了系统的复杂度<br>

