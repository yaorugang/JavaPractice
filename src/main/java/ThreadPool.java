

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * 练习Java的线程池的使用
 * @author Rugang
 *
 */
public class ThreadPool
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		ThreadPoolExecutor threadPool = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
		
		for (int i = 0; i < 15; i++)
		{
			MyTask task = new MyTask(i);
			threadPool.execute(task);
			
			System.out.println("线程池中线程数目：" + threadPool.getPoolSize() + ", 队列中等待的任务数： " + threadPool.getQueue().size() + ", 已执行完毕的任务数： " + threadPool.getCompletedTaskCount());
		}
		
		threadPool.shutdown();
	}

}

class MyTask implements Runnable
{
	private int mTaskNumber;
	
	public MyTask(int number)
	{
		mTaskNumber = number;
	}
	
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		System.out.println("正在执行线程： " + mTaskNumber);
		
		try
		{
			Thread.sleep(4000);
		}
		catch (InterruptedException e) 
		{
			// TODO: handle exception
			System.out.println("Thread " + mTaskNumber + " is terminated!");
		}
		
		System.out.println("线程 " + mTaskNumber + " 执行完毕!");
	}
}