

/**
 * 本例子用来验证JVM对类进行加载和初始化的顺序，下面两个类First和Second的唯一区别在于Instance的初始化位置。
 * @author Rugang
 *
 */
public class JVMClassLoading
{

	public static void main(String[] args)
	{
		First first = First.getSingleton();
		System.out.println("counter1= " + First.counter1);
		System.out.println("counter2= " + First.counter2);
		
		
		Second second = Second.getSingleton();
		System.out.println("counter1= " + Second.counter1);
		System.out.println("counter2= " + Second.counter2);

	}

	public static class First
	{
		/**
		 * JVM在对这个类进行连接准备阶段时，先给三个变量赋予默认值：
		 * instance = null
		 * counter1 = 0
		 * counter2 = 0
		 * 连接准备工作完毕后，开始进行初始化工作，这时首先调用new First()来初始化instance，这就会调用默认的构造函数，
		 * 在构造函数内执行++操作，导致：
		 * counter1 = 1
		 * counter2 = 1
		 * 然后接下来再初始化counter1, 但是counter1并没有给显示赋值，所以counter1就保留了当前值1，
		 * 接下来初始化counter2，counter2有显示赋值为0，所以counter2的值就被改变为0。
		 * 
		 * 初始化过程结束，但是因为初始化顺序的问题导致变量值不一致，Second类修正了这个问题
		 */
		private static First instance = new First();
		public static int counter1;
		public static int counter2 = 0;
		
		private First()
		{
			counter1++;
			counter2++;
		}
		
		public static First getSingleton()
		{
			return instance;
		}
	}
	
	public static class Second
	{
		/**
		 * 与First类一样，JVM在连接准备阶段先给静态变量赋予默认值：
		 * counter1 = 0
		 * counter2 = 0
		 * instance = null
		 * 然后接下来再进行初始化工作：
		 * counter1没有显示赋值，所以就保持当前默认值0，
		 * counter2有显示赋值为0，虽然当前counter2的值已经为0，但是这个初始化操作还是要执行一次的，
		 * 接下来执行 new Second()来初始化instance，这就调用了默认构造函数，在构造函数中执行++操作，得到
		 * counter1 = 1
		 * counter2 = 1
		 * 整个初始化过程结束，当前三个变量的状态一致。
		 * 
		 * 这就是两个First类和Second类的区别。
		 */
		public static int counter1;
		public static int counter2 = 0;
		private static Second instance = new Second();
		
		private Second()
		{
			counter1++;
			counter2++;
		}
		
		public static Second getSingleton()
		{
			return instance;
		}
	}
}
