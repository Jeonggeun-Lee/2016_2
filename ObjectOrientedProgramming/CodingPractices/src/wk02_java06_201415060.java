/**
wk02_java05_201415060 클래스는 초를 입력 받아 시,분,초로 계산하여 출력하기 위한 클래스입니다.  

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Sep. 2016
@helper 없음
*/

import java.util.Scanner;


public class wk02_java06_201415060 {

/**
main 함수는 초를 입력 받아 시,분,초로 계산하여  출력합니다.
@param args: the command line arguments
@return void
*/


	public static void main(String[] args) {

		/**입력을 위한 스캐너 객체 생성*/
		Scanner scan = new Scanner(System.in);
		/**입력 초와 변환 될 시간, 분, 초를 저장할 변수*/
		int totalSecond, hour, minute, second;
		/**초 입력을 지시*/
		System.out.print("Input seconds: ");
		/**입력한 것 중 정수를 전체 초 변수에 저장*/
		totalSecond = scan.nextInt();
		/**시간을 계산해 저장*/
		hour = totalSecond/3600;
		/**시간 출력*/
		System.out.println("hours = " + hour);		
		/**시간의 양을 전체 초에서 제거*/
		totalSecond %=3600;
		/**분을 계산해 저장*/
		minute = totalSecond/60;
		/**분을 출력*/
		System.out.println("minutes = " + minute);
		/**분의 양을 전체 초에서 제거*/
		totalSecond %=60;
		/**남은 초를 저장*/
		second = totalSecond;
		/**초를 출력*/
		System.out.println("seconds = " + second);		
	}

}
