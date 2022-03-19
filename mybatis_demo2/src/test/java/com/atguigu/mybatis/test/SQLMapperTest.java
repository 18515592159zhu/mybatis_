package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.SQLMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author zhuchifeng
 * @since 2022-03-18
 */
public class SQLMapperTest {

    @Test
    public void testGsetUserLike() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper sqlMapper = sqlSession.getMapper(SQLMapper.class);
        //select * from t_user where username like '%a%'
        //select * from t_user where username like "%"?"%"
        User user = sqlMapper.getUserByLike("a");
        System.out.println(user);
    }

    @Test
    public void testdeleteMore() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper sqlMapper = sqlSession.getMapper(SQLMapper.class);
        //delete from t_user where id in (2,3)
        int result = sqlMapper.deleteMore("2,3");
        System.out.println(result);
    }

    @Test
    public void testGetUserByTableName() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper sqlMapper = sqlSession.getMapper(SQLMapper.class);
        List<User> list = sqlMapper.getUserByTableName("t_user");
        list.forEach(System.out::println);
    }

    @Test
    public void testGInsertUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SQLMapper sqlMapper = sqlSession.getMapper(SQLMapper.class);
        User user = new User(null, "王五", "123", 23, "男", "123@163.com");
        sqlMapper.insertUser(user);
        System.out.println(user);//User{id=8, username='王五', password='123', age=23, sex='男', email='123@163.com'}
    }
}
