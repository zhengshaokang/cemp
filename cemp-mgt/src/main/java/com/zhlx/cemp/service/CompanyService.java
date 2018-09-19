package com.zhlx.cemp.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhlx.cemp.constant.ErrorCodes;
import com.zhlx.cemp.exception.GlobalException;
import com.zhlx.cemp.page.Page;
import com.zhlx.cemp.page.PageData;
import com.zhlx.cemp.util.BeanUtils;
import com.zhlx.cemp.util.DateUtils;
import com.zhlx.cemp.cmd.*;
import com.zhlx.cemp.dto.GetCompanyDto;
import com.zhlx.cemp.dto.ListCompanyDto;
import com.zhlx.cemp.dto.PageCompanyDto;
import com.zhlx.cemp.mapper.CompanyMapper;
import com.zhlx.cemp.model.Company;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.Date;
import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    public GetCompanyDto getCompany(GetCompanyCmd cmd) {
        Company company =
                companyMapper.selectOne(BeanUtils.copyProperties(cmd, Company.class));
        return BeanUtils.copyProperties(company, GetCompanyDto.class);
    }

    public List<ListCompanyDto> listCompany() {
        List<Company> companyList = companyMapper.selectAll();
        return BeanUtils.copyList(companyList, ListCompanyDto.class);
    }

    public PageData<PageCompanyDto> pageCompany(PageCompanyCmd cmd) {
        Weekend<Company> weekend = Weekend.of(Company.class);
        WeekendCriteria<Company, Object> criteria = weekend.weekendCriteria();
        if (StringUtils.isNotBlank(cmd.getName())) {
            criteria.andLike(Company::getName, "%" + cmd.getName() + "%");
        }
        if (StringUtils.isNotBlank(cmd.getStatus())) {
            criteria.andEqualTo(Company::getStatus, cmd.getStatus());
        }
        criteria.andGreaterThanOrEqualTo(Company::getCreatedTime, DateUtils.getDatetimeStart(cmd.getCreatedTimeStart()));
        criteria.andLessThanOrEqualTo(Company::getCreatedTime, DateUtils.getDatetimeEnd(cmd.getCreatedTimeEnd()));
        criteria.andEqualTo(Company::getDeleted, "0");
        PageHelper.startPage(cmd.getPage().getPageNum(), cmd.getPage().getPageSize());
        List<Company> companyList = companyMapper.selectByExample(weekend);
        PageInfo<Company> pageInfo = new PageInfo<Company>(companyList);
        List<PageCompanyDto> pageCompanyDtoList =
                BeanUtils.copyList(pageInfo.getList(), PageCompanyDto.class);
        return new PageData<PageCompanyDto>(pageCompanyDtoList, BeanUtils.copyProperties(pageInfo, Page.class));
    }

    @Transactional(rollbackFor = Exception.class)
    public void createCompany(CreateCompanyCmd cmd) {
        // 校验
        validateCompanyName(cmd.getName(), true);
        Company company = BeanUtils.copyProperties(cmd, Company.class);
        company.setCreatedTime(new Date());
        companyMapper.insertSelective(company);
    }

    @Transactional(rollbackFor = Exception.class)
    public void modifyCompany(ModifyCompanyCmd cmd) {
        Company company = BeanUtils.copyProperties(cmd, Company.class);
        company.setModifiedTime(new Date());
        companyMapper.updateByPrimaryKeySelective(company);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteCompany(DeleteCompanyCmd cmd) {
        Company company = BeanUtils.copyProperties(cmd, Company.class);
        company.setModifiedTime(new Date());
        company.setDeleted("1");
        companyMapper.updateByPrimaryKeySelective(company);
    }

    public boolean validateCompanyName(String name, boolean isThrow) {
        if (StringUtils.isBlank(name)) {
            return false;
        }
        Company validateCompany = new Company();
        validateCompany.setName(name);
        // 数据已存在
        if (companyMapper.selectOne(validateCompany) != null) {
            if (isThrow) {
                throw new GlobalException(ErrorCodes.EC_10003);
            } else {
                return false;
            }
        }
        return true;
    }

}
