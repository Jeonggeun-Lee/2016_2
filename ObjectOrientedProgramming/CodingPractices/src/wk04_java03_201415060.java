/**
wk04_java03_201415060 클래스는 연도를 입력받아 윤년인지 판단하기 위한 클래스입니다.  

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/

/**입력을 위한 스캐너 클래스 도입*/
import java.util.Scanner;

public class wk04_java03_201415060 {
	/**
	main 함수는 연도를 입력받아 윤년인지 판단합니다.
	@param args: the command line arguments
	@return void
	*/
	
	public static void main(String[] args)
	{
		/**입력을 위한 스캐너 객체 생성*/
		Scanner scan = new Scanner(System.in);
		/**연도를 저장하는 변수 선언과 초기화*/
		int year = 0;
		
		/**연도 입력을 지시*/
		System.out.print("Enter the year: ");
		/**연도 입력*/
		year = scan.nextInt();
		
		/**연도가 400으로 나뉘면*/
		if( year%400==0){
			/**윤년임을 출력*/
			System.out.println(year + " is a leap year.");
		}
		/**연도가 400으로 나뉘지 않고 100으로 나뉘면*/
		else if( year%100==0){
			/**윤년이 아님을 출력*/
			System.out.println(year + " is not a leap year.");
		}
		/**연도가 400으로 나뉘지 않고 100으로 나뉘지 않고 4로 나뉘면*/
		else if( year%4==0){
			/**윤년임을 출력*/
			System.out.println(year + " is a leap year.");
		}
		/**어떤 경우도 아니면*/
		else {
			/**윤년이 아님을 출력*/
			System.out.println(year + " is not a leap year.");
		}
	}
}
