
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


public class ComparableComparator
{

	public static void main(String[] args)
	{
		Employee employee1 = new Employee("yaorugang", 32);
		Employee employee2 = new Employee("renyuanyuan", 30);
		Employee employee3 = new Employee("liuheng", 24);
		Employee employee4 = new Employee("sundi", 27);
		Employee employee5 = new Employee("yaorugang", 32);
		Employee employee6 = new Employee("yaorugang", 29);
		
		List<Employee> list = Arrays.asList(employee1, employee2, employee3, employee4, employee5, employee6);
		
		// sorting by Comparable
		Collections.sort(list);
		Iterator<Employee> iterator = list.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());
		
		// compare by equals()
		System.out.println("employee1 == employee5? " + employee1.equals(employee5));
		
		// sorting by Comparator
		Collections.sort(list, Collections.reverseOrder());
		iterator = list.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());
		
		
		// sorting by Name
		Collections.sort(list, new NameComparator());
		iterator = list.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());
		
		
		// sorting by Name and Age
		Collections.sort(list, new NameAgeComparator());
		iterator = list.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());
	}

	
	public static class Employee implements Comparable<Employee>
	{
		private String name;
		private int age;

		
		public Employee(String name, int age)
		{
			this.name = name;
			this.age = age;
		}
		
		@Override
		public boolean equals(Object obj)
		{
			if (getClass() != obj.getClass())
				return false;
			
			Employee employee = (Employee)obj;
			
			return (name.equals(employee.name) && age == employee.age);
		}
		
		@Override
		public int hashCode()
		{
			int hash = 5;
			hash = 97 * hash + name.hashCode();
			hash = 97 * hash + age;
			
			return hash;
		}
		
		@Override
		public String toString()
		{
			String str = String.format("Name: %s, Age: %d", name, age);
			
			return str;
		}

		@Override
		public int compareTo(Employee e)
		{
			return age - e.age;
		}
	}
	
	/**
	 * 仅按照名字进行增序排序
	 * @author Rugang
	 *
	 */
	public static class NameComparator implements Comparator<Employee>
	{
		@Override
		public int compare(Employee o1, Employee o2)
		{
			return o1.name.compareTo(o2.name);
		}
	}
	
	/**
	 * 按照名字和年龄进行增序排序
	 * @author Rugang
	 *
	 */
	public static class NameAgeComparator implements Comparator<Employee>
	{
		@Override
		public int compare(Employee o1, Employee o2)
		{
			if (o1.name.equals(o2.name))
				return o1.age - o2.age;
			else	
				return o1.name.compareTo(o2.name);
		}
		
	}
}
