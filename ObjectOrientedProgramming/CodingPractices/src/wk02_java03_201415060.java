/**
 wk01_java01_201415060 클래스는 화씨를 입력받아 대응하는 섭씨온도를 출력하기 위한 클래스입니다.  

 @author 201415060 이정근(nalbojima@daum.net)
 @version 1.0 Sep. 2016
 @helper 없음
 */

/**입력을 위한 스캐너 클래스 수입*/
import java.util.Scanner;
public class wk02_java03_201415060 {

	/**
	 main 함수는 입력받은 화씨 온도를 섭씨온도로 바꿔  출력합니다.
	 @param args: the command line arguments
	 @return void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**섭씨0도에 해당하는 화씨온도 32*/
		final int BASE = 32;
		/**섭씨 0.5도가 올라갈 때, 화씨는 9.0도가 상승*/
		final double CONVERSION_FACTOR = 9.0/5.0;
		/**화씨온도 입력 지시*/
		System.out.print( "Fahrenheit Equivalent : ");
		/**입력을 위한 스캐너 객체 생성*/
		Scanner scan = new Scanner(System.in);
		/**입력한 것 중에 소수를 받아서 화씨 변수에 저장*/
		double fahrenheitEquivalent = scan.nextDouble();
		/**화씨온도에서 섭씨온도로의 계산식*/
		double celsiusTemp = ( fahrenheitEquivalent - BASE ) /  CONVERSION_FACTOR;
		/**섭씨 온도를 출력*/
		System.out.println( "Celsius Temperature = " + celsiusTemp);
	}
}