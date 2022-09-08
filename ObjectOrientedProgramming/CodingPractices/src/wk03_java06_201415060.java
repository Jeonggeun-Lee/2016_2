/**
wk01_java01_201415060 클래스는 2차원 평면의 좌표 두개를 입력받아 거리를 출력하기 위한 클래스입니다.  

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Sep. 2016
@helper 없음
*/

/**입력을 위한 스캐너 클래스 수입*/
import java.util.Scanner;
/**제곱근 함수와 몇제곱 함수를 가진 수학 클래스 수입*/
import java.lang.Math;

public class wk03_java06_201415060 {

	/**
	main 함수는 2차원 평면의 좌표 두개를 입력받아 거리를 출력합니다.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**두 좌표의 x, y 성분 선언*/
		int x1, y1, x2, y2;
		/**거리 계산 후 저장 변수 선언*/
		double distance;
		/**입력을 위한 스캐너 객체 생성*/
		Scanner scan = new Scanner(System.in);
		/**제 1 좌표의 x 성분 입력 지시*/
		System.out.print("x1: ");
		/**제 1 좌표의 x 성분 입력*/
		x1 = scan.nextInt();
		/**제 1 좌표의 y 성분 입력 지시*/
		System.out.print("y1: ");
		/**제 1 좌표의 y 성분 입력*/
		y1 = scan.nextInt();
		/**제 2 좌표의 x 성분 입력 지시*/
		System.out.print("x2: ");
		/**제 2 좌표의 x 성분 입력*/
		x2 = scan.nextInt();
		/**제 2 좌표의 y 성분 입력 지시*/
		System.out.print("y2: ");
		/**제 2 좌표의 y 성분 입력*/
		y2 = scan.nextInt();
		
		/**거리 공식으로 거리 계산 후 저장*/
		distance = Math.sqrt( Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
		/**거리 출력*/
		System.out.println("Distance = " + distance);
	}

}
