package com.advance.user.api;

import com.advance.domain.dto.UserDTO;
import com.advance.domain.entity.User;
import com.advance.domain.vo.UserVO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author advance
 * @since 2020-07-21
 */
public interface IUserService extends IService<User> {

    IPage<UserVO> listUserPage(Page page, UserDTO userDTO);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(Integer userId);

    User selectUserByAccount(UserDTO userDTO);

    List<User> getUserList();

}
