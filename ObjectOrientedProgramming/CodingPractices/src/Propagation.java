public class Propagation
{
	static public void main (String []args)
	{
		ExceptionScope0 demo = new ExceptionScope0 ();
		System.out.println("Program beginning.");
		demo.level1();
		System.out.println("Program ending.");
	}
}

class ExceptionScope0
{
	public void level1()
	{
		System.out.println("Level 1 beginning.");
		try
		{
			level2();
		}
		catch (ArithmeticException problem)
		{
			System.out.println("\nThe exception message is: "+ problem.getMessage() );
			System.out.println("\nThe call stack trace:");
			problem.printStackTrace();
		}
		System.out.println("Level 1 ending.");
	}
	public void level2()
	{
		System.out.println("Level 2 beginning.");
		level3 ();
		System.out.println("Level 2 ending.");
	}
	public void level3 ()
	{
		int numerator = 10, denominator = 0;
		System.out.println("Level 3 beginning.");
		int result = numerator / denominator;
		System.out.println("Level 3 ending.");
	}
}