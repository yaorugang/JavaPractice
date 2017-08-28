package concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockPractice
{

	public static void main(String[] args)
	{
		final MyCounter counter = new MyCounter(new ReentrantLock());
		
		Runnable runnable = new Runnable() {
			
			@Override
			public void run()
			{
				for (int i = 0; i < 20; i++)
				{
					System.out.println(String.format("Thread %s get count: %d", Thread.currentThread().getName(), counter.getCount()));
				}
			}
		};

		Thread thread1 = new Thread(runnable);
		Thread thread2 = new Thread(runnable);
		Thread thread3 = new Thread(runnable);
		
		thread1.start();
		thread2.start();
		thread3.start();
	}
	
	static class MyCounter
	{
		private final Lock lock;
		private int count = 0;
		
		public MyCounter(Lock lock)
		{
			this.lock = lock;
		}
		
		public int getCount()
		{
			lock.lock();
			try
			{
				count++;	
			} 
			catch (Exception e)
			{
				// TODO: handle exception
			}
			finally
			{
				lock.unlock();
			}
			
			return count;
		}
	}

}
