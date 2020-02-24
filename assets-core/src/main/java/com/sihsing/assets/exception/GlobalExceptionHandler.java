package com.sihsing.assets.exception;

import com.google.gson.Gson;
import com.sihsing.assets.controller.dto.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  Christine 2020/01/06
 *  自定義Exception，捕捉全域的異常處理
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = {Exception.class})
    public String handle(Exception ex, HttpServletRequest req, HttpServletResponse resp, Model model) throws IOException {

        String errMsg = "";
        if (ex instanceof ServiceException) {
            errMsg = ex.getMessage();
        } else {
            logger.error("Error Msg:", ex);
            errMsg = "服务器内部错误";
        }

        if ("XMLHttpRequest".equals(req.getHeader("X-Requested-With"))
                || "application/json".equals(req.getHeader("Content-type"))) {
            Gson gson = new Gson();
            ApiResult<Void> result = new ApiResult<Void>();
            result.setCode(ApiResult.FAILD_CODE);
            result.setMsg(errMsg);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(gson.toJson(result));
            return null;
        } else {
            model.addAttribute("msg", errMsg);
        }
        return "/error";
    }

}
