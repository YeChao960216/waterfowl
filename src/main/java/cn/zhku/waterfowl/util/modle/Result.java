package cn.zhku.waterfowl.util.modle;

import org.apache.poi.ss.formula.functions.T;

import java.util.ArrayList;

/**
 * Created by yechao on 2018/1/24 0024.
 */
public class Result {
    private ArrayList<T> result;
    /*返回ArrayList结果集*/
    private Object object;
    /*返回Object对象*/
    private String status;
    /*返回一些说明信息*/

    public Result() {
    }

    public Result(ArrayList result) {
        this.result = result;
    }

    public Result(ArrayList result, Object object) {
        this.result = result;
        this.object = object;
    }

    public Result(ArrayList result, String status) {
        this.result = result;
        this.status = status;
    }

    public Result(Object object, String status) {
        this.object = object;
        this.status = status;
    }

    public Result(ArrayList result, Object object, String status) {
        this.result = result;
        this.object = object;
        this.status = status;
    }

    public ArrayList getResult() {
        return result;
    }

    public void setResult(ArrayList result) {
        this.result = result;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Result{" +
                "result=" + result +
                ", object=" + object +
                ", status='" + status + '\'' +
                '}';
    }
}
