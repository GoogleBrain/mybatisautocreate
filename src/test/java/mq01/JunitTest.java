package mq01;

import org.junit.Test;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class JunitTest {

	@Test
	public void testGenerator() {
		// 1.全局配置
		GlobalConfig config = new GlobalConfig();
		config.setActiveRecord(false) // 是否支持AR模式
				.setAuthor("hudaxian") // 作者
				.setOutputDir("E:\\mybatis2021\\mq02\\src\\main\\java")
				// 生成路径
				.setFileOverride(true)// 文件覆盖
				.setServiceName("%sService") // 设置生成的service接口名
				.setIdType(IdType.AUTO) // 主键策略
				.setBaseResultMap(true).setBaseColumnList(true);

		// 2.数据源相关配置
		DataSourceConfig dsConfig = new DataSourceConfig();
		dsConfig.setDbType(DbType.MYSQL).setUrl("jdbc:mysql://localhost:3306/mp").setDriverName("com.mysql.jdbc.Driver")
				.setUsername("root").setPassword("King1234.");
		// 3.策略配置
		StrategyConfig stConfig = new StrategyConfig();
		stConfig.setCapitalMode(true) // 全局大写命名
				.setDbColumnUnderline(true) // 表名 字段名 是否使用下滑线命名
				.setNaming(NamingStrategy.underline_to_camel) // 数据库表映射到实体的命名策略，下划线转驼峰的。
				.setInclude("tbl_employee") // 逆向工程需要用的表,如果不写的话默认是整个库的表。
				.setTablePrefix("tbl_"); // 表前缀，只找tbl_开头的。
		// 4.包名策略
		PackageConfig pkConfig = new PackageConfig();
		pkConfig.setParent("cn.k").setController("controller").setEntity("beans").setXml("mapper")
				.setService("service");
		AutoGenerator ag = new AutoGenerator().setGlobalConfig(config).setDataSource(dsConfig).setStrategy(stConfig)
				.setPackageInfo(pkConfig);
		ag.execute();
	}
}
