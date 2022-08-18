package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

/**
 * 用户模块的持久层接口
 */
public interface UserMapper {


//    返回受影响的行数，来判断是否执行成功

    Integer insert(User user);

    //找到返回用户数据，没找到返回null
    User findByUsername(String username);

    @Select("select * from t_user where username=#{username} and password=#{password}")
    //用户登入
    User UserLogin(String username,String password);

    //根据用id修改密码
    @Update("UPDATE t_user SET password=#{password}, modified_user=#{modifiedUser},modified_time=#{modifiedTime} where uid=#{uid}")
    Integer updatePassword(Integer uid, String password, String modifiedUser, Date modifiedTime);


    //根据uid存不存在
    @Select("select * from t_user where uid=#{uid}")
    User findByUid(Integer uid );

    //修改个人资料
    @Update("update t_user set phone=#{phone},email=#{email},gender=#{gender} where uid=${uid}")
    User updateData(Integer uid,String phone,String email,Integer gender);

    @Update("update t_user set avatar=#{avatar},modified_user=#{modifiedUser},modified_time=#{modifiedTime} where uid=#{uid}")
    //更新头像
    Integer updateAvatarByUid(Integer uid, String avatar, String modifiedUser, Date modifiedTime);

}
