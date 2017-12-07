/**
 * 
 */
package com.sgh.demo.config.ds;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;

/**
 * @author eguoshi
 *
 */
@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = ConfigDataSource1.PACKAGE, sqlSessionFactoryRef = "ds1SqlSessionFactory")
public class ConfigDataSource1 {

    // 精确到 ds1 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.sgh.demo.dao.ds1";
    static final String MAPPER_LOCATION = "classpath:mapper/ds1/*.xml";

    @Value("${ds1.datasource.url}")
    private String url;

    @Value("${ds1.datasource.username}")
    private String user;

    @Value("${ds1.datasource.password}")
    private String password;

    @Value("${ds1.datasource.driverClassName}")
    private String driverClass;

    @Bean(name = "ds1DataSource")
    public DataSource ds1DataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "ds1TransactionManager")
    public DataSourceTransactionManager ds1TransactionManager() {
        return new DataSourceTransactionManager(ds1DataSource());
    }

    @Bean(name = "ds1SqlSessionFactory")
    public SqlSessionFactory ds1SqlSessionFactory(@Qualifier("ds1DataSource") DataSource ds1DataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(ds1DataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(ConfigDataSource1.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
