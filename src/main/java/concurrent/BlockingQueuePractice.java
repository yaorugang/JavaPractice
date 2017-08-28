package concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueuePractice
{

	public static void main(String[] args)
	{
		BlockingQueue<String> sharedQueue = new LinkedBlockingQueue<String>();
		
		Thread producer = new Thread(new Producer(sharedQueue));
		Thread consumer = new Thread(new Consumer(sharedQueue));
		
		producer.start();
		consumer.start();
	}

	
	static class Producer implements Runnable
	{
		private final BlockingQueue<String> sharedQueue;
		
		public Producer(BlockingQueue<String> sharedQueue)
		{
			this.sharedQueue = sharedQueue;
		}
		
		@Override
		public void run()
		{
			if (sharedQueue == null)
				return;
			
			for (int i = 0; i < 20; i ++)
			{
				try
				{
					sharedQueue.put(String.valueOf(i));
					System.err.println("produce item: " + i);
					
					Thread.sleep(40);
				}
				catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	static class Consumer implements Runnable
	{
		private final BlockingQueue<String> sharedQueue;
		
		public Consumer(BlockingQueue<String> sharedQueue)
		{
			this.sharedQueue = sharedQueue;
		}
		
		@Override
		public void run()
		{
			while (true)
			{
				try
				{
					String item = sharedQueue.take();
					System.out.println("consume item: " + item);
				} 
				catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}		
		}
	}
}
