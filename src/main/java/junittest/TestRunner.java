package junittest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

class TestRunner
{

	public static void main(String[] args)
	{
		Result result = JUnitCore.runClasses(TestUnit.class);
		
		for (Failure failure: result.getFailures())
			System.out.println("failure: " + failure.toString());

		System.out.println("sucess: " + result.wasSuccessful());
	
	}

}
