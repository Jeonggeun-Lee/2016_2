/**
wk03_java04_201415060 클래스는 두 개의 정수를 입력 받아, 각각의 세제곱의 합을 출력하기 위한 클래스입니다.  

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Sep. 2016
@helper 없음
*/

/**입력을 위한 스캐너 클래스 수입*/
import java.util.Scanner;
/**몇제곱 메소드를 가진 수학 클래스 수입*/
import java.lang.Math;
public class wk03_java04_201415060 {
	/**
	main 함수는  두 개의 정수를 입력 받아, 각각의 세제곱의 합을 출력합니다.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**입력을 위한 스캐너 객체 생성*/
		Scanner scan = new Scanner(System.in);
		/**입력 받을 두 정수의 변수 선언*/
		int num1, num2;
		
		/**제 1 정수 입력 지시*/
		System.out.print("Enter the first number: ");
		/**제 1 정수 입력*/
		num1 = scan.nextInt();
		/**제 2 정수 입력 지시*/
		System.out.print("Enter the second number: ");
		/**제 2 정수 입력*/
		num2 = scan.nextInt();
		
		/**두 정수 각각의 세제곱의 합을 출력*/
		System.out.println( (int)Math.pow(num1, 3)+(int)Math.pow(num2, 3) );
	}

}
