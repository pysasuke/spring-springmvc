spring-springmvc
===
## 项目介绍
单纯的spring整合springmvc，整合所需算的最简配置

项目结构
### main
- controller:控制层，UserController展示了两种返回而类型情况:跳转页面和返回对象  

部分代码展示:
```
 //跳转到jsp页面
    @RequestMapping("jspViewTest")
    public String jspViewTest() {
        return "index";
    }

    //返回数据对象
    @RequestMapping("dataTest")
    @ResponseBody
    public String dataTest() {
        return "index";
    }
```    
- service:业务处理层，包含一个impl包，Service以接口类型存在，impl包下存放Service接口的实现类
- dao:数据库交互层
- model:实体对象层
### resources
- application.xml:spring配置文件入口
- spring-mvc.xml:springmvc配置相关文件

部分代码展示:
```
    <!-- 自动扫描该包，使SpringMVC认为包下用了@controller注解的类是控制器 -->
    <context:component-scan base-package="com.py.controller">
        <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    </context:component-scan>

    <!--注解方式(处理请求)-->
    <mvc:annotation-driven/>
 
<!--静态资源默认servlet配置a
    	1、加入对静态资源的处理:js,css,gif,png
    	2、允许使用"/"做整体映射
    -->
    <mvc:default-servlet-handler/>
     <!-- 静态资源处理  css js imgs 可以直接访问而不被拦截-->
    <mvc:resources mapping="/html/**" location="/WEB-INF/html/"/>

    <!-- 定义跳转的文件的前后缀 ，视图模式配置  解析控制层return "index" 一类的操作-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/jsp/"/>
        <property name="suffix" value=".jsp"/>
    </bean>
```
### webapp
- web.xml

部分代码展示:
```
<!-- SpringMVC核心 -->
    <servlet>
        <servlet-name>SpringMVC</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath*:spring-mvc.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>

    <!-- Spring的配置文件 -->
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath*:application.xml</param-value>
    </context-param>

    <!-- Spring监听器 -->
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
    <!-- SpringMVC拦截设置 -->
    <servlet-mapping>
        <servlet-name>SpringMVC</servlet-name>
        <!-- 由SpringMVC拦截所有请求 -->
        <url-pattern>/</url-pattern>
    </servlet-mapping>
    <!-- SpringMVC拦截设置结束 -->
 ```
