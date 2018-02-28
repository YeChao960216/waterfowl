package cn.zhku.waterfowl.modules.user.model;


import cn.zhku.waterfowl.util.excel.ReadExcelByEntityUtils;

/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2017/11/18 11:38.
 * 说明：用于接受EXCEL信息的工具类,继承于ReadExcelByEntityUtils<T>
 */
public class UserUtilExcel extends ReadExcelByEntityUtils<UserExcel> {
    /**
     * 构造工具类
     *
     * @param filepath
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public UserUtilExcel(String filepath) throws InstantiationException, IllegalAccessException {
        super(filepath);
    }
}
