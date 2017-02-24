package DataSystem;

import java.util.ArrayList;

/**
 * 同步刷新界面线程和随机数发生线程的数据存储仓库
 * */
public class DataStorage {
	private int maxSize;
	private ArrayList<Data> storage;
	private Data displayData;
	
	public DataStorage(Data value){
		maxSize = 1;
		storage = new ArrayList<>();
		displayData = value;
	}
	
	
	public synchronized void set(Data value)
	{
		while (storage.size()==maxSize){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		storage.add(value);
		notify();
	}
	
	public synchronized Data get(){
		while (storage.size()==0){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Data value = storage.get(0);
		storage.remove(0);
		notify();
		return value;
	}
	
	public Data getDisplayData() {
		return displayData;
	}
	
	public void setDisplayData(Data a) {
		displayData.Assignment(a);
	}
}
