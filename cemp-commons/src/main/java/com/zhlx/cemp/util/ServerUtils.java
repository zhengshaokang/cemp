package com.zhlx.cemp.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

/**
 * 作用：服务器工具类
 */
public class ServerUtils {

    /**
     * 作用：是否ajax请求
     *
     * @param request
     * @return boolean
     * @author winter
     * @date 2016年11月7日
     */
    public static boolean isAjax(HttpServletRequest request) {
        if (request != null && "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))) return true;
        return false;
    }

    /**
     * 作用：取客户端IP
     *
     * @param request
     * @return String
     * @author winter
     * @date 2016年11月7日
     */
    public static String getClientIp(HttpServletRequest request) {
        String forwards = request.getHeader("x-forwarded-for");
        if (StringUtils.isBlank(forwards) || "unknown".equalsIgnoreCase(forwards)) {
            forwards = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(forwards) || "unknown".equalsIgnoreCase(forwards)) {
            forwards = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(forwards) || "unknown".equalsIgnoreCase(forwards)) {
            forwards = request.getRemoteAddr();
        }
        if (StringUtils.isBlank(forwards) || "unknown".equalsIgnoreCase(forwards)) {
            forwards = request.getHeader("X-Real-IP");
        }
        if (forwards != null && forwards.trim().length() > 0) {
            int index = forwards.indexOf(',');
            return (index != -1) ? forwards.substring(0, index) : forwards;
        }
        return forwards;
    }

    /**
     * 作用：取本机IP
     *
     * @return String
     * @throws SocketException
     * @author winter
     * @date 2016年11月7日
     */
    public static String getLocalIp() throws SocketException {
        String localip = null;// 本地IP，如果没有配置外网IP则返回它
        String netip = null;// 外网IP
        Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
        InetAddress ip = null;
        boolean finded = false;// 是否找到外网IP
        while (netInterfaces.hasMoreElements() && !finded) {
            NetworkInterface ni = netInterfaces.nextElement();
            Enumeration<InetAddress> address = ni.getInetAddresses();
            while (address.hasMoreElements()) {
                ip = address.nextElement();
                if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {// 外网IP
                    netip = ip.getHostAddress();
                    finded = true;
                    break;
                } else if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {// 内网IP
                    localip = ip.getHostAddress();
                }
            }
        }
        if (netip != null && !"".equals(netip)) {
            return netip;
        } else {
            return localip;
        }
    }

}
