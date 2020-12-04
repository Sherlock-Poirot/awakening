package com.detective.stone.awakening.company;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AutoGenerate {

  private final static char sep = File.separatorChar;

  // TODO 后期使用配置文件读取形式,暂时写死.
  public static void main(String[] args) {
    AutoGenerator mpg = new AutoGenerator();
    // globalConfig全局设置
    GlobalConfig globalConfig = new GlobalConfig();
    String projectPath = System.getProperty("user.dir"); // 获取用户当前项目目录
    globalConfig.setOutputDir(projectPath + "/company/src/main/java"); // 输出目录
    globalConfig.setAuthor("Detective Stone"); // 作者
    globalConfig.setFileOverride(true); //是否覆盖已有文件,默认false
    globalConfig.setSwagger2(true); // 暂时没有集成swagger2稍后集成
    globalConfig.setEntityName("%s"); // 设置实体类名字  %s为占位符
    globalConfig.setMapperName("%sMapper"); // 设置mapper名字  %s为占位符
    globalConfig.setXmlName("%sMapper"); // 设置mapper.xml名字  %s为占位符
    globalConfig.setServiceName("%sService"); // 设置service名字  %s为占位符
    globalConfig.setServiceImplName("%sServiceImpl"); // 设置serviceImpl名字  %s为占位符
    globalConfig.setControllerName("%sController"); // 设置controller名字  %s为占位符
    globalConfig.setBaseResultMap(true);
    globalConfig.setOpen(false);
    mpg.setGlobalConfig(globalConfig);

    // DataSource配置
    DataSourceConfig datasource = new DataSourceConfig();
    datasource.setDbType(DbType.MYSQL); // 数据库类型
    datasource.setDriverName("com.mysql.cj.jdbc.Driver"); // 驱动名称
    // 数据库连接url
    datasource.setUrl(
        "jdbc:mysql://47.99.218.144:3306/loe?characterEncoding=UTF-8&useUnicode=true&useSSL=false&allowMultiQueries=true");
    datasource.setUsername("root"); // 数据库连接用户名
    datasource.setPassword("Stn_123456"); // 数据库连接密码
    mpg.setDataSource(datasource);

    // packageInfo包配置
    PackageConfig packageConfig = new PackageConfig();
    packageConfig.setParent("com.detective.stone.awakening.company");// 父包名如果不写则之后的要写全名
    packageConfig.setController("controller");
    packageConfig.setService("service");
    packageConfig.setServiceImpl("service.impl");
    packageConfig.setEntity("model");
    packageConfig.setMapper("dao");
    mpg.setPackageInfo(packageConfig);

    // 策略配置
    StrategyConfig strategyConfig = new StrategyConfig();
    strategyConfig.setNaming(NamingStrategy.underline_to_camel); // 数据库转JAVA命名规则 下划线转驼峰
    strategyConfig.setEntityBuilderModel(true); // 构建者模式
    strategyConfig.setEntityLombokModel(true); // lombok模式
    strategyConfig.setRestControllerStyle(true); // restController 模式
    strategyConfig.setEntityColumnConstant(true);
    strategyConfig.setLogicDeleteFieldName("cancel_flag");
    strategyConfig.entityTableFieldAnnotationEnable(true);
    strategyConfig.setInclude("permission", "permission_role", "permission_user"); // 需要的表名
    mpg.setStrategy(strategyConfig);

    // 如果模板引擎是 freemarker
    String templatePath = "/templates/mapper.xml.ftl";
    // 如果模板引擎是 velocity
    // String templatePath = "/templates/mapper.xml.vm";

    InjectionConfig cfg = new InjectionConfig() {
      @Override
      public void initMap() {

      }
    };
    List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
    focList.add(new FileOutConfig(templatePath) {
      @Override
      public String outputFile(TableInfo tableInfo) {
        LocalDateTime now = LocalDateTime.now();
        String date = now.toString().replace("T", " ");
        InputGenerateDTO inputDTO = new InputGenerateDTO();
        inputDTO.setTable(tableInfo);
        inputDTO.setSwagger2(globalConfig.isSwagger2());
        inputDTO.setEntityLombokModel(strategyConfig.isEntityLombokModel());
        inputDTO.setAuthor(globalConfig.getAuthor());
        inputDTO.setDate(date);
        inputGenerate(inputDTO, projectPath + "/company/src/main/java");
        return projectPath + "/company/src/main/resources/mapper/" + tableInfo.getXmlName()
            + ".xml";
      }
    });
    cfg.setFileOutConfigList(focList);
    mpg.setCfg(cfg);

    // 配置模板
    TemplateConfig templateConfig = new TemplateConfig();

    // 配置自定义输出模板
    // templateConfig.setEntity();
    // templateConfig.setService();
    templateConfig.setController("/templates/controller.java");
    templateConfig.setMapper("/templates/mapper.java");
    templateConfig.setXml(null);
    mpg.setTemplate(templateConfig);

    mpg.setTemplateEngine(new FreemarkerTemplateEngine());
    mpg.execute();
    System.out.println("代码生成成功");
  }

  private static void inputGenerate(InputGenerateDTO info, String path) {
    String folderPath =
        System.getProperty("user.dir") + sep + "company" + sep + "src" + sep + "main" + sep
            + "resources" + sep + "templates" + sep;
    Version version = new Version("2.3.23");
    Configuration cfg = new Configuration(version);
    String ftlFile = "input.java.ftl";
    try {
      File f = new File(
          path + "/com/detective/stone/awakening/company/input/" + info.getTable().getEntityName()
              + "Input.java");
      f.createNewFile();
      cfg.setDirectoryForTemplateLoading(new File(folderPath));
      Template template = cfg.getTemplate(ftlFile, "utf-8");
      Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "UTF-8"));
      template.process(info, out);
      out.flush();
    } catch (Exception e) {
      log.info("io出错");
    }
  }

}
