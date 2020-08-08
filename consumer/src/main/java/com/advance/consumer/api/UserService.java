package com.advance.consumer.api;

import com.advance.user.api.IUserService;
import com.advance.domain.dto.UserDTO;
import com.advance.domain.entity.User;
import com.advance.domain.vo.UserVO;
import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: dubboDemo
 * @description: 用户请求服务实现类
 * @author: zhouh
 * @create: 2020-07-08 18:48
 **/
@Service
public class UserService {

    @Reference(cluster = "failfast", retries = 3, interfaceClass = IUserService.class, lazy = true, check = false, timeout = 5000)
    IUserService userServiceApi;

    public IPage<UserVO> getUserList(Page page, UserDTO userDTO){
        return userServiceApi.listUserPage(page, userDTO);
    }

    public void saveOrUpdateUser(User user){
        if(null != user.getId()){
            userServiceApi.updateUser(user);
        }else{
            userServiceApi.saveUser(user);
        }
    }

    public void deleteUser(Integer id){
        userServiceApi.deleteUser(id);
    }

    public List<User> getUserList(){
        return userServiceApi.getUserList();
    }

    public User getUserById(Integer id){
        return userServiceApi.getById(id);
    }

}
