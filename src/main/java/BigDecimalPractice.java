import java.math.BigDecimal;

/**
 * 
 * @author Rugang
 * �������չʾ�ڽ��о�ȷ�������ּ���ʱҪʹ��BigDecimal�࣬������float����double��
 * ��Ϊfloat��doubleʵ�ʲ�����ȷ�������ڲ�ͬ��JVM�����еõ��Ľ����һ��
 */
public class BigDecimalPractice
{
	public static void main(String[] args)
	{
		// float���͵ļ�����ʵ�ʲ�����ȷ
		float number1 = 2.15f;
		float number2 = 1.10f;
		
		System.out.println("2.15 - 1.10 = " + (number1 - number2));
		
		// ʹ��BigDecimal������ȷ�ķ�ʽ���õ��Ľ��׼ȷ
		BigDecimal decimal1 = new BigDecimal("2.15");
		BigDecimal decimal2 = new BigDecimal("1.10");
		
		System.out.println("2.15 - 1.10 = " + decimal1.subtract(decimal2));
		
		// ��ʹʹ��BigDecimalҲҪʹ�ô�String���Ͳ����Ĺ��캯����׼ȷ��
		// ���ʹ�ô�double����float���Ͳ������캯����ʵ�ʼ���ʱ���ǰ�
		// ��double����float���ͽ��м��㣬������ɲ�׼ȷ
		BigDecimal d1 = new BigDecimal(2.15);
		BigDecimal d2 = new BigDecimal(1.10);
		
		System.out.println("2.15 - 1.10 = " + d1.subtract(d2));
	}

}
