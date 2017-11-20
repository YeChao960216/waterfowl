package cn.zhku.waterfowl.util.excel;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : 钱伟健 gonefuture@qq.com
 * @version : 2017/11/18 16:32.
 * 说明：
 */
public class ExportExcelUtil<T> {

    private Logger logger = LoggerFactory.getLogger(ExportExcelUtil.class);


    //  通过实体类生成workbook对象

    public HSSFWorkbook expExcel(String title, Collection<T> dataSet) {

        //  声明一个工作簿和表格，并设置标题
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(title);

        //  产生表格标题行
        HSSFRow row = sheet.createRow(0);

        int index = 0;
        for (T entity: dataSet){
            index++;
            row = sheet.createRow(index);

            //  利用反射，根据javaBean属性的先后顺序，动态调用getXxx()方法得到属性值
            Field[] fields = entity.getClass().getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                //  创建cell单元格，此处可以设置单元格的样式
                HSSFCell cell = row.createCell(i);
                Field field = fields[i];
                String fieldName = field.getName();
                //  拼接出getXxx（）的名字
                String getMethodName = "get"
                        +fieldName.substring(0,1).toUpperCase()
                        +fieldName.substring(1);
                try {
                    Class clazz = entity.getClass();
                    Method getMethod = clazz.getMethod(getMethodName,new Class[] {});
                    System.out.println("======================="+getMethod);
                    Object value = getMethod.invoke(entity,new Object[] {});

                    //  判断值的类型后进行强制类型转换
                    String textValue = null;

                    // if (value instanceof Integer) {
                    // int intValue = (Integer) value;
                    // cell.setCellValue(intValue);
                    // } else if (value instanceof Float) {
                    // float fValue = (Float) value;
                    // textValue = new HSSFRichTextString(
                    // String.valueOf(fValue));
                    // cell.setCellValue(textValue);
                    // } else if (value instanceof Double) {
                    // double dValue = (Double) value;
                    // textValue = new HSSFRichTextString(
                    // String.valueOf(dValue));
                    // cell.setCellValue(textValue);
                    // } else if (value instanceof Long) {
                    // long longValue = (Long) value;
                    // cell.setCellValue(longValue);
                    // }

                    if (value instanceof Date) {
                        Date date = (Date) value;
                        SimpleDateFormat sdf = new SimpleDateFormat();
                        textValue = sdf.format(date);
                    } else {
                        //  其他数据类型当作字符串简单处理
                        textValue = value.toString();
                    }
                    //  利用正则表达式判断textValue是否全部由数字组成
                    if (textValue != null) {
                        Pattern pattern = Pattern.compile("^//d+(//.//d+)?$");
                        Matcher matcher = pattern.matcher(textValue);
                        if (matcher.matches()) {
                            //  是数字当作double处理
                            cell.setCellValue(Double.valueOf(textValue));
                        } else {
                            //
                            HSSFRichTextString richTextString = new HSSFRichTextString(textValue);
                            HSSFFont font = workbook.createFont();
                            font.setColor(HSSFColor.BLUE.index);
                            richTextString.applyFont(font);
                            cell.setCellValue(richTextString);
                        }
                    }

                } catch (NoSuchMethodException e) {

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }

            }
        }


        return null;

    }







}
