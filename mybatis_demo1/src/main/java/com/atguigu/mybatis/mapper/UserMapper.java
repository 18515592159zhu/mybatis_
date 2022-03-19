package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;

/**
 * @author zhuchifeng
 * @since 2022-03-18
 */
public interface UserMapper {

    /**
     * Mybatis面向接口编程的两个一致：
     * 1、映射文件的namespace要和 mapper接口的全类名保持一致
     * 2、映射文件中SQL语句的id要和mapper接口中的方法名一致
     *
     * 表--实体类--mapper接口--映射文件
     */

    /**
     * 添加用户信息
     */
    int insertUser();

    /**
     * 删除用户信息
     * @return
     */
    int deleteUser();

    /**
     * 修改用户信息
     */
    int updateUser();

    /**
     * 根据id查询用户信息
     */
    User getUserById();

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> getUserList();

}