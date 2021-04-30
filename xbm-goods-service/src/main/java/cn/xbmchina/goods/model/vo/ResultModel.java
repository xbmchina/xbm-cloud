package cn.xbmchina.goods.model.vo;

import java.io.Serializable;

public class ResultModel implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 7066077006430348190L;
    private String errorCode;
    private String message;
    private Object data;

    public ResultModel() {

    }

    public ResultModel(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public ResultModel(String errorCode, String message, Object data) {
        this.errorCode = errorCode;
        this.message = message;
        this.data = data;
    }

    public String geterrorCode() {
        return errorCode;
    }

    public void seterrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResultModel ok() {
        return new ResultModel("0000","成功");
    }

    public static ResultModel ok(Object data) {
        return new ResultModel("0000","成功", data);
    }

    public static ResultModel error() {
        return new ResultModel("1111","失败");
    }

    public static ResultModel error(String msg) {
        return new ResultModel("1111","失败", msg);
    }

    public static ResultModel error(String msg, Object data) {
        return new ResultModel("1111", msg, data);
    }
}