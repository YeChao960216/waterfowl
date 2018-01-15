package cn.zhku.waterfowl.util.modle;

/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2017/12/1 15:46.
 * 说明：
 */
public class Msg {
    //状态码
    private String status;
    //具体信息
    private String msg;

    //  返回的信息代码
    private String code;

    //  返回的信息
    private Object object;


    public Msg() {
    }

    public Msg(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Msg(String status, String msg, String code) {
        this.status = status;
        this.msg = msg;
        this.code = code;
    }

    public Msg(String status, String msg, String code, Object object) {
        this.status = status;
        this.msg = msg;
        this.code = code;
        this.object = object;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                ", object=" + object +
                '}';
    }


}

