

import java.util.List;
import java.util.ArrayList;



public class ClonePractice
{

	public static void main(String[] args)
	{
		Programmer yao = new Programmer("yaorugang", 32);
		yao.addCertificate("CCIE");
		yao.addCertificate("PMP");
		
		Programmer ren = yao.clone();
		ren.setName("renyuanyuan");
		ren.setAge(18);
		ren.addCertificate("CCNP");
		
		System.out.println(yao);
		System.out.println(ren);
	}

	static class Programmer implements Cloneable
	{
		private String name;
		private int age;
		private List<String> certificate;
		
		public Programmer(String name, int age)
		{
			this.name = name;
			this.age = age;
			certificate = new ArrayList<String>();
		}
		
		public void setName(String name)
		{
			this.name = name;
		}
		
		public void setAge(int age)
		{
			this.age = age;
		}
		
		public void addCertificate(String c)
		{
			certificate.add(c);
		}
		
		
		/**
		 * this is a co-variant method overriding, because it returns a Programmer instance instead of an Object 
		 */
		@Override
		protected Programmer clone()
		{
			Programmer programmer = null;
			
			try
			{
				programmer = (Programmer)super.clone();
			} 
			catch (CloneNotSupportedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (programmer != null)
				// 这依旧是个shallow copy，因为String is immutable，所以还不会出错。
				// 如果ArrayList的类型不是String，需要考虑采用deep copy
				programmer.certificate = new ArrayList<>(certificate); 
			
			return programmer;
		}
		
		@Override
		public String toString()
		{
			String str = String.format("Name: %s, Age: %d, Certificates: %s", name, age, certificate.toString());
			return str;
		}
	}
}
