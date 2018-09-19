package com.zhlx.cemp.controller;

import com.zhlx.cemp.cmd.ListUserMenuCmd;
import com.zhlx.cemp.dto.ListUserMenuDto;
import com.zhlx.cemp.service.UserMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 作用：首页管理
 * 
 */
@Controller
@RequestMapping(value = "/main")
public class MainController extends BaseController {

    @Autowired
    private UserMenuService userMenuService;
//    @Resource
//    private BaseCurrencyService baseCurrencyService;
//    @Resource
//    private BaseDataService baseDataService;
//    @Resource
//    private BaseDistrictService baseDistrictService;
//    @Resource
//    private UserBuyerService userBuyerService;
//    @Resource
//    private UserInfoService userInfoService;
//    @Resource
//    private ProductItemService productItemService;
//    @Resource
//    private OrderInboundService orderInboundService;
//    @Resource
//    private OrderPurchaseService orderPurchaseService;
//    @Resource
//    private OrderOutboundService orderOutboundService;
//    @Resource
//    private AccountBalanceService accountBalanceService;

    /**
     * 作用：首页
     * 
     * @return
     * @return String
     *
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView main() {
//        UserInfoDto userInfo = getUserInfo();
//        // 菜单
        ListUserMenuCmd listUserMenuCmd = new ListUserMenuCmd();
        listUserMenuCmd.setType("1");
        List<ListUserMenuDto> menuList = userMenuService.listUserMenu(listUserMenuCmd);
        ModelAndView modelAndView = new ModelAndView("/main");
        modelAndView.addObject("menuList", menuList);
//        modelAndView.addObject("userInfo", userInfo);
//        // 供应商统计数据
//        if (UserContants.USER_TYPE_2.equals(userInfo.getType())) {
//            modelAndView.addObject("PRODUCT_STATUS_2",
//                    productItemService.countProductItem(new CountProductItemCmd(ProductContants.PRODUCT_STATUS_2)));// 待审核单品
//            modelAndView.addObject("PRODUCT_STATUS_3",
//                    productItemService.countProductItem(new CountProductItemCmd(ProductContants.PRODUCT_STATUS_3)));// 待销售单品
//            modelAndView.addObject("ORDER_INBOUND_STATUS_1", orderInboundService
//                    .countOrderInbound(new CountOrderInboundCmd(OrderContants.ORDER_INBOUND_STATUS_1)));// 待审核入库单
//            modelAndView.addObject("ORDER_INBOUND_STATUS_2", orderInboundService
//                    .countOrderInbound(new CountOrderInboundCmd(OrderContants.ORDER_INBOUND_STATUS_2)));// 已审核入库单
//            modelAndView.addObject("ORDER_PURCHASE_STATUS_1", orderPurchaseService
//                    .countOrderPurchase(new CountOrderPurchaseCmd(OrderContants.ORDER_PURCHASE_STATUS_1)));// 待确认采购单
//            modelAndView.addObject("ORDER_PURCHASE_STATUS_3", orderPurchaseService
//                    .countOrderPurchase(new CountOrderPurchaseCmd(OrderContants.ORDER_PURCHASE_STATUS_3)));// 待发货采购单
//            modelAndView.addObject("ORDER_OUTBOUND_STATUS_2", orderOutboundService
//                    .countOrderOutbound(new CountOrderOutboundCmd(OrderContants.ORDER_OUTBOUND_STATUS_2)));// 待出库出库单
//        }
//        // 分销商统计数据
//        if (UserContants.USER_TYPE_3.equals(userInfo.getType())) {
//            modelAndView.addObject("ORDER_PURCHASE_STATUS_1", orderPurchaseService
//                    .countOrderPurchase(new CountOrderPurchaseCmd(OrderContants.ORDER_PURCHASE_STATUS_1)));// 待确认采购单
//            modelAndView.addObject("ORDER_PURCHASE_STATUS_2", orderPurchaseService
//                    .countOrderPurchase(new CountOrderPurchaseCmd(OrderContants.ORDER_PURCHASE_STATUS_2)));// 待付款采购单
//            modelAndView.addObject("ORDER_OUTBOUND_STATUS_2", orderOutboundService
//                    .countOrderOutbound(new CountOrderOutboundCmd(OrderContants.ORDER_OUTBOUND_STATUS_2)));// 待出库出库单
//            // 账户余额
//            QueryAccountBalanceCmd queryAccountBalanceCmd = new QueryAccountBalanceCmd();
//            queryAccountBalanceCmd.setUserId(getUserInfo().getId());
//            queryAccountBalanceCmd.setCurrencyId(BaseContants.CURRENCY_CNY);// 人民币
//            queryAccountBalanceCmd.setWithCurrencyName(true);
//            AccountBalanceDto accountBalance = accountBalanceService.queryAccountBalance(queryAccountBalanceCmd);
//            modelAndView.addObject("accountBalance", accountBalance);
//        }
        return modelAndView;
    }

    /**
     * 作用：修改密码页
     * 
     * @return
     * @return ModelAndView
     *
     */
    @RequestMapping(value = "/modifyPassword", method = RequestMethod.GET)
    public ModelAndView modifyPassword() {
        return new ModelAndView("/modifyPassword");
    }

    /**
     * 作用：修改密码
     * 
     * @param cmd
     * @return
     * @return ModelAndView
     *
     */
//    @RequestMapping(value = "/modifyPassword", method = RequestMethod.POST)
//    public ModelAndView modifyPassword(ModifyUserPasswordCmd cmd) {
//        userInfoService.modifyUserPassword(cmd);
//        return ajaxDoneSuccess();
//    }

}
