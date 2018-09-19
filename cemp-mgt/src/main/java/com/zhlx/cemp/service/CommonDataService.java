package com.zhlx.cemp.service;

import com.zhlx.cemp.util.BeanUtils;
import com.zhlx.cemp.cmd.GetCommonDataCmd;
import com.zhlx.cemp.cmd.ListCommonDataCmd;
import com.zhlx.cemp.dto.GetCommonDataDto;
import com.zhlx.cemp.dto.ListCommonDataDto;
import com.zhlx.cemp.mapper.CommonDataMapper;
import com.zhlx.cemp.model.CommonData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonDataService {

    @Autowired
    private CommonDataMapper commonDataMapper;

    @Cacheable("getCommonData")
    public GetCommonDataDto getCommonData(GetCommonDataCmd cmd) {
        CommonData commonData =
                commonDataMapper.selectOne(BeanUtils.copyProperties(cmd, CommonData.class));
        return BeanUtils.copyProperties(commonData, GetCommonDataDto.class);
    }

    @Cacheable("listCommonData")
    public List<ListCommonDataDto> listCommonData(ListCommonDataCmd cmd) {
        CommonData commonData = BeanUtils.copyProperties(cmd, CommonData.class);
        commonData.setDeleted("0");
        List<CommonData> commonDataList = commonDataMapper.select(commonData);
        return BeanUtils.copyList(commonDataList, ListCommonDataDto.class);
    }
}
