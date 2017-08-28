package buiderpattern;

public class BuilderPattern
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		NutritionFacts nutritionFacts = new NutritionFacts.Builder(100, 90)
				.calories(55)
				.fat(24)
				.sodium(66)
				.carbohydrate(89)
				.build();
		
		System.out.println(nutritionFacts);
	}

}
