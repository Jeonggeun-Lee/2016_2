/**
 wk02_java01_201415060 클래스는 섭씨 24도를 화씨로 바꿔 출력하기 위한 클래스입니다.  

 @author 201415060 이정근(nalbojima@daum.net)
 @version 1.0 Sep. 2016
 @helper 없음
 */


public class wk02_java01_201415060 {

	/**
	 main 함수는 섭씨 24도를 화씨로 바꿔  출력합니다.
	 @param args: the command line arguments
	 @return void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**섭씨0도에 해당하는 화씨온도 32*/
		final int BASE = 32;
		/**섭씨 0.5도가 올라갈 때, 화씨는 9.0도가 상승*/
		final double CONVERSION_FACTOR = 9.0/5.0;
		/**화씨온도를 저장할 변수*/
		double fahrenheitTemp;
		/**변환할 섭씨온도 24도*/
		int celsiusTemp = 24;
		/**섭씨온도에서 화씨온도로의 관계식*/
		fahrenheitTemp = celsiusTemp * CONVERSION_FACTOR + BASE;
		/**섭씨온도와 화씨온도 출력*/
		System.out.println( "Celsius Temperature = " + celsiusTemp);
		System.out.println( "Fahrenheit Equivalent = " + fahrenheitTemp);
	}

}
