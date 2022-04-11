# 1 Mybatis项目管理
## 1.1 创建与生成
参考博客：https://blog.csdn.net/qq_45401910/article/details/123345742
1. 使用Mybatis需要手动创建的文件：
<br/>&nbsp;&nbsp;1）pom.xml，指定插件：
    ```xml
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
        <plugin>
            <groupId>org.mybatis.generator</groupId>
            <artifactId>mybatis-generator-maven-plugin</artifactId>
            <version>1.3.7</version>
            <dependencies>
                <dependency>
                    <groupId>mysql</groupId>
                    <artifactId>mysql-connector-java</artifactId>
                    <version>8.0.22</version>
                </dependency>
            </dependencies>
            <configuration>
                <configurationFile>
                    src/main/resources/mybatis-generate-config.xml
                </configurationFile>
            </configuration>
        </plugin>
    </plugins>
    ```
<br/>&nbsp;&nbsp;2）上述插件中提到的mybatis-generate-config.xml，确定连接数据库的基本信息+后面生成文件的存放位置+需要操作的表的基本信息；

2. 使用Mybatis自动生成的文件：
<br/>&nbsp;&nbsp;1）如何生成？-- 在命令行执行：mvn mybatis-generator:generate（参考[博客](https://blog.csdn.net/fengcai0123/article/details/85273714)）
<br/>&nbsp;&nbsp;2）生成哪些？
<br/>&nbsp;&nbsp;&nbsp;&nbsp;a、Item.java--实体类；于/src/main/java/entity/目录下。
<br/>&nbsp;&nbsp;&nbsp;&nbsp;b、ItemMapper.java--接口类，数据库操作方法，但无具体实现；于/src/main/java/dao/目录下。（没有具体实现，且又没有接口实现类的话，那么代码如何实现具体的sql语句？如3）所示，有了3）就有了具体的sql语句；结合动态代理，即可实现与接口实现类同样的功能）。
<br/>&nbsp;&nbsp;&nbsp;&nbsp;c、ItemMapper.xml--接口类的映射文件，根据2）的数据库的操作方法，写有具体的sql语句；于/src/main/java/resources/mappers/目录下。

# 2 Mybatis底层原理
## 2.1 逻辑流程图