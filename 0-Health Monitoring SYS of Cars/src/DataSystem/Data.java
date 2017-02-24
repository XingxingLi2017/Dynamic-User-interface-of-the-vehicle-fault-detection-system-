package DataSystem;

public class Data {
	public double valueOfTechometer = 0;
	public double valueOfOdometer = 0;
	public double valueOfOilTemp = 0;
	public double valueOfWaterTemp = 0;
	
	public void Assignment(Data a) {
		valueOfOdometer = a.valueOfOdometer;
		valueOfTechometer = a.valueOfTechometer;
		valueOfOilTemp = a.valueOfOilTemp;
		valueOfWaterTemp = a.valueOfWaterTemp;
	}
}
