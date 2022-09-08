/**
wk01_java01_201415060 클래스는 1~100 범위의 무작위 수를 맞추는 게임을 위한 클래스입니다.  

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/

/**입력을 위한 스캐너 클래스 도입*/
import java.util.Scanner;
/**무작위수를 만들 무작위 클래스 도입*/
import java.util.Random;

public class wk04_java04_201415060 {
	/**
	main 함수는 1~100 범위의 무작위 수를 맞추는 게임을 합니다.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args){
		/**입력을 위한 스캐너 객체 생성*/
		Scanner scan = new Scanner(System.in);
		/**사용자가 입력하는 수와 컴퓨터가 만든 무작위 수를 저장할 변수들 선언과 초기화*/
		int num = 0, com = 0;
		/**사용자가 게임을 계속할 의사를 저장하는 문자열 변수 선언과 초기화*/
		String str = "Yes";
		/**무작위 수를 만들 무작위 객체 생성*/
		Random random = new Random();
		
		/**계속할 의사가 "Yes"인 동안*/
		while(str.equals("Yes")){
			/**1~100 범위의 정수 입력 지시, 0 입력 시 종료*/
			System.out.print("Enter a number(1 to 100, 0 for quit): ");
			/**정수 입력*/
			num = scan.nextInt();
			
			/**입력한 수가 범위를 벗어나면*/
			if( (num<0)||(num>100)){
				/**범위를 벗어남을 알림*/
				System.out.println(num + " is out of range.");
				/**반복의 조건을 검사*/
				continue;
			}
			
			/**0을 입력하면*/
			else if (num == 0)
			{
				/**종료를 선택했음을 알림*/
				System.out.println("You choosed to quit.");
				/**계속할지 다시 확인*/
				System.out.print("Do you want to continue?(Yes/No): ");
				/**의사를 입력*/
				str = scan.next();
				/**반복의 조건을 검사*/
				continue;
			}
			
			/**1~100의 무작위 수를 저장*/
			com = random.nextInt(100)+1;
			/**입력한 수와 무작위 수가 같으면*/
			if(num==com)
			{
				/**옳은 수임을 출력*/
				System.out.println( num + " is the correct number.");
			}
			/**입력한 수가 무작위수보다 크면*/
			else if(num>com)
			{
				/**입력한 수가 더 큼을 알림*/
				System.out.println( num + " is higher than the number.");
			}
			/**입력한 수가 무작위수보다 작으면*/
			else
			{
				/**입력한 수가 더 작음을 알림*/
				System.out.println( num + " is lower than the number.");
			}
		}
		/**게임이 끝남을 알림*/
		System.out.println("You choosed to stop.");
	}
}
