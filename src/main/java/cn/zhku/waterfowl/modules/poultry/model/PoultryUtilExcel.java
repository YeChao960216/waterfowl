package cn.zhku.waterfowl.modules.poultry.model;

import cn.zhku.waterfowl.util.excel.ReadExcelByEntityUtils;

/**
 * @author:叶超 yc755909707@foxmail.com
 * @version:create in 17:49 2017/12/2
 * @description:
 */
public class PoultryUtilExcel extends ReadExcelByEntityUtils<PoultryExcel> {
    public PoultryUtilExcel(String filepath) throws InstantiationException, IllegalAccessException {
        super(filepath);
    }
}
