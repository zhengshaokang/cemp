package com.zhlx.cemp.controller;

import com.zhlx.cemp.constant.CommonDataTypes;
import com.zhlx.cemp.page.PageData;
import com.zhlx.cemp.cmd.*;
import com.zhlx.cemp.dto.GetCompanyDto;
import com.zhlx.cemp.dto.ListCommonDataDto;
import com.zhlx.cemp.dto.PageCompanyDto;
import com.zhlx.cemp.service.CommonDataService;
import com.zhlx.cemp.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * 作用：公司管理
 */
@Controller
@RequestMapping("/admin/company/")
public class CompanyController extends BaseController {

    @Autowired
    private CommonDataService commonDataService;
    @Autowired
    private CompanyService companyService;

    /**
     * 作用：公司列表
     *
     * @param cmd
     * @return ModelAndView
     */
    @RequestMapping(value = "page")
    public ModelAndView pageCompany(PageCompanyCmd cmd) {
        ListCommonDataCmd listCommonDataCmd = new ListCommonDataCmd();
        listCommonDataCmd.setType(CommonDataTypes.TYPE_COMMON_ENABLE_DISABLE);
        List<ListCommonDataDto> listCommonDataDtoList = commonDataService.listCommonData(listCommonDataCmd);
        PageData<PageCompanyDto> pageData = companyService.pageCompany(cmd);
        ModelAndView modelAndView = new ModelAndView("/company/page");
        if (pageData != null) {
            modelAndView.addObject("dataList", pageData.getDataList());
            modelAndView.addObject("page", pageData.getPage());
            cmd.setPage(pageData.getPage());
        }
        modelAndView.addObject("statusList", listCommonDataDtoList);
        modelAndView.addObject("cmd", cmd);
        return modelAndView;
    }

    /**
     * 作用：添加公司页
     *
     * @return ModelAndView
     */
    @RequestMapping(value = "create", method = RequestMethod.GET)
    public ModelAndView create() {
        return new ModelAndView("/company/create");
    }

    /**
     * 作用：添加公司
     *
     * @param cmd
     * @return ModelAndView
     */
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ModelAndView create(@Valid CreateCompanyCmd cmd) {
        companyService.createCompany(cmd);
        return ajaxDoneSuccess();
    }

    /**
     * 作用：修改公司页
     *
     * @param cmd
     * @return ModelAndView
     */
    @RequestMapping(value = "modify", method = RequestMethod.GET)
    public ModelAndView modify(GetCompanyCmd cmd) {
        GetCompanyDto data = companyService.getCompany(cmd);
        ModelAndView modelAndView = new ModelAndView("/company/modify");
        modelAndView.addObject("data", data);
        return modelAndView;
    }

    /**
     * 作用：修改公司
     *
     * @param cmd
     * @return ModelAndView
     */
    @RequestMapping(value = "modify", method = RequestMethod.POST)
    public ModelAndView modify(ModifyCompanyCmd cmd) {
        companyService.modifyCompany(cmd);
        return ajaxDoneSuccess();
    }

    /**
     * 作用：删除公司
     *
     * @param cmd
     * @return ModelAndView
     */
    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public ModelAndView delete(DeleteCompanyCmd cmd) {
        companyService.deleteCompany(cmd);
        return ajaxDoneSuccess();
    }

    /**
     * 作用：校验公司名
     *
     * @param name
     * @return boolean
     */
    @ResponseBody
    @RequestMapping(value = "validateName", method = RequestMethod.GET)
    public boolean validateName(String name) {
        try {
            return companyService.validateCompanyName(name, false);
        } catch (Exception e) {
            return false;
        }
    }

}
