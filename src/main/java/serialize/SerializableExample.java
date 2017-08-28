package serialize;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableExample
{
	public void testSerialize()
	{
		// serialize object
		try (FileOutputStream fileOutputStream = new FileOutputStream("person.txt"); // try-with-resource
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);)
		{		
			Person person = new Person("yaorugang", 100);
			objectOutputStream.writeObject(person);
				
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void testDeserialize()
	{
		// de-serialize object
		try
		{
			FileInputStream fileInputStream = new FileInputStream("person.txt");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Person person = (Person) objectInputStream.readObject();
			objectInputStream.close();
			
			System.out.println(person.toString());
			
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	public static class Person implements Serializable
	{
		private static final long serialVersionUID = 1001L;
		
		private String name;
		private int monthlyWage;
		private transient int yearlyWage; // this instance variable will not be serialized
		
		public Person(String name, int monthlyWage)
		{
			this.name = name;
			this.monthlyWage = monthlyWage;
			this.yearlyWage = monthlyWage * 12;
		}
		
		@Override
		public String toString()
		{
			return String.format("%s\'s monthly wage is %d, yearly wage is: %d", name, monthlyWage, yearlyWage);
		}
		
		@Override
		public int hashCode()
		{
			int hash = 97;
			hash = 7 * hash + name.hashCode();
			hash = 7 * hash + monthlyWage;
			
			return hash;
		}
	}
}
