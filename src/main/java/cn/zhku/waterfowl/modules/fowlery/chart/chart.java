package cn.zhku.waterfowl.modules.fowlery.fowlerychart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by jin on 2017/12/3.
 */
public class chart {
    ChartPanel framel;
    public chart(){
        DefaultPieDataset data=getDataSet();
        JFreeChart chart= ChartFactory.createPieChart3D("禽舍使用率",data,true,false,false);

        //设置百分比
        PiePlot pieplot= (PiePlot) chart.getPlot();
        DecimalFormat df=new DecimalFormat("0.00%");  //获得DecimalFormat对象，主要是用来设置小数问题
        NumberFormat nf= NumberFormat.getNumberInstance();     //获得一个numberformat对象
        //获取StandardPieSectionLabelGenerator对象
        StandardPieSectionLabelGenerator spl=new StandardPieSectionLabelGenerator("" + "{0} {2}",nf,df);
        pieplot.setLabelGenerator(spl);   //设置饼图显示百分比

        //无数据的时候显示
        pieplot.setNoDataMessage("无数据显示");
        pieplot.setCircular(false);
        pieplot.setLabelGap(0.02D);

        pieplot.setIgnoreNullValues(true);   //设置不显示空值
        pieplot.setIgnoreZeroValues(false);  //设置不显示负值
        framel=new ChartPanel(chart,true);
        //Font font=new Font("字体","风格粗体","字号");
        chart.getTitle().setFont(new Font("宋体", Font.BOLD,20));    //设置标题字体
        PiePlot piePlot= (PiePlot) chart.getPlot();     //获取图表区域对象
        piePlot.setLabelFont(new java.awt.Font("宋体", Font.BOLD,10));    //解决乱码
        chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,10));
    }

    public DefaultPieDataset getDataSet() {
        DefaultPieDataset dataset=new DefaultPieDataset();
        dataset.setValue("苹果",100);
        dataset.setValue("梨子",200);
        dataset.setValue("葡萄",300);
        dataset.setValue("香蕉",400);
        dataset.setValue("荔枝",500);
        return dataset;
    }

    public ChartPanel getChartPanel(){
        return framel;
    }
}
