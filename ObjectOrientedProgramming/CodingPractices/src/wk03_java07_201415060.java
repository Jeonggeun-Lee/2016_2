/**
wk03_java07_201415060 클래스는 반지름을 입력 받아 구의 부피와 겉넓이를 구하는 클래스입니다.  

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Sep. 2016
@helper 없음
*/

/**입력을 위한 스캐너 클래스 수입*/
import java.util.Scanner;
/**출력 형식을 위한 자리수 형식 클래스 수입*/
import java.text.DecimalFormat;
public class wk03_java07_201415060 {
	/**
	main 함수는 반지름을 입력 받아 구의 부피와 겉넓이를 구합니다.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**반지름, 부피, 겉넓이*/
		double radius, volume, surface;
		/**입력을 위한 스캐너 객체 수입*/
		Scanner scan = new Scanner(System.in);
		/**출력 형식을 위한 자리수 형식 객체 생성. 소수점 이하 네자리만 출력*/
		DecimalFormat fmt = new DecimalFormat("0.####");
		
		/**반지름 입력 지시*/
		System.out.print("radius: ");
		/**반지름 입력*/
		radius = scan.nextInt();
		/**부피 계산과 저장*/
		volume = (4.0/3.0) * Math.PI * Math.pow(radius, 3);
		/**겉넓이 계산과 저장*/
		surface = 4.0 * Math.PI * Math.pow(radius, 2);
		
		/**부피 출력. 소숫점 이하 네자리까지만*/
		System.out.println("Volume = "+ fmt.format(volume) );
		/**겉넓이 출력. 소숫점 이하 네자리까지만*/
		System.out.println("Surface area = " + fmt.format(surface) );
	}

}
