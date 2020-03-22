# web模块
## 一.Spring MVC的xml配置版
1.xml配置文件
![](https://niit-student.oss-cn-beijing.aliyuncs.com/markdown/20200319173129.png)
2.DaoImpl
![](https://niit-student.oss-cn-beijing.aliyuncs.com/markdown/20200319173528.png)
3.运行结果

## 二.Spring MVC的注解配置版
1.SpringDataSourceConfig
![](https://niit-student.oss-cn-beijing.aliyuncs.com/markdown/20200319173303.png)
这边配置到datasource的bean，set注入比构造器注入更加的灵活

想要给DruidDataSource起别名的方法
![](https://niit-student.oss-cn-beijing.aliyuncs.com/markdown/20200319173326.png)
![](https://niit-student.oss-cn-beijing.aliyuncs.com/markdown/20200319173342.png)
2.ForumDaoImpl
![](https://niit-student.oss-cn-beijing.aliyuncs.com/markdown/20200319173406.png)
  dao层            @Repository 
  service层      @Service
  controller层  @Controller   可以用不同的注解、从语义上区分
  @Component可以统一代替
  
  3.ForumDaoTest
  ![](https://niit-student.oss-cn-beijing.aliyuncs.com/markdown/20200319173438.png)

  4.运行结果