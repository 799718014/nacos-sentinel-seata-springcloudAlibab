# nacos-sentinel-seata-springcloudAlibab
nacos-sentinel-seata-springcloudAlibab 框架搭建

#### 介绍
SpringCloud集成Seata并使用Nacos做注册中心与配置中心+sentinel流控的源码，教程请参照：

#### 软件架构
nacos1.3+seata1.2+springCloudAlibaba2.2.1.RELEASE+mybatis-plus+mybatis

#### 依赖工具
- sentinel-dashboard工具，[点击下载](https://files.gitee.com/group1/M00/0F/88/wKgCNF8C6J-Aa2xVAXs5BLIt5Mk484.jar?token=cf7dc577bc94f7fa8f23429500fe03c9&ts=1594026495&attname=sentinel-dashboard-nacos-1.7.2.jar&disposition=attachment)
- seata下载
- nacos下载

#### 配置说明

- #### 1.nacos配置，持久化
- 修改D:\java\nacos\conf\application.properties,新增以下配置
spring.datasource.platform=mysql
db.num=1
db.url.0=jdbc:mysql://127.0.0.1:3306/nacos_config?characterEncoding=utf8&connectTimeout=1000&socketTimeout=3000&autoReconnect=true&useUnicode=true&useSSL=false&serverTimezone=UTC
db.user=root
db.password=123456

- #### 2.seata配置，持久化
- 修改D:\java\seata\conf\file.conf和registry.conf
- ### 1、registry.conf（不完整代码段）
registry {
  #### file 、nacos 、eureka、redis、zk、consul、etcd3、sofa
  type = "nacos"

- #2、file.conf
db {
    ## the implement of javax.sql.DataSource, such as DruidDataSource(druid)/BasicDataSource(dbcp) etc.
    datasource = "dbcp"
    ## mysql/oracle/h2/oceanbase etc.
    db-type = "mysql"
    driver-class-name = "com.mysql.jdbc.Driver"
    url = "jdbc:mysql://127.0.0.1:3306/seata_config"
    user = "root"
    password = "123456"
    min-conn = 1
    max-conn = 3
    global.table = "global_table"
    branch.table = "branch_table"
    lock-table = "lock_table"
    query-limit = 100
  }

- #### 3.seata客户端的项目配置
- 新增D:\javacode\lzx-github\nacos-sentinel-seata-springcloudAlibab\cloudalibaba-seata-order-service2001\src\main\resources\file.conf和registry.conf
- ### 1、registry.conf（不完整代码段）
 registry {
   #### file 、nacos 、eureka、redis、zk、consul、etcd3、sofa
   type = "nacos"
   
- ####2、file.conf
 db {
    ## the implement of javax.sql.DataSource, such as DruidDataSource(druid)/BasicDataSource(dbcp) etc.
    datasource = "dbcp"
    ## mysql/oracle/h2/oceanbase etc.
    db-type = "mysql"
    driver-class-name = "com.mysql.jdbc.Driver"
    url = "jdbc:mysql://127.0.0.1:3306/seata_config"
    user = "root"
    password = "123456"
    min-conn = 1
    max-conn = 3
    global.table = "global_table"
    branch.table = "branch_table"
    lock-table = "lock_table"
    query-limit = 100
  }
  
- #### 快速启动

- 1.启动naocs。D:\java\nacos\bin\startup.cmd
- 2.启动seata。D:\java\seata\bin\seata-server.bat
- 3.启动sentinel。 java -jar sentinel-dashboard-1.7.1.jar

  
}
