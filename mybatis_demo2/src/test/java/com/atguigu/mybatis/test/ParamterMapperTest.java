package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.ParamterMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhuchifeng
 * @since 2022-03-18
 */
public class ParamterMapperTest {

    /**
     * MyBatis获取参数值的两种方式：${}和#{}
     * ${}本质字符串拼接
     * #{}本质占位符赋值
     * MyBatis获取参数值的各种情况：
     * 1、mapper接口方法的参数为单个的字面量类型
     * 可以通过${}和#{}以任意的名称获取参数值，但是需要注意${}的单引号问题
     * 2、mapper接口方法的参数为多个时
     * 此时MyBatis会将这些参数放在一个map集合中，以两种方式进行存储
     * a>以arg0,arg1...为键，以参数为值
     * b>以param1,param2...为键，以参数为值
     * 因此只需要通过#{}和${}以键的方式访问值即可，但是需要注意${}的单引号问题
     * 3、若mapper接口方法的参数有多个时，可以手动将这些参数放在一个map中存储
     * 只需要通过#{}和${}以键的方式访问值即可，但是需要注意${}的单引号问题
     * 4、mapper接口方法的参数是实体类类型的参数
     * 只需要通过#{}和${}以属性的方式访问属性值即可，但是需要注意${}的单引号问题
     * 5、使用@Param注解命名参数
     * 此时MyBatis会将这些参数放在一个map集合中，以两种方式进行存储
     * a>以@Param注解的值为键，以参数为值
     * b>以param1,param2...为键，以参数为值
     * 因此只需要通过#{}和${}以键的方式访问值即可，但是需要注意${}的单引号问题
     */

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParamterMapper paramterMapper = sqlSession.getMapper(ParamterMapper.class);
        List<User> userList = paramterMapper.getAllUser();
        userList.forEach(user -> System.out.println(user));
    }

    @Test
    public void testGetUserByUsername() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParamterMapper paramterMapper = sqlSession.getMapper(ParamterMapper.class);
        User user = paramterMapper.getUserByUsername("admin");
        System.out.println(user);
    }

    @Test
    public void testChckLogin() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParamterMapper paramterMapper = sqlSession.getMapper(ParamterMapper.class);
        User user = paramterMapper.checkLogin("admin", "123456");
        System.out.println(user);
    }

    @Test
    public void testChckLoginByMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParamterMapper paramterMapper = sqlSession.getMapper(ParamterMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "admin");
        map.put("password", "123456");
        User user = paramterMapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParamterMapper paramterMapper = sqlSession.getMapper(ParamterMapper.class);
        int result = paramterMapper.insertUser(new User(null, "小三", "123456", 23, "女", "xiaosan@qq.com"));
        System.out.println("result：" + result);
    }

    @Test
    public void testChckLoginByParam() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParamterMapper paramterMapper = sqlSession.getMapper(ParamterMapper.class);
        User user = paramterMapper.checkLoginByParam("admin", "123456");
        System.out.println(user);
    }
}