package FaultSystem;

public class OilTempFaultTree {
	private String step_1;
	private String step_2;
	private int maxStep;
	
	public OilTempFaultTree(){
		maxStep = 2;
		step_1 = new String("检查油温探测器是否正常！");
		step_2 = new String("检查发动机转速是否正常！");
	}

	public String getStep_1() {
		return step_1;
	}
	public String dealStep_1() {
		String s = new String("油温探测器故障，请更换！");
		return s;
	}
	

	public String getStep_2() {
		return step_2;
	}
	public String dealStep_2() {
		String s = new String("发动机转速过高，请停机！");
		return s;
	}
	

	public int getMaxStep() {
		return maxStep;
	}
	
}
