/**
 wk02_java05_201415060 클래스는 시,분,초를 입력 받아 초로 계산하여 출력하기 위한 클래스입니다.  

 @author 201415060 이정근(nalbojima@daum.net)
 @version 1.0 Sep. 2016
 @helper 없음
 */
/**입력을 위한 스캐너 클래스 수입*/
import java.util.Scanner;
public class wk02_java05_201415060 {

	/**
	 main 함수는 시,분,초를 입력 받아 초로 계산하여  출력합니다.
	 @param args: the command line arguments
	 @return void
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**입력을 위한 스캐너 객체 생성*/
		Scanner scan = new Scanner(System.in);
		/**시간, 분, 초와 계산된 전체 초를 저장하는 변수*/
		int hour, minute, second, totalSecond;
		/**시간 입력 지시*/
		System.out.print("Input hours: ");
		/**입력한 것 중 정수를 시간 변수에 저장*/
		hour = scan.nextInt();
		/**분 입력 지시*/
		System.out.print("Input minutes: ");
		/**입력한 것 중 정수를 분 변수에 저장*/
		minute = scan.nextInt();
		/**초 입력 지시*/
		System.out.print("Input seconds: ");
		/**입력한 것 중 정수를 조 변수에 저장*/
		second = scan.nextInt();
		/**전체 초를 계산하는 식*/
		totalSecond = hour*3600+minute*60+second;
		/**전체 초를 출력*/
		System.out.println("Total seconds = " + totalSecond);
	}

}
