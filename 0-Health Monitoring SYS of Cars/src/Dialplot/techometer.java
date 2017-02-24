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
		//�������ݼ�������ָ����ָ����
		dataset.setValue(rev);
		
		// ʵ����DialPlot
		DialPlot dialplot = new DialPlot();
		//����viewing������Ա��̵�XY����ʹ�С
		dialplot.setView(0.0D, 0.0D, 1.0D, 1.0D);
		//���ñ������ݼ�
		dialplot.setDataset(dataset);
		
		// ��ʼ������ʾ��ܽṹ
		StandardDialFrame simpledialframe = new StandardDialFrame();
		simpledialframe.setBackgroundPaint(Color.lightGray);//Color.lightGray //�Ǳ��̱߿��ڲ���ɫ
		simpledialframe.setForegroundPaint(Color.darkGray);//Color.darkGray //�Ǳ��̱߿��ⲿ��ɫ
		dialplot.setDialFrame(simpledialframe);
		
		// ������ʾ�ڱ�������λ�õ���Ϣ
		DialTextAnnotation dialtextannotation = new DialTextAnnotation("������ת�ٱ�");
		dialtextannotation.setFont(new Font("����", 1, 16));
		dialtextannotation.setRadius(0.69999999999999996D);
		dialplot.addLayer(dialtextannotation);
		
		//����
		
		// ���ÿ̶ȷ�Χ
		if(rev==0){
			StandardDialRange standarddialrange2 = new StandardDialRange(0D, 4000D,Color.green);
			standarddialrange2.setInnerRadius(0.52000000000000002D);
			standarddialrange2.setOuterRadius(0.55000000000000004D);
			dialplot.addLayer(standarddialrange2);	
		}else if(rev>0&&rev<=100){// ���ÿ̶ȷ�Χ���ٻ�ɫ��
			StandardDialRange standarddialrange1 = new StandardDialRange(0D, 4000D,Color.green);
			standarddialrange1.setInnerRadius(0.52000000000000002D);
			standarddialrange1.setOuterRadius(0.55000000000000004D);
			dialplot.addLayer(standarddialrange1);
		}else if(rev>100&&rev<=2200){// ���ÿ̶ȷ�Χ����ɫ��			
			StandardDialRange standarddialrange = new StandardDialRange(0D, 4000D,Color.green);
			standarddialrange.setInnerRadius(0.52000000000000002D);
			standarddialrange.setOuterRadius(0.55000000000000004D);
			dialplot.addLayer(standarddialrange);
		}else if(rev>2200){// ���ÿ̶ȷ�Χ����ɫ��			
			StandardDialRange standarddialrange = new StandardDialRange(0D, 4000D,Color.red);
			standarddialrange.setInnerRadius(0.52000000000000002D);
			standarddialrange.setOuterRadius(0.55000000000000004D);
			dialplot.addLayer(standarddialrange);
		}	
		
		//ָ��ָʾ�� ,�Ǳ����м��С����
		DialValueIndicator dialvalueindicator = new DialValueIndicator(0);
		dialvalueindicator.setFont(new Font("����", 1, 14));		
		dialvalueindicator.setOutlinePaint(new Color(229,229,229));
		dialvalueindicator.setBackgroundPaint(new Color(229,229,229));
		dialvalueindicator.setRadius(0.39999999999999998D);
		dialplot.addLayer(dialvalueindicator);

		//���ÿ���
		double startPosition=0D; //���� 0
        double endPosition=4000D; //���� 4000
        double skipValue=400D; //��� 40
        //�̶�������
        StandardDialScale standarddialscale = new StandardDialScale(startPosition, endPosition,-120D, -300D, skipValue, 10);
      	standarddialscale.setTickRadius(0.88D);//���ð뾶
      	standarddialscale.setTickLabelOffset(0.14999999999999999D);
      	standarddialscale.setTickLabelFont(new Font("Dialog", 0, 10));//�̶������ִ�С
     	dialplot.addScale(0, standarddialscale);
     	
     	//����ָ��
     	org.jfree.chart.plot.dial.DialPointer.Pointer pointer = new org.jfree.chart.plot.dial.DialPointer.Pointer();
     	dialplot.addPointer(pointer);
     	
     	// ʵ����DialCap
     	DialCap dialcap = new DialCap();
     	dialcap.setRadius(0.10000000000000001D);
     	dialplot.setCap(dialcap);
     	
     	// ����chart����
     	JFreeChart jfreechart = new JFreeChart(dialplot);
     	
     	String Path="img/techometer.jpeg";
     	FileOutputStream file = null;
     	//���������úõ�chart����jpegͼƬ
     	try {
			file = new FileOutputStream(Path);
			ChartUtilities.writeChartAsJPEG(file, 1.0f, jfreechart, 325, 325,null);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     	finally {
			try {
				file.close();// ���ر��ļ���
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
