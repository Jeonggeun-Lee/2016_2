/**
 wk02_java04_201415060 클래스는 마일을 입력 받아 대응하는 킬로미터를 출력하기 위한 클래스입니다.  

 @author 201415060 이정근(nalbojima@daum.net)
 @version 1.0 Sep. 2016
 @helper 없음
 */

/**입력을 위한 스캐너 클래스 수입*/
import java.util.Scanner;


public class wk02_java04_201415060 {

	/**
	 main 함수는 입력받은 마일을 킬로미터로 바꿔  출력합니다.
	 @param args: the command line arguments
	 @return void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**마일 저장 변수*/
		double miles;
		/**킬로미터 저장 변수*/
		double kilometers;
		/**1마일은 1.60935킬로미터*/
		final double CONVERSION_FACTOR = 1.60935;
		/**입력을 위한 스캐너 객체 생성*/
		Scanner scan = new Scanner (System.in);
		/**마일 입력을 지시*/
		System.out.print("Input the miles value: ");
		/**입력한 것 중에서 소수를 마일 변수에 저장*/
		miles = scan.nextDouble();
		/**마일에서 킬로미터로의 계산식*/
		kilometers = miles * CONVERSION_FACTOR;
		/**대응 킬로미터를 출력*/
		System.out.println("Kilometers = " + kilometers );
	}

}
