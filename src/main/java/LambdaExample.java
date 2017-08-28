
public class LambdaExample
{

	public static void main(String[] args)
	{
		LambdaExample lambdaExample = new LambdaExample();
		lambdaExample.testCase();
	}
	
	public void testCase()
	{
		MathOperation addition = (a, b) -> a + b;
		MathOperation substitution = (a, b) -> a - b;
		MathOperation multiply = (a, b) -> a * b;
		MathOperation devide = (a, b) -> a / b;
		
		System.out.println("2 + 3 = " + calculate(2, 3, addition));
		System.out.println("2 - 3 = " + calculate(2, 3, substitution));
		System.out.println("2 * 3 = " + calculate(2, 3, multiply));
		System.out.println("2 / 3 = " + calculate(2, 3, devide));
	}
	
	interface MathOperation
	{
		int operate(int a, int b);
	}
	
	public int calculate(int a, int b, MathOperation operation)
	{
		return operation.operate(a, b);
	}
}
