package com.tupu360;

import com.tupu360.mybatis.mapper.UUserInfoMapper;
import com.tupu360.mybatis.model.UUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class Application {
    public static void main(String[] args) {

        SqlSession session = null;
        try {
            //第一步：读取mybatis-config.xml配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            /**
             * Resources
             *
             * ClassLoaderWrapper 类加载器包装类
             */

            //第二步：构建SqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,"test");

            //第三步：打开SqlSession
            session = sqlSessionFactory.openSession();

            //第四步：获取Mapper接口对象
            UUserInfoMapper uUserInfoMapper = session.getMapper(UUserInfoMapper.class);



            //第五步：调用Mapper接口对象的方法操作数据库；
            UUserInfo userInfo = new UUserInfo("王八蛋");
            uUserInfoMapper.insert(userInfo);
            session.commit();
//            UUserInfo uUserInfo = uUserInfoMapper.selectByPrimaryKey(1001);

            //第六步：业务处理
            log.info("查询结果: " + userInfo);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != session) {
                session.close();
            }
        }
    }
}
