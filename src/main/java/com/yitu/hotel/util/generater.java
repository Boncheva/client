package com.yitu.hotel.util;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

public class generater {
    static String packageName = "com.yitu.hotel"; // 当前包名
    static String author = "MyBatisPlusGenerater"; // 作者
    static String sqlUrl = "mysql://192.9.102.129:3306/"; // 数据库类型及地址
    static String sqlDb = "isolate_hotel_system_test"; // 数据库名
    static String sqlUser = "isolate";
    static String sqlPassword = "qsR$FlckDC";
    static String table = "dgtx_places"; // 表，用逗号隔开

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir("C:\\Users\\1\\Desktop\\generate/src/main/java");
        gc.setAuthor(author);
        gc.setOpen(false);
        gc.setServiceName("%sService");
        gc.setBaseColumnList(true);
        gc.setBaseResultMap(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:" + sqlUrl + sqlDb + "?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername(sqlUser);
        dsc.setPassword(sqlPassword);
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(packageName);
        pc.setEntity("model");
        mpg.setPackageInfo(pc);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
//        templateConfig.setXml(null); // 不生成MapperXML
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setRestControllerStyle(true);
        strategy.setEntityTableFieldAnnotationEnable(true);

        strategy.setInclude(table.split(","));
        strategy.setControllerMappingHyphenStyle(true);
//        strategy.setTablePrefix("t_"); // 表前缀，如t_user，没有就注释掉此行
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
