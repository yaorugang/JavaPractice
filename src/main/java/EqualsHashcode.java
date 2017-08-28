
public class EqualsHashcode
{
	private String mName = null;
	private int mAge = 0;
	

	public static void main(String[] args)
	{
		// test case
		EqualsHashcode obj1 = new EqualsHashcode("yaorugang", 32);
		EqualsHashcode obj2 = new EqualsHashcode("zhangyunyao", 32);
		EqualsHashcode obj3 = new EqualsHashcode("zhangyunyao", 25);
		EqualsHashcode obj4 = new EqualsHashcode("yaorugang", 32);
		
		System.out.println(String.format("obj1 == obj2 is %b, obj1 hashcode: %d, obj2 hashcode: %d",
				obj1.equals(obj2), obj1.hashCode(), obj2.hashCode()));
		
		System.out.println(String.format("obj2 == obj2 is %b, obj2 hashcode: %d, obj2 hashcode: %d",
				obj2.equals(obj2), obj2.hashCode(), obj2.hashCode()));
		
		System.out.println(String.format("obj2 == obj3 is %b, obj2 hashcode: %d, obj3 hashcode: %d",
				obj2.equals(obj3), obj2.hashCode(), obj3.hashCode()));
		
		System.out.println(String.format("obj1 == obj4 is %b, obj1 hashcode: %d, obj4 hashcode: %d",
				obj1.equals(obj4), obj1.hashCode(), obj4.hashCode()));
	}
	
	public EqualsHashcode(String name, int age)
	{
		mName = name;
		mAge = age;
	}
	
	public String getName()
	{
		return mName;
	}
	
	public int getAge()
	{
		return mAge;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		// TODO Auto-generated method stub
		if (this == obj)
			return true;
		
		if (obj == null || getClass() != obj.getClass())
			return false;
		
		EqualsHashcode o = (EqualsHashcode) obj;
		boolean isEqual = (this.mName == o.getName() && this.mAge == o.getAge());
		
		return isEqual;
	}
	
	@Override
	public int hashCode()
	{
		// TODO Auto-generated method stub
		final int prime = 7;
		int hash = 3 * prime + (mName != null ? mName.hashCode() : 0);
		hash = hash * prime + mAge;
		
		return hash;
	}
}
