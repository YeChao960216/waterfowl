package cn.zhku.waterfowl.modules.fowlery.model;

import cn.zhku.waterfowl.util.excel.ReadExcelByEntityUtils;

/**
 * Created by jin on 2017/11/30.
 */
public class FowleryUtilExcel extends ReadExcelByEntityUtils<FowleryExcel> {
    public FowleryUtilExcel(String filepath) throws IllegalAccessException, InstantiationException {
        super(filepath);
    }
}
