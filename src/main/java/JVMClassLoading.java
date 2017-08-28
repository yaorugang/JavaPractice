

/**
 * ������������֤JVM������м��غͳ�ʼ����˳������������First��Second��Ψһ��������Instance�ĳ�ʼ��λ�á�
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
		 * JVM�ڶ�������������׼���׶�ʱ���ȸ�������������Ĭ��ֵ��
		 * instance = null
		 * counter1 = 0
		 * counter2 = 0
		 * ����׼��������Ϻ󣬿�ʼ���г�ʼ����������ʱ���ȵ���new First()����ʼ��instance����ͻ����Ĭ�ϵĹ��캯����
		 * �ڹ��캯����ִ��++���������£�
		 * counter1 = 1
		 * counter2 = 1
		 * Ȼ��������ٳ�ʼ��counter1, ����counter1��û�и���ʾ��ֵ������counter1�ͱ����˵�ǰֵ1��
		 * ��������ʼ��counter2��counter2����ʾ��ֵΪ0������counter2��ֵ�ͱ��ı�Ϊ0��
		 * 
		 * ��ʼ�����̽�����������Ϊ��ʼ��˳������⵼�±���ֵ��һ�£�Second���������������
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
		 * ��First��һ����JVM������׼���׶��ȸ���̬��������Ĭ��ֵ��
		 * counter1 = 0
		 * counter2 = 0
		 * instance = null
		 * Ȼ��������ٽ��г�ʼ��������
		 * counter1û����ʾ��ֵ�����Ծͱ��ֵ�ǰĬ��ֵ0��
		 * counter2����ʾ��ֵΪ0����Ȼ��ǰcounter2��ֵ�Ѿ�Ϊ0�����������ʼ����������Ҫִ��һ�εģ�
		 * ������ִ�� new Second()����ʼ��instance����͵�����Ĭ�Ϲ��캯�����ڹ��캯����ִ��++�������õ�
		 * counter1 = 1
		 * counter2 = 1
		 * ������ʼ�����̽�������ǰ����������״̬һ�¡�
		 * 
		 * ���������First���Second�������
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
