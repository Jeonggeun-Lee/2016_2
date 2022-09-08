/**
wk03_java08_201415060 클래스는 헤론의 공식으로 삼각형의 세 변을 입력받아 넓이를 계산하여 출력하는 클래스입니다.  

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Sep. 2016
@helper 없음
*/

/**
main 함수는 헤론의 공식으로 삼각형의 세 변을 입력받아 넓이를 계산하여 출력합니다.
@param args: the command line arguments
@return void
*/

/**입력을 위한 스캐너 클래스 수입*/
import java.util.Scanner;
/**출력 형식을 위한 자리수 형식 클래스 수입*/
import java.text.DecimalFormat;


public class wk03_java08_201415060 {

	/**
	main 함수는 헤론의 공식으로 삼각형의 세 변의 길이 입력받아 넓이를 계산하여 출력합니다.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**세변의 길이 a, b, c와 세변 길이의 합의 절반 s, 넓이 area*/
		double a, b, c, s, area;
		/**자리수 형식 객체 생성, 소수점 이하 세자리까지만 출력*/
		DecimalFormat fmt = new DecimalFormat("0.###");
		/**입력을 위한 스캐너 객체 생성*/
		Scanner scan = new Scanner(System.in);
		/**한 변 a 입력 지시*/
		System.out.print("side a: ");
		/**한 변 a 입력*/
		a = scan.nextInt();
		/**한 변 b 입력 지시*/
		System.out.print("side b: ");
		/**한 변 b 입력*/
		b = scan.nextInt();
		/**한 변 c 입력 지시*/
		System.out.print("side c: ");
		/**한 변 c 입력*/
		c = scan.nextInt();
		
		/**세 변의 길이 합의 절반 계산과 저장*/
		s = (1.0 / 2.0)* (a+b+c);
		/**헤론의 공식으로 넓이 계산과 저장*/
		area = Math.sqrt( s*(s-a)*(s-b)*(s-c) );
		
		/**넓이 출력. 소수점 이하 세자리까지만*/
		System.out.println("Area = "+fmt.format(area));
	}

}
