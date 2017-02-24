package FaultSystem;

import DataSystem.*;

public class Solution {
	private DataSystem.Data data = null;
	private static final int canSolve = 1;
	private static final int canNotSolve = 2; 
	public void setData(Data a)
	{
		data = a;
	}
	
	public Fault getTheFault() {
		Fault fault = new Fault();
		if(data == null)
		{
			fault.setFaultID(0);
			return fault;
		}
		
		if(data.valueOfWaterTemp > 40)
		{
			fault.setFaultID(1);
			fault.setFaultName("水温过高！");
			fault.setFaultType(canNotSolve);
			return fault;
		}
		
		if(data.valueOfOilTemp >40)
		{
			fault.setFaultID(1000);
			fault.setFaultName("油温过高！");
			fault.setFaultType(canSolve);
			return fault;
		}
		
		fault.setFaultID(0);
		return fault;
	}
	
}
