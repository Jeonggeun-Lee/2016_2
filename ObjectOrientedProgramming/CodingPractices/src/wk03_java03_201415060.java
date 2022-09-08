/**
wk03_java03_201415060 클래스는 이름과 성을 입력 받고 이름의 첫글자와 성의 첫 다섯 글자를 조합하고 거기에 두자리 자연수를 조합하여 아이디를 만드는 클래스입니다.  

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Sep. 2016
@helper 없음
*/

import java.util.Scanner;
import java.util.Random;

/**
main 함수는 이름과 성을 입력 받고 이름의 첫글자와 성의 첫 다섯 글자를 조합하고 거기에 두 자리 자연수를 조합하여 아이디를 만듭니다.
@param args: the command line arguments
@return void
*/

public class wk03_java03_201415060{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**이름, 성, 아이디 저장 변수 선언*/
		String firstname, lastname, ID;
		/**무작위 수를 만들기 위한 랜덤 객체 생성*/
		Random generator = new Random();
		/**입력을 위한 스캐너 객체 생성*/
		Scanner scan = new Scanner(System.in);
		
		/**이름 입력 지시*/
		System.out.print("Enter the first name: ");
		/**이름 입력*/
		firstname = scan.next();
		
		/**성 입력 지시*/
		System.out.print("Enter the last name: ");
		/**성 입력 지시*/
		lastname = scan.next();
		
		/**이름의 첫글자와 성의 첫 다섯 글자를 조합하고 거기에 두자리 자연수를 조합*/
		ID = firstname.charAt(0)
				+ lastname.substring(0,5)
				+ (generator.nextInt(90)+10);
		
		/***/
		System.out.println(ID);
	}

}
