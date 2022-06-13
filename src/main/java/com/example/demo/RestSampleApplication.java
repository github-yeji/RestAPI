package com.example.demo;


import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
@MapperScan(value= {"com.example.demo.recipe.mapper"})
//@ComponentScan(basePackages = "com.example.demo.recipe.service")
public class RestSampleApplication {

   public static void main(String[] args) {
      SpringApplication.run(RestSampleApplication.class, args);
   }
   
   //Mapper  인터페이스 인식실패 방지
   @Bean
   public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
       SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
       sessionFactory.setDataSource(dataSource);
       
       Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*Mapper.xml");
       
       sessionFactory.setMapperLocations(res);
       
       return sessionFactory.getObject();
   }
   
    @Bean
    public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
   
   @Bean
   public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
       HiddenHttpMethodFilter filter = new HiddenHttpMethodFilter();
       return filter;
   }
}