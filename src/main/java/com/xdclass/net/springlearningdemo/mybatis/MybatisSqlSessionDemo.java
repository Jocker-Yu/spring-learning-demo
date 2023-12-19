package com.xdclass.net.springlearningdemo.mybatis;

import com.xdclass.net.springlearningdemo.mybatis.entity.Topic;
import com.xdclass.net.springlearningdemo.mybatis.mapper.TopicMapper;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @description: demo
 * @author: Joker.yu 2023-12-15 09:08
 **/
public class MybatisSqlSessionDemo {

  public static void main(String[] args) throws IOException {
    String resouce = "mybatis/mybatis-config.xml";
    //读取配置文件
    InputStream inputStream =  Resources.getResourceAsStream(resouce);
    //构建Session工厂
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    //获取Session
    try(SqlSession sqlSession = sqlSessionFactory.openSession()){
      TopicMapper topicMapper = sqlSession.getMapper(TopicMapper.class);
      for (int i = 0; i < 3; i++) {
        Topic video = topicMapper.query(22);
        System.out.println(video.toString());
      }
//      List<Video> videoList =  videoMapper.selectList();
//      System.out.println(videoList.toString());
    }
  }
}
