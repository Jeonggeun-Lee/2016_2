/**
Book Ŭ������
å�� ǥ���ϱ�
���� Ŭ�����Դϴ�.

�Ӽ��� å ����, ����, ���ǻ�, ���� ��¥�� �ְ�,
�� �Ӽ� ���� ��ȯ�ϰ� �ٲٴ� �޼ҵ带 �����ϴ�.
������ ���� ���ڿ��� å������ ��ȯ�ϴ� �޼ҵ嵵 �����ϴ�.

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
*/

/**�Է��� ���� ��ĳ�� Ŭ���� ����*/
import java.util.Scanner;

class Book
{
	/**å�̸� ���� ���ڿ� ����*/
	private String title;
	/**���� ���� ���ڿ� ����*/
	private String author;
	/**���ǻ� ���� ���ڿ� ����*/
	private String publisher;
	/**������ ���� ���ڿ� ����*/
	private String copyrightDate;
	
	/**å ������. ����, ����, ���ǻ�, ������ �ʱ�ȭ*/
	public Book(String t, String a, String p, String c)
	{
		/***/
		title = t;
		/***/
		author = a;
		/***/
		publisher = p;
		/***/
		copyrightDate = c;
	}
	
	/**���� ���� ���� �޼ҵ�*/
	public void setTitle(String t)
	{
		/***/
		title = t;
	}
	
	/**���� ���ڿ� ���� ��ȯ ����  �޼ҵ�*/
	public String getTitle()
	{
		/***/
		return title;
	}
	
	/**���� ���� ���� �޼ҵ�*/
	public void setAuthor(String a)
	{
		/***/
		author = a;
	}
	
	/**���� ���ڿ� ���� ��ȯ ���� �޼ҵ�*/
	public String getAuthor()
	{
		/***/
		return author;
	}
	
	/**���ǻ� ���� ���� �޼ҵ�*/
	public void setPublisher(String p)
	{
		/***/
		publisher = p;
	}
	
	/**���ǻ� ���ڿ� ���� ��ȯ ���� �޼ҵ�*/
	public String getPublisher()
	{
		/***/
		return publisher;
	}
	
	/**������ ���� ���� �޼ҵ�*/
	public void setCRDate(String c)
	{
		/***/
		copyrightDate = c;
	}
	
	/**������ ���ڿ� ���� ��ȯ ���� �޼ҵ�*/
	public String getCRDate()
	{
		/***/
		return copyrightDate;
	}
	
	/**����, ����, ���ǻ�, �������� ���� �� �پ� ����ϴ� �޼ҵ�*/
	public String toString()
	{
		/***/
		return "TITLE = " + this.getTitle() + "\n"
				+ "AUTHOR = " + this.getAuthor() + "\n"
				+ "PUBLISHER = " + this.getPublisher() + "\n"
				+ "COPYRIGHT DATE = " + this.getCRDate() + "\n";
	}
}

/**
wk05_java07_201415060 Ŭ������
å�� ����, ����, ���ǻ�, �������� �Է� �޾� å ��ü�� �����
�ٽ� �� �Ӽ��� ����ϱ�
���� Ŭ�����Դϴ�. 

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
*/

public class wk05_java07_201415060 {

	/**
	main �Լ���
	å�� ����, ����, ���ǻ�, �������� �Է� �޾� å ��ü�� �����
	�ٽ� �� �Ӽ��� ����մϴ�.
	@param args: the command line arguments
	@return void
	*/	
	
	public static void main(String[] args) {
		
		/**�Է��� ���� ��ĳ�� ��ü ����*/
		Scanner scan = new Scanner(System.in);
		/**����, ����, ���ǻ�, ������ ���� ���ڿ� ���� ����� �ʱ�ȭ*/
		String t = "", a = "", p = "", c = "";
		/**���� �Է� ����*/
		System.out.print("Input the title: ");
		/**���� �Է�*/
		t = scan.nextLine();
		/**���� �Է� ����*/
		System.out.print("Input the author: ");
		/**���� �Է�*/
		a = scan.nextLine();
		/**���ǻ� �Է� ����*/
		System.out.print("Input the publisher: ");
		/**���ǻ� �Է�*/
		p = scan.nextLine();
		/**������ �Է� ����*/
		System.out.print("Input the copyright date: ");
		/**������ �Է�*/
		c = scan.nextLine();
		
		/**å ��ü ������ �ʱ�ȭ*/
		Book b = new Book(t, a, p, c);
		
		/**å ���� ���*/
		System.out.print(b);
	}

}
