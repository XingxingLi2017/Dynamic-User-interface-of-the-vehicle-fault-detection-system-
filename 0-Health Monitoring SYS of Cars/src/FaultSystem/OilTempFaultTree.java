package FaultSystem;

public class OilTempFaultTree {
	private String step_1;
	private String step_2;
	private int maxStep;
	
	public OilTempFaultTree(){
		maxStep = 2;
		step_1 = new String("�������̽�����Ƿ�������");
		step_2 = new String("��鷢����ת���Ƿ�������");
	}

	public String getStep_1() {
		return step_1;
	}
	public String dealStep_1() {
		String s = new String("����̽�������ϣ��������");
		return s;
	}
	

	public String getStep_2() {
		return step_2;
	}
	public String dealStep_2() {
		String s = new String("������ת�ٹ��ߣ���ͣ����");
		return s;
	}
	

	public int getMaxStep() {
		return maxStep;
	}
	
}
