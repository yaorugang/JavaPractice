
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.TreeSet;

public class GeneralTest
{

	public static void main(String[] args)
	{
		// 
		String separator = System.getProperty("line.separator"); 
		System.out.println(separator.equals("\r\n"));
		
		
		//
		byte a = 2;
		byte b = 3;
//		a = a + b;	// a 和 b会被自动提升为int，所以将int赋值给byte报错
		a += b;		// += 符号会自动将计算结果强制转换成 a 的类型
		
		
		// WeakReference
		String str = "test string!";
		WeakReference<String> weakReference = new WeakReference<String>(str);
		str = null;
		
		
		// 
		System.out.println();
		System.out.println("JVM bit size is: " + System.getProperty("sun.arch.data.model"));
		System.out.println("JVM bit size is: " + System.getProperty("os.arch"));
		
		
		// 
		System.out.println();
		System.out.println("JVM 空闲内存空间: " + Runtime.getRuntime().freeMemory());
		System.out.println("JVM 总内存空间: " + Runtime.getRuntime().totalMemory());
		System.out.println("JVM 最大内存空间: " + Runtime.getRuntime().maxMemory());
		
		
		// TreeSet
		System.out.println();
		TreeSet<String> books = new TreeSet<>();
		books.add("Java");
		books.add("C++");
		books.add("文明之光");
		books.add("数学之美");
		books.add("Python");
		
		Iterator<String> iterator = books.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());
		
	
	}
}
