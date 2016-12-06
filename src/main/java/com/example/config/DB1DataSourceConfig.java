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
@MapperScan(basePackages = DB1DataSourceConfig.PACKAGE, sqlSessionFactoryRef = "db1SqlSessionFactory")
public class DB1DataSourceConfig {
  static final String PACKAGE = "com.example.dao.db1";

  @Bean(name = "db1DataSource")
  @Primary
  @ConfigurationProperties(prefix = "spring.datasource.db1")
  public DataSource db1DataSource(){
    return DataSourceBuilder.create().type(DruidDataSource.class).build();
  }

  @Bean(name = "db1TransactionManager")
  @Primary
  public DataSourceTransactionManager db1TransactionManager(@Qualifier("db1DataSource") DataSource db1DataSource) {
    return new DataSourceTransactionManager(db1DataSource);
  }

  @Bean(name = "db1SqlSessionFactory")
  @Primary
  public SqlSessionFactory db1SqlSessionFactory(@Qualifier("db1DataSource") DataSource db1DataSource) throws Exception {
    final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(db1DataSource);
    ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    sessionFactory.setMapperLocations(resolver.getResources("classpath:/mapper/db1/*.xml"));
    return sessionFactory.getObject();
  }
}
