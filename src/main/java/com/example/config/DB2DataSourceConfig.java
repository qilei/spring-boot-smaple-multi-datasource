package com.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * Created by qilei on 16/11/17.
 */
@Configuration
@MapperScan(basePackages = DB2DataSourceConfig.PACKAGE, sqlSessionFactoryRef = "db2SqlSessionFactory")
public class DB2DataSourceConfig {
  static final String PACKAGE = "com.example.dao.db2";

  @Bean(name = "db2DataSource")
  @ConfigurationProperties(prefix = "spring.datasource.db2")
  public DataSource db2DataSource() {
    return DataSourceBuilder.create().type(DruidDataSource.class).build();
  }

  @Bean(name = "db2TransactionManager")
  public DataSourceTransactionManager db2TransactionManager(@Qualifier("db2DataSource") DataSource db2DataSource) {
    return new DataSourceTransactionManager(db2DataSource);
  }

  @Bean(name = "db2SqlSessionFactory")
  public SqlSessionFactory db2SqlSessionFactory(@Qualifier("db2DataSource") DataSource db2DataSource) throws Exception {
    final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(db2DataSource);
    ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    sessionFactory.setMapperLocations(resolver.getResources("classpath:/mapper/db2/*.xml"));
    return sessionFactory.getObject();
  }
}
