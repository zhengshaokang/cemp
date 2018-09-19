package com.zhlx.cemp.service;

import com.zhlx.cemp.util.BeanUtils;
import com.zhlx.cemp.cmd.ListUserMenuCmd;
import com.zhlx.cemp.dto.ListUserMenuDto;
import com.zhlx.cemp.mapper.UserMenuMapper;
import com.zhlx.cemp.model.UserMenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMenuService {

    @Autowired
    private UserMenuMapper userMenuMapper;

    public List<ListUserMenuDto> listUserMenu(ListUserMenuCmd cmd){
        UserMenu userMenu = BeanUtils.copyProperties(cmd, UserMenu.class);
        List<UserMenu> userMenusList = userMenuMapper.select(userMenu);
        return BeanUtils.copyList(userMenusList,ListUserMenuDto.class);
    }
}
