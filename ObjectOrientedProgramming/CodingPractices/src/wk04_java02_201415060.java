/**
wk04_java02_201415060 클래스는 
파일에 인터넷 주소가 한 줄에 하나씩 여러 개가 있는 상황에서 
인터넷 주소 한 줄을 읽어 출력하고
다시 "/"를 구분자로 해서 한 토큰씩 한 줄에 출력
하는 클래스입니다. 

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 전지운
*/

/**입력을 위한 스캐너 클래스 도입*/
import java.util.Scanner;
/**입출력 예외를 던지기 위한 입출력 클래스 도입*/
import java.io.*;

public class wk04_java02_201415060 {

	/**
	main 함수는
	파일에 인터넷 주소가 한 줄에 하나씩 여러 개가 있는 상황에서 
	인터넷 주소 한 줄을 읽어 출력하고
	다시 "/"를 구분자로 해서 한 토큰씩 한 줄에 출력
	합니다.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args)
	{
		/**인터넷주소 저장 문자열 객체 참조 선언*/
		String url;
		/**파일과 토큰 스캐너 객체 참조 선언*/
		Scanner fileScan, urlScan;
		
		/**파일 검색, 열기 실패 예외 검사 시작*/
		try
		{
			/**파일 입력 스캐너 객체 생성 */
			fileScan = new Scanner(new File("websites.inp"));
			/**파일에서 다음 입력할 것이 있는 동안*/
			while (fileScan.hasNext())
			{
				/**파일에서 한 줄에 있는 인터넷 주소 입력*/
				url = fileScan.nextLine();
				/**인터넷 주소 출력*/
				System.out.println("URL = " + url);
				
				/**토큰 객체 생성*/
				urlScan = new Scanner(url);
				/**토큰의 구분자를 "/"로 설정*/
				urlScan.useDelimiter("/");

				/**토큰이 다음에 있는 동안*/
				while (urlScan.hasNext())
				{
					/**각 줄에 공백과 토큰을 출력*/
					System.out.println(" " + urlScan.next());
				}
				/**한 줄 인터넷 주소의 토큰이 다 출력되면 한 줄 띔*/
				System.out.println();
			}
		}
		/**전지운은 FileNotFoundException으로 예외를 받았지만*/
//		catch (FileNotFoundException e)
		/**나는 교재에 나온 대로 IOException으로 예외를 받았다.*/
		catch (IOException e)
		{
			/**전지운이 입력한 것인데 예외에 대한 메세지를 출력하는 메소드로 보인다.*/
			e.printStackTrace();
			
		}

	}

}
