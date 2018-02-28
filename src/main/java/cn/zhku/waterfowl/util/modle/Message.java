package cn.zhku.waterfowl.util.modle;

/**
 * @author 钱伟健 gonefutre
 * @date 2017/8/1 22:25.
 * @E-mail gonefuture@qq.com
 *
 * 说明：状态信息类
 */
public class Message {
   //状态码
    private String status;
    //具体信息
    private String msg;
    //用来放各种关键的属性，如userId
    private String key;

    public Message(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Message(String status, String msg, String key) {
        this.status = status;
        this.msg = msg;
        this.key = key;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Message{" +
                "status='" + status + '\'' +
                ", msg='" + msg + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}
