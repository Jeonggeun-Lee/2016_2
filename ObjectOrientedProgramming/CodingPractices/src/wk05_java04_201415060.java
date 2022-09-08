/**
Num 클래스는
정수를 표현
하기 위한 클래스입니다.  

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/

class Num
{
	/**값 저장 전용 변수*/
	private int value;
	
	/**생성자 공용 메소드. 매개 변수로 초기값.*/
	public Num(int update)
	{
		/**초기값을 값 변수에 저장*/
		value = update;
	}
	
	/**값 설정 공용 메소드. 매개변수로 설정 값*/
	public void setValue(int update)
	{
		/**값 변수에 설정 값 저장*/
		value = update;
	}
	
	/**객체를 문자열로 바꾸는 공용 메소드. 값을 문자열로 반환*/
	public String toString()
	{
		/***/
		return value + "";
	}
}

/**
ParameterModifier 클래스는
형식 매개변수인 정수 변수와 Num 형 객체 두 개의 값을 한꺼번에 출력하고
정수 변수와 제 1 Num형 객체는 값을 바꾸고 제 2 Num 형 객체의 참조는 다른 객체를 참조하게 하며
그 후 다시 세 값들을 출력
하기 위한 클래스입니다.

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/

class ParameterModifier
{
	/**형식 매개변수인 정수 변수와 Num형 객체 2개를 바꾸는 메소드*/
	public void changeValue(int f1, Num f2, Num f3)
	{
		/**값을 바꾸기 전 변수와 객체 값 출력*/
		System.out.println("Before changing the values");
		/***/
		System.out.println("f1\tf2\tf3");
		/***/
		System.out.println(f1 + "\t" + f2 + "\t" + f3 );
		
		/**정수 변수에 999 저장*/
		f1 = 999;
		/**제 1 Num 형 객체의 값을 888로 저장*/
		f2.setValue(888);
		/**제 2 Num 형 객체의 참조를 777값을 가지는 Num형의 객체의 참조로 바꿈*/
		f3 = new Num(777);
		
		/**바꾼 값을 출력*/
		System.out.println("After changing the values");
		/***/
		System.out.println("f1\tf2\tf3");
		/***/
		System.out.println(f1 + "\t" + f2 + "\t" + f3 );
	}
}

/**
wk05_java04_201415060 클래스는
정수 변수와 두 Num형 객체를 만들어 초기화 하고
세 값을 출력한 뒤
특수한 수정 객체를 이용해 형식 매개변수를 한꺼번에 바꾸는 메소드를 호출하고
호출 후 메인 함수의 실질 매개 변수인 정수와 두 객체의 값을 출력하기
위한 클래스입니다.

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/

public class wk05_java04_201415060 {
	/**
	main 함수는
	정수 변수와 두 Num형 객체를 만들어 초기화 하고
	세 값을 출력한 뒤
	특수한 수정 객체를 이용해 형식 매개변수를 한꺼번에 바꾸는 메소드를 호출하고
	호출 후 메인 함수의 실질 매개 변수인 정수와 두 객체의 값을 출력
	합니다.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args)
	{
		/**특수한 수정을 위한 객체 생성*/
		ParameterModifier modifier = new ParameterModifier();
		
		/**정수 변수 선언과 초기화*/
		int a1 = 111;
		/**제 1 Num 객체 생성*/
		Num a2 = new Num(222);
		/**제 2 Num 객체 생성*/
		Num a3 = new Num(333);
		
		/**수정 객체의 수정 메소드 호출 전 정수와 두 객체의 값*/
		System.out.println("Before calling changeValues");
		/***/
		System.out.println("a1\ta2\ta3");
		/***/
		System.out.println(a1 + "\t" + a2 + "\t" + a3 );
		
		/**수정 메소드 호출*/
		modifier.changeValue(a1, a2, a3);
		
		/**수정 메소드 호출 후 메인에서 만든 정수와 두 객체의 값 출력*/
		System.out.println("After calling changeValues");
		/***/
		System.out.println("a1\ta2\ta3");
		/***/
		System.out.println(a1 + "\t" + a2 + "\t" + a3 );
		
	}

}
