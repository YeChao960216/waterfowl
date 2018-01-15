package cn.zhku.waterfowl.modules.outStorage.model;

import cn.zhku.waterfowl.util.excel.ReadExcelByEntityUtils;

/**
 * Created by Administrator on 2018/1/15 0015.
 */
public class OutStorageUtilExcel extends ReadExcelByEntityUtils<OutStorageExcel> {
    public OutStorageUtilExcel(String filepath) throws InstantiationException, IllegalAccessException {
        super(filepath);
    }
}
