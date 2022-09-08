/**
wk09_java01_201415060 Ŭ������  
super ������ ����ϴ� ���� ���� �ֱ�
���� Ŭ�����Դϴ�.
@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Nov. 2016
@helper ����
*/

/**
 * Book2 Ŭ������ å�� ǥ���մϴ�.
 * �Ļ�Ŭ������ �θ�μ� ��Ӱ� super ���� ����� ���� �ֱ� ���� ���Դϴ�.
 * */

class Book2
{
	protected int pages;

   /**Book2�� �����ڷμ� �������� ���մϴ�.*/
	public Book2 (int numPages)
	{
		pages = numPages;
	}
   /**������ �ٲٴ� �޼ҵ�*/
	public void setPages (int numPages)
	{
		pages = numPages;
	}
   /**������ �˷��ִ� �޼ҵ�*/
	public int getPages ()
	{
		return pages;
	}
}

/**
 * Dictionary2 Ŭ������ ������ ǥ���մϴ�.
 * �װ��� å�� ����մϴ�.
 * super ������ ����� �����ֱ� ���� ����մϴ�.
 * */
class Dictionary2 extends Book2
{
	private int definitions;

/**Dictionary2�� �����ڷμ� �������� �ܾ� ���� ������ ���մϴ�.*/
	public Dictionary2 (int numPages, int numDefinitions)
	{
		super(numPages);

		definitions = numDefinitions;
	}

/**��� ������ ���� �Ļ� Ŭ���� ������ ��ȯ�ϴ� �޼ҵ�*/
	public double computeRatio ()
	{
		return definitions/pages;
	}

/**�ܾ� ���� ������ �ٲٴ� �޼ҵ�*/
	public void setDefinitions (int numDefinitions)
	{
		definitions = numDefinitions;
	}

/**�ܾ� ���� ������ �˷� �ִ� �޼ҵ�*/
	public int getDefinitions ()
	{
		return definitions;
	}
}


public class wk09_java01_201415060
{

/**
main �Լ���
�Ļ�Ŭ������ ��ü�� �����ϰ� ��� �Ǵ� �Ļ�Ŭ���� �޼ҵ带 ȣ����
�ϴ�.
@param args: the command line arguments
@return void
*/
	
	public static void main (String[] args)
	{
		Dictionary2 webster = new Dictionary2 (1500, 52500);

		System.out.println ("Number of pages: " + webster.getPages());

		System.out.println ("Number of definitions: " + webster.getDefinitions());

		System.out.println ("Definitions per page: " + webster.computeRatio());
	}
}
