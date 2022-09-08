/**
Book 클래스는
책을 표현하기
위한 클래스입니다.

속성은 책 제목, 저자, 출판사, 출판 날짜가 있고,
각 속성 값을 반환하고 바꾸는 메소드를 갖습니다.
형식을 가진 문자열로 책정보를 반환하는 메소드도 갖습니다.

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/

/**입력을 위한 스캐너 클래스 도입*/
import java.util.Scanner;

class Book
{
	/**책이름 전용 문자열 참조*/
	private String title;
	/**저자 전용 문자열 참조*/
	private String author;
	/**출판사 전용 문자열 참조*/
	private String publisher;
	/**출판일 전용 문자열 참조*/
	private String copyrightDate;
	
	/**책 생성자. 제목, 저자, 출판사, 출판일 초기화*/
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
	
	/**제목 설정 공용 메소드*/
	public void setTitle(String t)
	{
		/***/
		title = t;
	}
	
	/**제목 문자열 참조 반환 공용  메소드*/
	public String getTitle()
	{
		/***/
		return title;
	}
	
	/**저자 설정 공용 메소드*/
	public void setAuthor(String a)
	{
		/***/
		author = a;
	}
	
	/**저자 문자열 참조 반환 공용 메소드*/
	public String getAuthor()
	{
		/***/
		return author;
	}
	
	/**출판사 설정 공용 메소드*/
	public void setPublisher(String p)
	{
		/***/
		publisher = p;
	}
	
	/**출판사 문자열 참조 반환 공용 메소드*/
	public String getPublisher()
	{
		/***/
		return publisher;
	}
	
	/**출판일 설정 공용 메소드*/
	public void setCRDate(String c)
	{
		/***/
		copyrightDate = c;
	}
	
	/**출판일 문자열 참조 반환 공용 메소드*/
	public String getCRDate()
	{
		/***/
		return copyrightDate;
	}
	
	/**제목, 저자, 출판사, 출판일을 각각 한 줄씩 출력하는 메소드*/
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
wk05_java07_201415060 클래스는
책의 제목, 저자, 출판사, 출판일을 입력 받아 책 객체를 만들고
다시 그 속성을 출력하기
위한 클래스입니다. 

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/

public class wk05_java07_201415060 {

	/**
	main 함수는
	책의 제목, 저자, 출판사, 출판일을 입력 받아 책 객체를 만들고
	다시 그 속성을 출력합니다.
	@param args: the command line arguments
	@return void
	*/	
	
	public static void main(String[] args) {
		
		/**입력을 위한 스캐너 객체 생성*/
		Scanner scan = new Scanner(System.in);
		/**제목, 저자, 출판사, 출판일 저장 문자열 참조 선언과 초기화*/
		String t = "", a = "", p = "", c = "";
		/**제목 입력 지시*/
		System.out.print("Input the title: ");
		/**제목 입력*/
		t = scan.nextLine();
		/**저자 입력 지시*/
		System.out.print("Input the author: ");
		/**저자 입력*/
		a = scan.nextLine();
		/**출판사 입력 지시*/
		System.out.print("Input the publisher: ");
		/**출판사 입력*/
		p = scan.nextLine();
		/**출판일 입력 지시*/
		System.out.print("Input the copyright date: ");
		/**출판일 입력*/
		c = scan.nextLine();
		
		/**책 객체 생성과 초기화*/
		Book b = new Book(t, a, p, c);
		
		/**책 정보 출력*/
		System.out.print(b);
	}

}
