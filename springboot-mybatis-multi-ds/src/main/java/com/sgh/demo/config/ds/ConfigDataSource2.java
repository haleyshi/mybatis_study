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
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;

/**
 * @author eguoshi
 *
 */
@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = ConfigDataSource2.PACKAGE, sqlSessionFactoryRef = "ds2SqlSessionFactory")
public class ConfigDataSource2 {

    // 精确到 ds2 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.sgh.demo.dao.ds2";
    static final String MAPPER_LOCATION = "classpath:mapper/ds2/*.xml";

    @Value("${ds2.datasource.url}")
    private String url;

    @Value("${ds2.datasource.username}")
    private String user;

    @Value("${ds2.datasource.password}")
    private String password;

    @Value("${ds2.datasource.driverClassName}")
    private String driverClass;

    @Bean(name = "ds2DataSource")
    @Primary
    public DataSource ds2DataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "ds2TransactionManager")
    @Primary
    public DataSourceTransactionManager ds2TransactionManager() {
        return new DataSourceTransactionManager(ds2DataSource());
    }

    @Bean(name = "ds2SqlSessionFactory")
    @Primary
    public SqlSessionFactory ds2SqlSessionFactory(@Qualifier("ds2DataSource") DataSource ds2DataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(ds2DataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(ConfigDataSource2.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
