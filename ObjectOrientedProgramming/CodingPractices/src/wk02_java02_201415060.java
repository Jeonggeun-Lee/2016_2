/**
 wk02_java02_201415060 클래스는 한 줄의 문자를 입력받아 그대로 출력하기 위한 클래스입니다.  

 @author 201415060 이정근(nalbojima@daum.net)
 @version 1.0 Sep. 2016
 @helper 없음
 */

/**입력을 위한 스캐너 클래스 포함*/
import java.util.Scanner;

public class wk02_java02_201415060 {

	/**
	 main 함수는 한 줄의 문자를 입력받아 그대로 출력합니다.
	 @param args: the command line arguments
	 @return void
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**입력을 저장할 문자열변수*/
		String message;
		/**스캐너 객체 생성*/
		Scanner scan = new Scanner (System.in);
		/**입력을 지시*/
		System.out.println ("Enter a line of text:");
		/**엔터를 칠 때까지 입력*/
		message =  scan.nextLine();
		/**입력내용을 출력*/
		System.out.println("You entered \"" + message + "\"");
	}
}
