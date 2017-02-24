package ThreadMethod;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadExecutor {
	private ThreadPoolExecutor executor;
	
	public ThreadExecutor(){
		executor = (ThreadPoolExecutor)Executors.newCachedThreadPool();
	}
	
	public void executorThread(Runnable task) {
		executor.execute(task);
	}
	public void endThreadExecutor()
	{
		executor.shutdown();
	}
}
