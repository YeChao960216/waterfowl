package cn.zhku.waterfowl.util.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.*;

/**
 * 将poi进行简单的封装，通过注解和反射，将excel中的集合和实体的set方法对应，形成执行集，再将执行集进行遍历，对bean进行封装，转化为
 * 主要支持任意实体，
 *  支持excel文件中字段的不规则排序
 * @author KD
 *
 * @param <T>
 */
public  class ImportExcelUtils<T> {

    private Logger logger = LoggerFactory.getLogger(ImportExcelUtils.class);

    private Workbook wb;//每一个Excel文件都将被解析成一个WorkBook对象

    private Sheet sheet;//Excel的每一页都将被解析成一个Sheet对象；

    private Row row;//Excel中的每一行都是一个Row对象，每一个单元格都是一个Cell对象。

    private Map<Integer,T> map; //最终结果集

    private Class<T> entity;  //泛型类

    private Field[] fields;   //泛型方法集

    private Map<String,String> mapByAno=new HashMap<String,String>();//初始化集：<注解,属性名>

    /**
     * 构造工具类
     * @param filepath
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @SuppressWarnings("unchecked")
    public ImportExcelUtils(String filepath) throws InstantiationException, IllegalAccessException{
        if(filepath==null){
            System.out.println("Excel文件名为空");
            return;
        }

        String lastName = filepath.substring(filepath.lastIndexOf("."));
        try {
            InputStream is = new FileInputStream(filepath);
            if(".xls".equals(lastName)){
                wb = new HSSFWorkbook(is);
            }else if(".xlsx".equals(lastName)){
                wb = new XSSFWorkbook(is);
            }else{
                wb=null;
            }
        } catch (FileNotFoundException e) {
            logger.error("文件找不到FileNotFoundException", e);
        } catch (IOException e) {
            logger.error("IOException", e);
        }
        entity = (Class<T>)((ParameterizedType)this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
        T t = entity.newInstance();
        if(this.entity != null){
            fields = entity.getDeclaredFields();//获取到属性字段

            for(Field f:fields){
                //设置强制访问
                f.setAccessible(true);
                EntiName e = f.getAnnotation(EntiName.class);
                if(!e.id()){
                    mapByAno.put(e.RName(),f.getName());
                }
            }

        }
    }


    public Map<Integer,T> getMap() throws Exception{
        setEntityMap();
        return map;
    }

    /**
     *
     * 将excel数据内容填充到map
     * @throws Exception
     */
    public void setEntityMap() throws Exception{
        this.map = new HashMap<Integer, T>();
        T t = null;
        String methodName = null;
        List<String> InvokeList = setInvokeList();
        sheet = wb.getSheetAt(0);
        //总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        //得到每一行单元格个数，包括其中的空单元格，这里要求表格内容的每一行都是固定的个数
        int colNum = row.getLastCellNum();  //每行单元格总数
        for (int i = 1; i <= rowNum; i++) {   //从第二行开始，遍历每一行
            row = sheet.getRow(i);
            int j = 0;
            t = entity.newInstance();  //每次新建一个T
            while (j < colNum) {
                Object obj = getCellFormatValue(row.getCell(j));  //
                methodName=InvokeList.get(j);
                Method method = t.getClass().getMethod(methodName, judgeMethodType(methodName));
                if(obj==null||obj.equals("")){
                    method.invoke(t, (Object)null);   //Object转化，很关键
                }else{
                    method.invoke(t, obj);
                }
                j++;
            }
            map.put(i-1, t);  //将封装好的实体放入map
        }
    }



    public Class judgeMethodType(String methodName) throws Exception{
        T t = entity.newInstance();
        Class[] paramTypes = null;
        Method[]  methods = t.getClass().getMethods();//全部方法
        try {
            for (int  i = 0;  i< methods.length; i++) {
                if(methodName.equals(methods[i].getName())){//和传入方法名匹配
                    Class[] params = methods[i].getParameterTypes();
                    paramTypes = new Class[ params.length] ;
                    for (int j = 0; j < params.length; j++) {
                        paramTypes[j] = Class.forName(params[j].getName());
                    }
                    break;
                }
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            logger.error("KDDUG:文件找不到FileNotFoundException", e);
        }
        return paramTypes[0];
    }



    /**
     * 将标题头和实体的属性set方法对应上,形成一个执行函数集list,之后调用这个函数时，每次遍历list，然后invoke即可
     * @throws Exception
     *
     */
    private List<String> setInvokeList() throws Exception{
        if(wb==null){
            throw new Exception("Workbook对象为空！");
        }
        List<String> invokeList = new ArrayList<String>();

        List<String> readExcelTitle = readExcelTitle();

        StringBuffer sb = new StringBuffer("set");
        //System.out.println("setInvokeList的判断"+readExcelTitle.size()+"?==?"+mapByAno.size());
        if(readExcelTitle.size()!=mapByAno.size()){
            System.out.println("KD:excel表头跟注解数量不对应");
            return null;
        }else{
            for (String obj : readExcelTitle) {
                if(mapByAno.get(obj)==null){
                    System.out.println("KD:excel表头跟注解名称不对应");
                    return null;
                }
                String fieldname = mapByAno.get(obj);
                mapByAno.remove(obj, fieldname);			//每拿一个put掉一个
                sb = new StringBuffer("set");
                String method = sb.append(fieldname.substring(0, 1).toUpperCase())
                        .append(fieldname.substring(1)).toString();
                invokeList.add(method);
            }
            if(!mapByAno.isEmpty()){
                System.out.println("KD:excel表头跟注解名称不对应");
                return null;
            }
            return invokeList;
		/* */
        }


    }


    /**
     * 得到标题头,标题头一定要是string类型，否则报错
     * @return
     * @throws Exception
     */
    @SuppressWarnings("deprecation")
    public List<String> readExcelTitle() throws Exception{
        if(wb == null){
            throw new Exception("KD:workbook对象为空");
        }
        sheet = wb.getSheetAt(0);
        row = sheet.getRow(0);
        //标题总列数
        int colNum = row.getPhysicalNumberOfCells();  //去掉对空列的计数

        //System.out.println("colNum:"+colNum);
        List<String> list = new ArrayList<String>();
        for(int i = 0;i<colNum;i++){
            if(row.getCell(i)==null||row.getCell(i).equals("")){
                list.add(null);
                continue;
            }else {
                list.add((String) getCellFormatValue(row.getCell(i)));
            }
        }
        return list;
    }

    @SuppressWarnings("deprecation")
    private Object getCellFormatValue(Cell cell) {
        Object cellvalue = null;
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_NUMERIC:// 如果当前Cell的Type为NUMERIC
                case Cell.CELL_TYPE_FORMULA: {
                    // 判断当前的cell是否为Date
                    if (DateUtil.isCellDateFormatted(cell)) {
                        cellvalue= cell.getDateCellValue();
                    } else {// 如果是纯数字

                        // 取得当前Cell的数值
                        cellvalue = cell.getNumericCellValue();
                    }
                    break;
                }
                case Cell.CELL_TYPE_STRING:// 如果当前Cell的Type为STRING
                    // 取得当前的Cell字符串
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                default:// 默认的Cell值
                    cellvalue = "";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;
    }


}
