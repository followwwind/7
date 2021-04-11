package com.wind.boot.config;


import com.wind.boot.config.persistence.annotation.SqlMapper;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @fileName DataSourceConfig
 * @package com.ancda.payservice.config
 * @description 扫描 Mapper 接口并容器管理
 * @author huanghy
 * @date 2018-05-05 16:55:52
 * @version V1.0
 */
@Configuration
@MapperScan(basePackages = DataSourceConfig.PACKAGE, sqlSessionFactoryRef = "sqlSessionFactory", annotationClass = SqlMapper.class)
public class DataSourceConfig {

    private Logger logger = LogManager.getLogger(DataSourceConfig.class);

    public static final String PACKAGE = "com.wind.boot.dao";

    private static final String LOCATION = "classpath:mappers/*.xml";

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.cachePrepStmts}")
    private Boolean cachePrepStmts;

    @Value("${spring.datasource.prepStmtCacheSize}")
    private Integer prepStmtCacheSize;

    @Value("${spring.datasource.prepStmtCacheSqlLimit}")
    private Integer prepStmtCacheSqlLimit;

    @Value("${spring.datasource.useServerPrepStmts}")
    private Boolean useServerPrepStmts;

    @Value("${spring.datasource.useLocalSessionState}")
    private Boolean useLocalSessionState;

    @Value("${spring.datasource.rewriteBatchedStatements}")
    private Boolean rewriteBatchedStatements;

    @Value("${spring.datasource.cacheResultSetMetadata}")
    private Boolean cacheResultSetMetadata;

    @Value("${spring.datasource.cacheServerConfiguration}")
    private Boolean cacheServerConfiguration;

    @Value("${spring.datasource.elideSetAutoCommits}")
    private Boolean elideSetAutoCommits;

    @Value("${spring.datasource.maintainTimeStats}")
    private Boolean maintainTimeStats;

    /**
     * 初始化数据库连接
     * @return
     */
    @Bean(name="dataSource")
    public DataSource testDataSource(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.addDataSourceProperty("cachePrepStmts", cachePrepStmts);
        config.addDataSourceProperty("prepStmtCacheSize", prepStmtCacheSize);
        config.addDataSourceProperty("prepStmtCacheSqlLimit", prepStmtCacheSqlLimit);
        config.addDataSourceProperty("useServerPrepStmts", useServerPrepStmts);
        config.addDataSourceProperty("useLocalSessionState", useLocalSessionState);
        config.addDataSourceProperty("rewriteBatchedStatements", rewriteBatchedStatements);
        config.addDataSourceProperty("cacheResultSetMetadata", cacheResultSetMetadata);
        config.addDataSourceProperty("cacheServerConfiguration", cacheServerConfiguration);
        config.addDataSourceProperty("elideSetAutoCommits", elideSetAutoCommits);
        config.addDataSourceProperty("elideSetAutoCommits", elideSetAutoCommits);
        return new HikariDataSource(config);
    }

    /**
     * 创建Session
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean(name="sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        Resource[] resource = new PathMatchingResourcePatternResolver().getResources(LOCATION);
        sqlSessionFactoryBean.setMapperLocations(resource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name="sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
