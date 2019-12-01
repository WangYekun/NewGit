# MyBatisGenerator
mybatis代码生成，以及注释生成，有swagger，Lombok，添加顶部作者姓名和创建时间可供选择
# 基于MyBatis提供的生成器
## 首先在pom文件中引用生成器依赖
```
<dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.1.0</version>
</dependency>

<dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
</dependency>
<dependency>
            <groupId>org.mybatis.generator</groupId>
            <artifactId>mybatis-generator-core</artifactId>
            <version>1.3.7</version>
</dependency>

```
## 添加配置generatorConfig.xml文件
```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE generatorConfiguration
        PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">

<generatorConfiguration>
    <properties resource="application.properties"/>
    <context id="MySqlContext" targetRuntime="MyBatis3" defaultModelType="flat">
        <property name="beginningDelimiter" value="`"/>
        <property name="endingDelimiter" value="`"/>
        <property name="javaFileEncoding" value="UTF-8"/>
        <!-- 为模型生成序列化方法-->
        <plugin type="org.mybatis.generator.plugins.SerializablePlugin"/>
        <!-- 为生成的Java模型创建一个toString方法 -->
        <plugin type="org.mybatis.generator.plugins.ToStringPlugin"/>
        <!--可以自定义生成model的代码注释  type实现自己的自定义，记得填写正确的包名-->

        <commentGenerator type="com.aurochs.example.MyCommentGenerator">
            <property name="author" value="shawn"/>
            <property name="dateFormat" value="yyyy/MM/dd"/>
            <!--关闭自动生成的注释 true：是 ： false:否-->
            <property name="suppressAllComments" value="true"/>
            <!-- 是否生成注释代时间戳-->
            <property name="suppressDate" value="false"/>
            <!--是否添加数据库字段备注-->
            <property name="addRemarkComments" value="true"/>
        </commentGenerator>


        <!--数据库链接地址账号密码-->
        <jdbcConnection driverClass="${spring.datasource.driver-class-name}"
                        connectionURL="${spring.datasource.url}"
                        userId="${spring.datasource.username}"
                        password="${spring.datasource.password}">
        <!--  解决解决连接到其他数据库的问题-->
            <property name="nullCatalogMeansCurrent" value="true" />
        </jdbcConnection>

        <!-- 类型转换 -->
        <javaTypeResolver>
            <!-- 是否使用bigDecimal， false可自动转化以下类型（Long, Integer, Short, etc.） -->
            <property name="forceBigDecimals" value="false"/>
        </javaTypeResolver>

        <!--指定生成model的路径-->
        <javaModelGenerator targetPackage="com.aurochs.example.model" targetProject="src\main\java"/>
        <!--指定生成mapper.xml的路径-->
        <sqlMapGenerator targetPackage="com.aurochs.example.mapper.demo" targetProject="src\main\resources"/>
        <!--指定生成mapper接口的的路径-->
        <javaClientGenerator type="XMLMAPPER" targetPackage="com.aurochs.example.mapper.demo"
                             targetProject="src\main\java"/>


        <!--        <table tableName="article" enableCountByExample="true" enableUpdateByExample="true" enableDeleteByExample="true" enableSelectByExample="true" selectByExampleQueryId="true">-->
        <!--            <generatedKey column="id" sqlStatement="Mysql" identity="true" />-->
        <!--        </table>-->
        <!--table中指定数据库  %为指定所有-->
        <table tableName="%" enableCountByExample="true" enableUpdateByExample="true" enableDeleteByExample="true"
               enableSelectByExample="true" selectByExampleQueryId="true">
            <generatedKey column="id" sqlStatement="Mysql" identity="true"/>
        </table>

    </context>
</generatorConfiguration>

```
这里我们将数据库连接写到配置文件中
## 数据库连接配置
```
# MyBatis 配置
spring.datasource.url=jdbc:mysql://localhost:3306/mybatis?serverTimezone=UTC&useSSL=false
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
mybatis.type-aliases-package=com.example.mybatislearn.mapper
mybatis.config-locations=classpath:mybatis/mybatis-config.xml
mybatis.mapper-locations=classpath:mybatis/mapper/*.xml
```
## 代码注释配置自定义类
```
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class MyCommentGenerator extends DefaultCommentGenerator {
    //添加注释总开关，generator.xml中设置为true！！！
    private boolean addRemarkComments = false;
    //是否需要添加swaggerui注释
    private boolean addSwaggerUi = true;
    //是否需要添加顶部作者姓名和创建时间
    private boolean addAuthorAndDate = true;
    //是否需要Lombok添加@Data注释
    private boolean addLombok = true;
    private Properties properties;
    private static final String LOMBOK_DATA = "lombok.Data";
    private static final String EXAMPLE_SUFFIX = "Example";
    private static final String API_MODEL_PROPERTY_FULL_CLASS_NAME = "io.swagger.annotations.ApiModelProperty";

    public MyCommentGenerator() {
        properties = new Properties();
    }

    /**
     * 设置用户配置的参数
     */
    @Override
    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);
        super.addConfigurationProperties(properties);
        this.addRemarkComments = StringUtility.isTrue(properties.getProperty("addRemarkComments"));
    }

    /**
     * 给字段添加注释
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        String remarks = introspectedColumn.getRemarks();
        //根据参数和备注信息判断是否添加备注信息
        if (addRemarkComments && StringUtility.stringHasValue(remarks)) {
//            addFieldJavaDoc(field, remarks);
            //数据库中特殊字符需要转义
            if (remarks.contains("\"")) {
                remarks = remarks.replace("\"", "'");
            }
            //数据库字段注释
            field.addJavaDocLine("/**");
            field.addJavaDocLine("*" + remarks + "");
            field.addJavaDocLine("*/");

            //给model的字段添加swagger注解
            if (addSwaggerUi) {
                field.addJavaDocLine("@ApiModelProperty(value = \"" + remarks + "\")");
            }

        }
    }


    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        super.addJavaFileComment(compilationUnit);
        if (addSwaggerUi) {
            //只在model中添加swagger注解类的导入
            if (!compilationUnit.isJavaInterface() && !compilationUnit.getType().getFullyQualifiedName().contains(EXAMPLE_SUFFIX)) {
                compilationUnit.addImportedType(new FullyQualifiedJavaType(API_MODEL_PROPERTY_FULL_CLASS_NAME));
            }
        }
        if (addLombok) {
            if (!compilationUnit.isJavaInterface() && !compilationUnit.getType().getFullyQualifiedName().contains(EXAMPLE_SUFFIX)) {
                compilationUnit.addImportedType(new FullyQualifiedJavaType(LOMBOK_DATA));
            }
        }


    }

    /**
     * 在生成的model上添加注释
     */
    @Override
    public void addModelClassComment(TopLevelClass topLevelClass,
                                     IntrospectedTable introspectedTable) {
        //addRemarkComments为true则执行
        if (!addAuthorAndDate) {
            return;
        }
        String author = properties.getProperty("author");
        String dateFormat = properties.getProperty("dateFormat", "yyyy-MM-dd");
        SimpleDateFormat dateFormatter = new SimpleDateFormat(dateFormat);

        // 获取表注释
        String remarks = introspectedTable.getRemarks();

        topLevelClass.addJavaDocLine("/**");
        topLevelClass.addJavaDocLine(" * " + remarks);
        topLevelClass.addJavaDocLine(" *");
        topLevelClass.addJavaDocLine(" * @author " + author);
        topLevelClass.addJavaDocLine(" * @date " + dateFormatter.format(new Date()));
        topLevelClass.addJavaDocLine(" */");
        if (addLombok) {
            topLevelClass.addJavaDocLine("@Data");

        }
    }

}




```

## 代码生成主方法
```
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Generator {
    public static void main(String[] args) throws Exception {
        //打印警告信息
        List<String> warnings = new ArrayList<String>();
        //是否覆盖原代码
        boolean overwrite = true;
        //读取配置文件，generatorConfig.xml放在resources目录下
        InputStream is = Generator.class.getResourceAsStream("/generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(is);
        is.close();

        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        //创建mbg
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        //执行代码
        myBatisGenerator.generate(null);
        //打印警告信息
        for (String warning : warnings) {
            System.out.println(warning);
        }
    }
}
```
