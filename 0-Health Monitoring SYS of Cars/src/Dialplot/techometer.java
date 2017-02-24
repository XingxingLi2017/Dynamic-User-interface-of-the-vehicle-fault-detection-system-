package Dialplot;

import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.dial.DialCap;
import org.jfree.chart.plot.dial.DialPlot;
import org.jfree.chart.plot.dial.DialTextAnnotation;
import org.jfree.chart.plot.dial.DialValueIndicator;
import org.jfree.chart.plot.dial.StandardDialFrame;
import org.jfree.chart.plot.dial.StandardDialRange;
import org.jfree.chart.plot.dial.StandardDialScale;
import org.jfree.data.general.DefaultValueDataset;

public class techometer {
	public void getDial(double rev) throws IOException
	{
		DefaultValueDataset dataset = new DefaultValueDataset();
		//设置数据集，表盘指针所指数字
		dataset.setValue(rev);
		
		// 实例化DialPlot
		DialPlot dialplot = new DialPlot();
		//设置viewing矩形相对表盘的XY坐标和大小
		dialplot.setView(0.0D, 0.0D, 1.0D, 1.0D);
		//设置表盘数据集
		dialplot.setDataset(dataset);
		
		// 开始设置显示框架结构
		StandardDialFrame simpledialframe = new StandardDialFrame();
		simpledialframe.setBackgroundPaint(Color.lightGray);//Color.lightGray //仪表盘边框内部颜色
		simpledialframe.setForegroundPaint(Color.darkGray);//Color.darkGray //仪表盘边框外部颜色
		dialplot.setDialFrame(simpledialframe);
		
		// 设置显示在表盘中央位置的信息
		DialTextAnnotation dialtextannotation = new DialTextAnnotation("发动机转速表");
		dialtextannotation.setFont(new Font("宋体", 1, 16));
		dialtextannotation.setRadius(0.69999999999999996D);
		dialplot.addLayer(dialtextannotation);
		
		//设置
		
		// 设置刻度范围
		if(rev==0){
			StandardDialRange standarddialrange2 = new StandardDialRange(0D, 4000D,Color.green);
			standarddialrange2.setInnerRadius(0.52000000000000002D);
			standarddialrange2.setOuterRadius(0.55000000000000004D);
			dialplot.addLayer(standarddialrange2);	
		}else if(rev>0&&rev<=100){// 设置刻度范围（橘黄色）
			StandardDialRange standarddialrange1 = new StandardDialRange(0D, 4000D,Color.green);
			standarddialrange1.setInnerRadius(0.52000000000000002D);
			standarddialrange1.setOuterRadius(0.55000000000000004D);
			dialplot.addLayer(standarddialrange1);
		}else if(rev>100&&rev<=2200){// 设置刻度范围（红色）			
			StandardDialRange standarddialrange = new StandardDialRange(0D, 4000D,Color.green);
			standarddialrange.setInnerRadius(0.52000000000000002D);
			standarddialrange.setOuterRadius(0.55000000000000004D);
			dialplot.addLayer(standarddialrange);
		}else if(rev>2200){// 设置刻度范围（红色）			
			StandardDialRange standarddialrange = new StandardDialRange(0D, 4000D,Color.red);
			standarddialrange.setInnerRadius(0.52000000000000002D);
			standarddialrange.setOuterRadius(0.55000000000000004D);
			dialplot.addLayer(standarddialrange);
		}	
		
		//指针指示框 ,仪表盘中间的小方框
		DialValueIndicator dialvalueindicator = new DialValueIndicator(0);
		dialvalueindicator.setFont(new Font("宋体", 1, 14));		
		dialvalueindicator.setOutlinePaint(new Color(229,229,229));
		dialvalueindicator.setBackgroundPaint(new Color(229,229,229));
		dialvalueindicator.setRadius(0.39999999999999998D);
		dialplot.addLayer(dialvalueindicator);

		//设置开度
		double startPosition=0D; //开度 0
        double endPosition=4000D; //开度 4000
        double skipValue=400D; //间隔 40
        //刻度盘设置
        StandardDialScale standarddialscale = new StandardDialScale(startPosition, endPosition,-120D, -300D, skipValue, 10);
      	standarddialscale.setTickRadius(0.88D);//设置半径
      	standarddialscale.setTickLabelOffset(0.14999999999999999D);
      	standarddialscale.setTickLabelFont(new Font("Dialog", 0, 10));//刻度盘数字大小
     	dialplot.addScale(0, standarddialscale);
     	
     	//设置指针
     	org.jfree.chart.plot.dial.DialPointer.Pointer pointer = new org.jfree.chart.plot.dial.DialPointer.Pointer();
     	dialplot.addPointer(pointer);
     	
     	// 实例化DialCap
     	DialCap dialcap = new DialCap();
     	dialcap.setRadius(0.10000000000000001D);
     	dialplot.setCap(dialcap);
     	
     	// 生成chart对象
     	JFreeChart jfreechart = new JFreeChart(dialplot);
     	
     	String Path="img/techometer.jpeg";
     	FileOutputStream file = null;
     	//将参数设置好的chart生成jpeg图片
     	try {
			file = new FileOutputStream(Path);
			ChartUtilities.writeChartAsJPEG(file, 1.0f, jfreechart, 325, 325,null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     	finally {
			try {
				file.close();// 最后关闭文件流
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
//	public static void main(String[] args) {
//		try {
//			new techometer().getDial(2000D);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
