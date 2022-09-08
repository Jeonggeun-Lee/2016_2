/**
wk09_java01_201415060 클래스는  
super 참조를 사용하는 것을 보여 주기
위한 클래스입니다.
@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Nov. 2016
@helper 없음
*/

/**
 * Book2 클래스는 책을 표현합니다.
 * 파생클래스의 부모로서 상속과 super 참조 사용을 보여 주기 위한 것입니다.
 * */

class Book2
{
	protected int pages;

   /**Book2의 생성자로서 페이지를 정합니다.*/
	public Book2 (int numPages)
	{
		pages = numPages;
	}
   /**페이지 바꾸는 메소드*/
	public void setPages (int numPages)
	{
		pages = numPages;
	}
   /**페이지 알려주는 메소드*/
	public int getPages ()
	{
		return pages;
	}
}

/**
 * Dictionary2 클래스는 사전을 표현합니다.
 * 그것은 책을 상속합니다.
 * super 참조의 사용을 보여주기 위해 사용합니다.
 * */
class Dictionary2 extends Book2
{
	private int definitions;

/**Dictionary2의 생성자로서 페이지와 단어 정의 개수를 정합니다.*/
	public Dictionary2 (int numPages, int numDefinitions)
	{
		super(numPages);

		definitions = numDefinitions;
	}

/**상속 변수로 나눈 파생 클래스 변수를 반환하는 메소드*/
	public double computeRatio ()
	{
		return definitions/pages;
	}

/**단어 정의 개수를 바꾸는 메소드*/
	public void setDefinitions (int numDefinitions)
	{
		definitions = numDefinitions;
	}

/**단어 정의 개수를 알려 주는 메소드*/
	public int getDefinitions ()
	{
		return definitions;
	}
}


public class wk09_java01_201415060
{

/**
main 함수는
파생클래스의 객체를 생성하고 상속 또는 파생클래스 메소드를 호출합
니다.
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
