package com.advance.user.provider.service;

import com.advance.user.api.IUserService;
import com.advance.consts.SysConsts;
import com.advance.domain.dto.UserDTO;
import com.advance.domain.entity.User;
import com.advance.domain.vo.UserVO;
import com.advance.user.provider.mapper.UserMapper;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author advance
 * @since 2020-07-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public IPage<UserVO> listUserPage(Page page, UserDTO userDTO) {
        return this.baseMapper.listUserPage(page, userDTO);
    }

    @Override
    public void saveUser(User user) {
        user.setStatus(SysConsts.DATA_VAILD);
        user.setCreateTime(LocalDateTime.now());
        save(user);
    }

    @Override
    public void updateUser(User user) {
        updateById(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.lambda().eq(User::getId, userId).set(User::getStatus, SysConsts.DATA_INVAILD);
        remove(userUpdateWrapper);
    }

    @Override
    public User selectUserByAccount(UserDTO userDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getAccount, userDTO.getAccount()).eq(User::getStatus, SysConsts.DATA_VAILD);
        return this.getOne(queryWrapper);
    }

    @Override
    public List<User> getUserList() {
        return this.list();
    }
}
