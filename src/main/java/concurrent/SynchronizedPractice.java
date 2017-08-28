package concurrent;

public class SynchronizedPractice
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Counter counter = new Counter();
		CounterThread threadA = new CounterThread(counter);
		CounterThread threadB = new CounterThread(counter);
		
		threadA.start();
		threadB.start();
	}

}

class Counter
{
	private long mCount = 0;
	
	public synchronized void increase()
	{
		mCount += 1;
		System.out.println("Counter is: " + mCount);
	}
}

class CounterThread extends Thread
{
	private Counter mCounter = null;
	
	public CounterThread(Counter counter)
	{
		mCounter = counter;
	}
	
	@Override
	public void run()
	{
		for (int i = 0; i < 10; i++)
		{
			mCounter.increase();
		}
	}
}