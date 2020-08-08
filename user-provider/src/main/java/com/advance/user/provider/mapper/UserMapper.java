package com.advance.user.provider.mapper;

import com.advance.domain.dto.UserDTO;
import com.advance.domain.entity.User;
import com.advance.domain.vo.UserVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author advance
 * @since 2020-07-21
 */
public interface UserMapper extends BaseMapper<User> {

    IPage<UserVO> listUserPage(Page page, @Param("param") UserDTO userDTO);

}
