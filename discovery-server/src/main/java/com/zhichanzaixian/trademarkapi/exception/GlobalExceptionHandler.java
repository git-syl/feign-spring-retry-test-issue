package com.zhichanzaixian.trademarkapi.exception;



import com.zhichanzaixian.trademarkapi.comm.result.CodeMsg;
import com.zhichanzaixian.trademarkapi.comm.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * @author syl  Date: 2018/7/1 Email:
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);




    @ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest request, Exception e) {

        // e.printStackTrace();
        log.error("GlobalExceptionHandler:", e);

        if (e instanceof GlobalException) {
            GlobalException ex = (GlobalException) e;
            return Result.error(ex.getCm());
        } else if (e instanceof BindException) {
            BindException ex = (BindException) e;
            String message = "";
            if (ex.getBindingResult() != null && ex.getBindingResult().getFieldError() != null) {
                String field = ex.getBindingResult().getFieldError().getField();
                Object rejectedValue = ex.getBindingResult().getFieldError().getRejectedValue();
                message = ex.getAllErrors().get(0).getDefaultMessage() + "（ at:" + field + "，rejectValue:" + rejectedValue + "）";
            }

            return Result.error(CodeMsg.BIND_ERROR.findArgsObject(message));
        } else if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            String message = "";
            if (ex.getBindingResult() != null && ex.getBindingResult().getFieldError() != null) {
                String field = ex.getBindingResult().getFieldError().getField();
                Object rejectedValue = ex.getBindingResult().getFieldError().getRejectedValue();
                message = ex.getBindingResult().getAllErrors().get(0).getDefaultMessage() + "（ at:" + field + "，rejectValue:" + rejectedValue + "）";
            }
            return Result.error(CodeMsg.BIND_ERROR.findArgsObject(message));

        } else {
            return Result.error(CodeMsg.SERVER_ERROR_MSG.findArgsObject(e.getMessage()));
        }

    }


//    @ExceptionHandler(value = MySQLIntegrityConstraintViolationException.class)
//    public Result<String> exceptionHandler2(HttpServletRequest request, Exception e) {
//
//        // e.printStackTrace();
//        log.error("GlobalExceptionHandler:", e);
//        return Result.error(CodeMsg.SERVER_ERROR_MSG.findArgsObject("数据重复，请检查您的输入。 insert--"));
//
//    }
}
