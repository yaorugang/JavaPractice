package enumtest;

public class EnumParctice
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		double earthWeight = 100;
		double mass = earthWeight / Planet.EARTH.surfaceGravity();
		
		for (Planet p: Planet.values())
			System.out.println(String.format("Weight on planet %s is %f", p, p.surfaceWeight(mass)));
		
		// test enum Operation
		double x = 34.5f;
		double y = 54.3f;
		String operation = String.format("%f %s %f = %f", x, Operation.PLUS, y, Operation.PLUS.apply(x, y));
		System.out.println(operation);
		
		System.out.println(Planet.EARTH.ordinal());
	}
}
