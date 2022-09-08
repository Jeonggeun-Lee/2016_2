/**
wk11_java02_201415060 클래스는  
상속을 통해 예외를 정의할 수 있는 가능성을 보여주기
위한 클래스입니다.
@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Nov. 2016
@helper 없음
*/
import java.util.Scanner;

public class wk11_java02_201415060
{
	/**
	main 함수는
	예외 객체를 만들고 때론 그것을 던집
	니다.
	@param args: the command line arguments
	@return void
	*/
	public static void main (String[] args) throws OutOfRangeException
	{
		/**입력 범위의 최대 최소값*/
		final int MIN = 25, MAX = 40;
		/**입력을 받는 스캐너 객체 생성*/
		Scanner scan = new Scanner (System.in);
		/**예외객체 생성. 예외 메시지 설정*/
		OutOfRangeException problem = new OutOfRangeException ("Input value is out of range.");
		/**범위 안에서 입력을 지시*/
		System.out.print ("Enter an integer value between " + MIN + " and " + MAX + ", inclusive: ");
		/**정수 입력을 받음*/
		int value = scan.nextInt();
		
		/**예외를 던져야할지 판단합니다.*/
		if (value < MIN || value > MAX)
			/**예외를 던짐*/
			throw problem;
		/**메인 메소드의 끝을 알림*/
		System.out.println ("End of main method.");  // may never reach
	}
}

/**OutOfRangeException 클래스는
 * 값이 어떤 특정 범위 밖에 있는 예외 조건을 표현합니다.
 * */
class OutOfRangeException extends Exception
{
	/**특정 메시지로 예외 객체를 설정합니다.*/
	OutOfRangeException (String message)
	{
		/**부모인 예외 클래스의 생성자*/
		super (message);
	}
}
