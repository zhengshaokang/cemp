package com.zhlx.cemp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.zhlx.cemp.constant.ErrorCodes;
import com.zhlx.cemp.exception.GlobalException;
import com.zhlx.cemp.spring.editor.DateEditor;
import com.zhlx.cemp.spring.editor.DoubleEditor;
import com.zhlx.cemp.spring.editor.IntegerEditor;
import com.zhlx.cemp.spring.editor.LongEditor;
import com.zhlx.cemp.util.ServerUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Locale;

public abstract class BaseController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private MessageSource messageSource;

    // @Autowired
    // protected SpringContextHolder _contextHolder;

    @InitBinder
    protected void initBinder(ServletRequestDataBinder binder) throws Exception {
        binder.registerCustomEditor(int.class, new IntegerEditor());
        binder.registerCustomEditor(long.class, new LongEditor());
        binder.registerCustomEditor(double.class, new DoubleEditor());
        binder.registerCustomEditor(Date.class, new DateEditor());
    }

    protected ModelAndView ajaxDone(int statusCode, String message, String forwardUrl) {
        ModelAndView mav = new ModelAndView("ajaxDone");
        mav.addObject("statusCode", statusCode);
        mav.addObject("message", message);
        mav.addObject("forwardUrl", forwardUrl);
        return mav;
    }

    protected ModelAndView ajaxDoneSuccess() {
        return ajaxDoneSuccess(getMessage("msg.operation.success"));
    }

    protected ModelAndView ajaxDoneSuccess(String message) {
        return ajaxDone(200, message, "");
    }

    protected ModelAndView ajaxDoneError() {
        return ajaxDoneError(getMessage("msg.operation.failure"));
    }

    protected ModelAndView ajaxDoneError(String message) {
        return ajaxDone(300, message, "");
    }

    protected String getMessage(String code) {
        return this.getMessage(code, new Object[]{});
    }

    protected String getMessage(String code, Object arg0) {
        return getMessage(code, new Object[]{arg0});
    }

    protected String getMessage(String code, Object arg0, Object arg1) {
        return getMessage(code, new Object[]{arg0, arg1});
    }

    protected String getMessage(String code, Object arg0, Object arg1, Object arg2) {
        return getMessage(code, new Object[]{arg0, arg1, arg2});
    }

    protected String getMessage(String code, Object arg0, Object arg1, Object arg2, Object arg3) {
        return getMessage(code, new Object[]{arg0, arg1, arg2, arg3});
    }

    protected String getMessage(String code, Object[] args) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(code, args, locale);
    }

//    protected UserInfoDto getUserInfo() {
//        return AppContextHolder.getContext().getUser();
//    }

    protected MultipartFile getMultipartFile(HttpServletRequest request, String inputName) {
        // 判断 request 是否有文件上传
        if (request instanceof MultipartHttpServletRequest) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            MultipartFile multipartFile = multiRequest.getFile(inputName);
            if (multipartFile != null && !multipartFile.isEmpty()) {
                return multipartFile;
            }
        }
        return null;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView exception(Exception e, HttpServletRequest request) {
        e.printStackTrace();
        request.setAttribute("exception", e);
        // 系统异常，请联系我们
        String errorCode = ErrorCodes.EC_10001;
        Object[] params = null;
        String message = null;
        if (e instanceof GlobalException) {
            GlobalException globalException = (GlobalException) e;
            errorCode = globalException.getErrorCode();
            params = globalException.getParams();
        }
        // 数据校验不通过
        if (e instanceof BindException) {
            BindException bindException = (BindException) e;
            // 只返回一个
            FieldError fieldError = bindException.getFieldErrors().get(0);
            errorCode = ErrorCodes.EC_10002;
            StringBuilder msg = new StringBuilder();
            msg.append("[").append(fieldError.getField()).append("]").append(fieldError.getDefaultMessage());
            message = msg.toString();
        }
        if (message == null) {
            message = getMessage(errorCode, params);
        }
        if (ServerUtils.isAjax(request) || request.getParameter("ajax") != null) {
            return ajaxDoneError(message);
        }
        return new ModelAndView("error");
    }

    /**
     * 作用：输出excel文件到客户端
     *
     * @param fileName
     * @return ResponseEntity<byte   [   ]>
     */
    protected ResponseEntity<byte[]> writeFile(String fileName) {
        HttpHeaders headers = new HttpHeaders();
        byte[] body = null;
        HttpStatus httpState = HttpStatus.NOT_FOUND;
        String filePath = null;
//      String filePath = GlobalContants.TEMP_DOWNLOAD_PATH + GlobalContants.URL_SEPARATOR + fileName;
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
            InputStream is;
            try {
                is = new FileInputStream(filePath);
                body = new byte[is.available()];
                is.read(body);
                is.close();
                headers.add("Content-Type", "application/vnd.ms-excel");
                headers.add("Content-Length", "" + body.length);
                headers.add("Content-Disposition", "attachment;filename=" + fileName);
                httpState = HttpStatus.OK;
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, httpState);
        return entity;
    }

}
