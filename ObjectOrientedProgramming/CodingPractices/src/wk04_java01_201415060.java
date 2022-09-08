/**
wk04_java01_201415060 클래스는 
성적을 입력 받아
점수 구간을 계산하고
코멘트를 출력
하기 위한 클래스입니다.

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/

/**입력을 위한 스캐너 클래스 도입*/
import java.util.Scanner;
public class wk04_java01_201415060
{

/**
main 함수는
성적을 입력 받아
점수 구간을 계산하고
코멘트를 출력
합니다.
@param args: the command line arguments
@return void
*/
	
	public static void main(String[] args)
	{
		/**점수, 점수 구간 자장 변수 선언*/
		int grade, category;
		
		/**입력을 위한 스캐너 객체 생성*/
		Scanner scan = new Scanner(System.in);
		
		/**성적 입력 지시 0~100*/
		System.out.print("Enter a numeric grade (0 to 100): ");
		/**성적 입력*/
		grade = scan.nextInt();
		
		/**점수 구간 계산 0~59, 60~69, 70~79, 80~89, 90~99, 100*/
		category = grade/10;
		
		/**점수 구간에 따라 다른 코멘트 출력*/
		switch(category)
		{
		/***/
		case 10:
			/***/
			System.out.println("That grade is a perfect score. Well done.");
			/***/
			break;
		/***/
		case 9:
			/***/
			System.out.println("That grade is well above average. Excellent.");
			/***/
			break;
		/***/	
		case 8:
			/***/
			System.out.println("That grade is above average. Nice job.");
			/***/
			break;
		/***/
		case 7:
			/***/
			System.out.println("That grade is average.");
			/***/
			break;
		/***/
		case 6:
			/***/
			System.out.print("That grade is below average. Please see the");
			/***/
			System.out.println("instructor for assistance.");
			/***/
			break;
		/***/
		default:
			/***/
			System.out.println("That grade is not passing.");
		}
	}
}
