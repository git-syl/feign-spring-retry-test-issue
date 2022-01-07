package com.zhichanzaixian.trademarkapi.comm.result;


import com.fasterxml.jackson.annotation.JsonView;

import java.io.Serializable;

/**
 * @author syl  Date: 2018/6/25 Email:
 */

@JsonView(Result.ResultView.class)
public class Result<T>  implements Serializable {

   // @ApiModelProperty(value = "0为成功。其他为失败")

    private int code;

    //@ApiModelProperty(value = "msg错误信息")

    private String message;

    //@ApiModelProperty(value = "返回数据")
    private T data;

    private Result(T data) {
        this.code = 0;
        this.message = "success";
        this.data = data;
    }

    private Result(CodeMsg codeMsg) {
        if (codeMsg == null) {
            return;
        }
        this.code = codeMsg.getCode();
        this.message = codeMsg.getMsg();
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }

    public static <T> Result<T> error(CodeMsg codeMsg) {
        if (codeMsg == null) {
            codeMsg = CodeMsg.PARAM_ERROR;
        }
        return new Result<T>(codeMsg);
    }


    public interface ResultView {

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
