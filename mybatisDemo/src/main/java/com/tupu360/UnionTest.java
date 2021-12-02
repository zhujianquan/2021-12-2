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

/**
 * @author ZhuJianquan
 * @date 2021/11/30 16:35
 */
@Slf4j
public class UnionTest {
    public static void main(String[] args) {
        SqlSession session = null;
        try {
            //第一步：读取mybatis-config.xml配置文件
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

            //第二步：构建SqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream,"test");

            //第三步：打开SqlSession
            session = sqlSessionFactory.openSession();

            //第四步：获取Mapper接口对象
            UUserInfoMapper uUserInfoMapper = session.getMapper(UUserInfoMapper.class);


            //第五步：调用Mapper接口对象的方法操作数据库；
            UUserInfo uUserInfo = uUserInfoMapper.selectByUid(1004);

            //第六步：业务处理
            log.info("查询结果: " + uUserInfo);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != session) {
                session.close();
            }
        }

    }
}
