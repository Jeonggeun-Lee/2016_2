/**
wk03_java05_201415060 클래스는 XXX-XXX-XXXX 형식으로 전화번호를 무작위로 만드는 클래스입니다.
단, 첫 세자리 숫자는 모두 8이나 9가 될 수 없고, 그 다음 세자리 숫자는 742 이하입니다. 

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Sep. 2016
@helper 없음
*/

/**무작위 수를 뽑기 위한 랜덤 클래스 수입*/
import java.util.Random;

public class wk03_java05_201415060 {
	/**
	main 함수는  xxx-xxx-xxxx 형식으로 전화번호를 무작위로 만듭니다.
	단, 첫 세자리 숫자는 모두 8이나 9가 될 수 없고, 그 다음 세자리 숫자는 742 이하입니다.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**무작위 수를 뽑기 위한 랜덤 객체 생성*/
		Random generator = new Random();
		
		/**전화번호 출력*/
		System.out.println(
				" "
				/**첫 세자리 숫자 출력 각 자리 숫자는 8이나 9일 수 없음*/
				+generator.nextInt(8)
				+generator.nextInt(8)
				+generator.nextInt(8)
				+"-"
				/**다음 세자리 숫자 출력. 단, 100~742 범위*/
				+( generator.nextInt(643)+100 )
				+"-"
				/**마지막 네자리 숫자 출력*/
				+generator.nextInt(10)
				+generator.nextInt(10)
				+generator.nextInt(10)
				+generator.nextInt(10)
				);
	}
}
