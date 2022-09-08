class Book3
{
	protected int pages;
	public Book3(int numPages)
	{
		pages = numPages;
	}
	public void setPages(int numPages)
	{
		pages = numPages;
	}
	public int getPages()
	{
		return pages;
	}
}

class Dictionary3 extends Book3
{
	private int definitions;
	private float computeRatio;
	public Dictionary3(int numPages, int numDefinitions)
	{
		super(numPages);
		definitions = numDefinitions;
		computeRatio = 0;
	}
	public double computeRatio()
	{
		computeRatio = definitions/pages;
		return computeRatio;
	}
	public void setDefinitions(int numDefinitions)
	{
		definitions = numDefinitions; 
	}
	public int getDefinitions()
	{
		return definitions; 
	}
}

public class Words2
{
	public static void main(String[] args)
	{
		Dictionary3 webster = new Dictionary3(1500,52500);
		System.out.println("Number of pages: " + webster.getPages());
		System.out.println("Number of definitions: " + webster.getDefinitions());
		System.out.println("Definitions per page: " + webster.computeRatio());
	}
}
