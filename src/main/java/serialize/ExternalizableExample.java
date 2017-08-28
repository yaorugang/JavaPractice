package serialize;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;


public class ExternalizableExample
{
	public void testSerialize()
	{
		// serialize object
		try
		{
			FileOutputStream fileOutputStream = new FileOutputStream("employee.txt");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
					
			Employee person = new Employee("yaorugang", 100);
			objectOutputStream.writeObject(person);
			
			objectOutputStream.close();			
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
			FileInputStream fileInputStream = new FileInputStream("employee.txt");
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Employee person = (Employee) objectInputStream.readObject();
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

	public static class Employee implements Externalizable
	{
		private static final long serialVersionUID = 2001L;
		
		private String name;
		private int monthlyWage;
		private transient int yearlyWage; // this instance variable will not be serialized
		
		public Employee()
		{
			
		}
		
		public Employee(String name, int monthlyWage)
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

		@Override
		public void writeExternal(ObjectOutput out) throws IOException
		{
			out.writeObject(this.name);
			out.writeInt(this.monthlyWage);
		}
		
		@Override
		public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
		{
			this.name = (String)in.readObject();
			this.monthlyWage = in.readInt();
			this.yearlyWage = this.monthlyWage * 12;
		}
	}
}
