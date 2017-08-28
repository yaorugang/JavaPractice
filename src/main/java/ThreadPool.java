

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * ��ϰJava���̳߳ص�ʹ��
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
			
			System.out.println("�̳߳����߳���Ŀ��" + threadPool.getPoolSize() + ", �����еȴ����������� " + threadPool.getQueue().size() + ", ��ִ����ϵ��������� " + threadPool.getCompletedTaskCount());
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
		System.out.println("����ִ���̣߳� " + mTaskNumber);
		
		try
		{
			Thread.sleep(4000);
		}
		catch (InterruptedException e) 
		{
			// TODO: handle exception
			System.out.println("Thread " + mTaskNumber + " is terminated!");
		}
		
		System.out.println("�߳� " + mTaskNumber + " ִ�����!");
	}
}