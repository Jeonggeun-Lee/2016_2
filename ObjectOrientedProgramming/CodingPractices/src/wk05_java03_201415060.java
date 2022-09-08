/**
RationalNumber 클래스는
유리수를 표현
하는 클래스입니다.
유리수의 분자와 분모를 속성으로 갖고,
그 유리수에 다른 유리수를 더하고 빼고 곱하고 나누고,
그 유리수의 역수를 구하는 메소드를 갖습니다.
생성자와 다른 유리수와의 비교 메소드도 가지며
내부적인 계산을 위해 최소공배수를 구하는 메소드도 갖습니다.

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/

class RationalNumber
{
	/**분자와 분모 전용 정수 변수*/
	private int numerator, denominator;
	
	/**유리수 객체 생성자 공용 메소드. 매개변수로 분자, 분모 정수*/
	public RationalNumber(int numer, int denom)
	{
		/**분모가 0이면*/
		if(denom == 0)
			/**분모를 1로 저장*/
			denom = 1;
		
		/**분모가 음수면*/
		if(denom < 0)
		{
			/**분자의 부호를 바꾸고*/
			numer = numer * -1;
			/**분모의 부호를 양수로 바꿈*/
			denom = denom * -1;
		}
		
		/**분자 저장*/
		numerator = numer;
		/**분모 저장*/
		denominator = denom;
		
		/**분모 분자 약분*/
		reduce();
	}
	
	/**분자값 반환 공용 메소드*/
	public int getNumerator()
	{
		/***/
		return numerator;
	}
	
	/**분모값 반환 공용 메소드*/
	public int getDenominator()
	{
		/***/
		return denominator;
	}
	
	/**역수 반환 공용 메소드*/
	public RationalNumber reciprocal()
	{
		/**분모와 분자를 서로 바꿔 새 유리수 객체를 생성해 반환*/
		return new RationalNumber( denominator, numerator);
	}
	
	/**유리수 더하기 공용 메소드. 매개변수로 더할 유리수. 더한 결과 유리수 반환*/
	public RationalNumber add(RationalNumber op2)
	{
		/**두 유리수의 분모를 통분*/
		int commonDenominator = denominator * op2.getDenominator();
		/**제 1 분자에 제 2 분모를 곱*/
		int numerator1 = numerator * op2.getDenominator();
		/**제 1 분모에 제 2 분자를 곱*/
		int numerator2 = op2.getNumerator() * denominator;
		/**곱들을 합*/
		int sum = numerator1 + numerator2;
		
		/**곱을 분자로 통분값을 분모로 새 유리수 생성과 반환*/
		return new RationalNumber(sum, commonDenominator);
	}
	
	/**유리수 빼기 공용 메소드. 매개변수로 뺄 유리수. 뺀 결과 유리수 반환*/
	public RationalNumber subtract(RationalNumber op2)
	{
		/**두 유리수의 분모를 통분*/
		int commonDenominator = denominator * op2.getDenominator();
		/**제 1 분자에 제 2 분모를 곱*/
		int numerator1 = numerator * op2.getDenominator();
		/**제 1 분모에 제 2 분자를 곱*/
		int numerator2 = op2.getNumerator() * denominator;
		/**곱들의 차*/
		int difference = numerator1 - numerator2;
		
		/**곱들의 차를 분자로 통분 값을 분모로*/
		return new RationalNumber(difference, commonDenominator);
	}
	
	/**유리수 곱 공용 메소드. 매개변수로 곱할 유리수. 반환값으로 곱한 결과 유리수*/
	public RationalNumber multiply(RationalNumber op2)
	{
		/**분자끼리 곱*/
		int numer = numerator * op2.getNumerator();
		/**분모끼리 곱*/
		int denom = denominator * op2.getDenominator();
		/**각 곱을 다시 분자와 분모로 해서 유리수 생성 후 반환*/
		return new RationalNumber(numer, denom);
	}
	
	/**유리수 나누기 공용 메소드. 매개변수로 나눌 유리수. 반환값으로 나눈 결과 유리수*/
	public RationalNumber divide(RationalNumber op2)
	{
		/**나눌 유리수의 역수를 곱함*/
		return multiply(op2.reciprocal());
	}
	
	/**다른 유리수와 비교하는 공용 메소드 같으면 참 반환*/
	public boolean isLike(RationalNumber op2)
	{
		/**분자가 같고 분모가 같으면 참 반환*/
		return ( numerator == op2.getNumerator() &&
				denominator == op2.getDenominator() );
	}
	
	/**유리수 정보를 형식을 가진 문자열로 반환하는 공용 메소드*/
	public String toString()
	{
		/**반환할 문자열을 참조할 변수 선언*/
		String result;
		
		/**분자가 0 이면 "0" 반환*/
		if(numerator == 0)
			/***/
			result = "0";
		/**분자가 0이 아니면*/
		else
			/**분모가 1이면*/
			if(denominator == 1)
				/**분자를 문자열로 반환*/
				result = numerator + "";
			/**분모가 1이 아니면*/
			else
				/**분자 "/" 분모 형식으로 문자열 반환*/
				result = numerator + "/" + denominator;
		
		/**각 경우에 저장된 문자열 참조 반환*/
		return result;
	}
	
	/**분자와 분모 약분 공용 메소드*/
	private void reduce()
	{
		/**분자가 0이 아니면*/
		if(numerator !=0)
		{
			/**분자의 절댓값과 분모의 최대공약수를 구하여 저장*/
			int common = gcd( Math.abs(numerator),denominator );
			
			/**최대공약수로 분자 나눔*/
			numerator = numerator / common;
			/**최대공약수로 분모 나눔*/
			denominator = denominator / common;
		}
	}
	
	/**유리수 클래스 안에서만 최대 공약수를 구하는 전용 메소드. 매개변수로 두 정수. 반환값으로 두 정수의 최대공약수*/
	private int gcd( int num1, int num2 )
	{
		/**두 정수가 다른 동안*/
		while( num1 != num2)
			/**제 1 정수가 제 2 정수보다 크면*/
			if( num1 > num2 )
				/**제 1 정수에서 제 2 정수 뺌*/
				num1 = num1 - num2;
			/**제 1 정수가 제 2 정수보다 작으면*/
			else
				/**제 2 정수에서 제 1 정수 뺌*/
				num2 = num2 - num1;
		
		/**최대 공양수 반환*/
		return num1;
	}
}

/**
wk05_java03_201415060 클래스는
유리수의 계산을 하기
위한 클래스입니다.

두 유리수를 생성하고 초기화합니다.
두 유리수가 같은지 판단하고
첫 유리수의 역수 유리수를 생성하여 출력하고,
두 유리수의 합, 차, 곱, 나누기의 결과 유리수를 출력합니다.

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/

public class wk05_java03_201415060 {


/**
main 함수는
유리수의 계산을
합니다.

두 유리수를 생성하고 초기화합니다.
두 유리수가 같은지 판단하고
첫 유리수의 역수 유리수를 생성하여 출력하고,
두 유리수의 합, 차, 곱, 나누기의 결과 유리수를 출력합니다.
@param args: the command line arguments
@return void
*/
	public static void main(String[] args) {
		/**유리수 6/8 생성*/
		RationalNumber r1 = new RationalNumber(6,8);
		/**유리수 1/3 생성*/
		RationalNumber r2 = new RationalNumber(1,3);
		/**역수, 합, 차, 곱, 나누기 결과를 참조할 유리수 변수 선언*/
		RationalNumber r3, r4, r5, r6, r7;
		
		/**제 1 유리수 출력*/
		System.out.println("First rational number = " + r1);
		/**제 2 유리수 출력*/
		System.out.println("Second rational number = " + r2);
		
		/**제 1,2 유리수가 같으면*/
		if(r1.isLike(r2))
			/**같음을 출력*/
			System.out.println("r1 and r2 are equal.");
		/**다르면*/
		else
			/**다름을 출력*/
			System.out.println("r1 and r2 are NOT equal.");
		
		/**제 3 유리수는 제 1 유리수의 역수로*/
		r3 = r1.reciprocal();
		/**제 1 유리수의 역수 출력*/
		System.out.println("The reciprocal of r1 is = " + r3);
		
		/**제 1 유리수와 제 2 유리수의 합을 제 4 유리수로*/
		r4 = r1.add(r2);
		/**제 1 유리수와 제 2 유리수의 차를 제 5 유리수로*/
		r5 = r1.subtract(r2);
		/**제 1 유리수와 제 2 유리수의 곱을 제 6 유리수로*/
		r6 = r1.multiply(r2);
		/**제 1 유리수와 제 2 유리수의 나눗셈을 제 7 유리수로*/
		r7 = r1.divide(r2);
		
		/**합, 차, 곱, 나눗셈 결과 출력*/
		System.out.println("r1 + r2 = " + r4);
		/***/
		System.out.println("r1 - r2 = " + r5);
		/***/
		System.out.println("r1 * r2 = " + r6);
		/***/
		System.out.println("r1 / r2 = " + r7);
	}
}