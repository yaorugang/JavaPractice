
public class VariableArityMethod
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println(sum(1, 2, 3));
		System.out.println(sum());
	}

	public static int sum(int... args)
	{
		int sum = 0;
		
		for (int num: args)
			sum += num;
		
		return sum;
	}
}
