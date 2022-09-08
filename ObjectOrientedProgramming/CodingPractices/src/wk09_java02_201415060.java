/**
wk09_java02_201415060 클래스는  
재정의한 메소드의 사용을 보여주기
위한 클래스입니다.
@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Nov. 2016
@helper 없음
*/

/**Thought 클래스는 하나의 생각을 표현합니다.
 * 부모 클래스로서 파생클래스가 재정의한 메소드의 사용을 보여 줍니다.*/
class Thought
{
	/**메세지를 인쇄하는 메소드*/

	public void message()
	{
		System.out.println ("I feel like I'm diagonally parked in a " + "parallel universe.");
	}
}

/**Advice 클래스는 충고를 표현합니다.
 * 재정의한 메소드의 사용을 보여주기 위해 사용합니다.*/

class Advice extends Thought
{
	/**메세지를 출력하는 메소드
	 *부모 메소드를 재정의*/
	public void message()
	{
		System.out.println ("Warning: Dates in calendar are closer " + "than they appear.");
/**명시적으로 부모가 정의한 메소드를 호출*/
		super.message();
	}
}


public class wk09_java02_201415060
{
	
/**
main 함수는
두 객체를 생성하고 각각의 메세지 메소드를 호출합
니다.
@param args: the command line arguments
@return void
*/
	public static void main (String[] args)
	{
		Thought parked = new Thought();
		Advice dates = new Advice();

		parked.message();
      /**파생클래스에서 재정의한 메소드입니다.*/
		dates.message();
	}
}
