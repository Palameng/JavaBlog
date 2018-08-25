# JavaBlog

# 问题汇总  
  
### 1 配置好application.properties的hibernate自动生成数据库表的配置后，无法生成数据表。  
旧配置无法成功: spring.jpa.hibernate.dll-auto = create-drop  
使用新配置成功: spring.jpa.properties.hibernate.hbm2ddl.auto=update  

这里解释一下create-drop和update:  
https://blog.csdn.net/yalishadaa/article/details/59656332  

原因可能是各个组件的版本声明问题，比较离奇。
