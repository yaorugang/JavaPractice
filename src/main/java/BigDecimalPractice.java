import java.math.BigDecimal;

/**
 * 
 * @author Rugang
 * 这个例子展示在进行精确金融数字计算时要使用BigDecimal类，而不是float或者double，
 * 因为float和double实际并不精确，而且在不同的JVM上运行得到的结果不一样
 */
public class BigDecimalPractice
{
	public static void main(String[] args)
	{
		// float类型的计算结果实际并不精确
		float number1 = 2.15f;
		float number2 = 1.10f;
		
		System.out.println("2.15 - 1.10 = " + (number1 - number2));
		
		// 使用BigDecimal才是正确的方式，得到的结果准确
		BigDecimal decimal1 = new BigDecimal("2.15");
		BigDecimal decimal2 = new BigDecimal("1.10");
		
		System.out.println("2.15 - 1.10 = " + decimal1.subtract(decimal2));
		
		// 即使使用BigDecimal也要使用带String类型参数的构造函数才准确，
		// 如果使用带double或者float类型参数构造函数，实际计算时还是按
		// 照double或者float类型进行计算，结果依旧不准确
		BigDecimal d1 = new BigDecimal(2.15);
		BigDecimal d2 = new BigDecimal(1.10);
		
		System.out.println("2.15 - 1.10 = " + d1.subtract(d2));
	}

}
