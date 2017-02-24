package FaultSystem;

public class Fault {
	private int FaultID = 0;
	private String FaultName = "";
	private int FaultType = 0;
	
	
	public int getFaultID() {
		return FaultID;
	}
	public void setFaultID(int faultID) {
		FaultID = faultID;
	}
	public String getFaultName() {
		return FaultName;
	}
	public void setFaultName(String faultName) {
		FaultName = faultName;
	}
	public int getFaultType() {
		return FaultType;
	}
	public void setFaultType(int faultType) {
		FaultType = faultType;
	}
}
