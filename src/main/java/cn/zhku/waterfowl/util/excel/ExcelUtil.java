package cn.zhku.waterfowl.util.excel;

import cn.zhku.waterfowl.pojo.entity.User;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;


import java.util.ArrayList;
import java.util.List;

/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2017/11/16 20:12.
 * 说明：
 */
public final class ExcelUtil {


    /**
     * 接受文件输入流和文件名，判断版本并且调用相应的读取方式
     *
     * 注意：此处只是简单的将数据全部读入容器，不会检测数据是否符合规范
     *
     * @param workbook  工作簿
     * @param excelName excel文件名
     * @return user列表
     */
    public static List<User> readUserExcel(Workbook workbook, String excelName) {
        List<User> userList = null;
        if (excelName.endsWith(".xls")) {
            userList = (ArrayList<User>) readUserFromExcelXls(workbook);
        } else if (excelName.endsWith(".xlsx")){
            userList = (ArrayList<User>) readUserFromExcelXlsx(workbook);
        }
        return userList;
    }

    private static List<User> readUserFromExcelXls(Workbook workbook) {
        List<User> userList = new ArrayList<>();
        XSSFSheet xssfSheet = (XSSFSheet) workbook.getSheetAt(0);
        XSSFRow xssfRow = xssfSheet.getRow(0);
        if (xssfRow.getPhysicalNumberOfCells() == 10) {
            for (int i = 1; i  < xssfRow.getPhysicalNumberOfCells(); i++) {
                xssfRow = xssfSheet.getRow(i);
                User user = new User();


            }

        }

        return null;
    }



    private static Object readUserFromExcelXlsx(Workbook workbook) {
        List<User> userList = new ArrayList<>();
        XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(0);
        return null;
    }

}
