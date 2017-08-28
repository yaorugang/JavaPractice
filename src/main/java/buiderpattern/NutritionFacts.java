package buiderpattern;

public class NutritionFacts
{
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbohydrate;
	
	private NutritionFacts(Builder builder)
	{
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbohydrate = builder.carbohydrate;
	}
	
	public String toString()
	{
		return String.format("servingSize: %d\nservings: %d\ncalories: %d\nfat: %d\nsodium: %d\ncarbohydrate: %d",
				servingSize, servings, calories, fat, sodium, carbohydrate);
	}
	
	public static class Builder
	{
		// required parameters
		private final int servingSize;
		private final int servings;
		
		// optional parameters
		private int calories = 0;
		private int fat = 0;
		private int sodium = 0;
		private int carbohydrate = 0;
		
		public Builder(int servingSize, int servings)
		{
			this.servingSize = servingSize;
			this.servings = servings;
		}
		
		public Builder calories(int val)
		{
			calories = val;
			return this;
		}
		
		public Builder fat(int val)
		{
			fat = val;
			return this;
		}
		
		public Builder sodium(int val)
		{
			sodium = val;
			return this;
		}
		
		public Builder carbohydrate(int val)
		{
			carbohydrate = val;
			return this;
		}
		
		public NutritionFacts build()
		{
			return new NutritionFacts(this);
		}
		
	}

}
