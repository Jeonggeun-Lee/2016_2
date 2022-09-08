/**
sphere 클래스는
구를 표현
하는 클래스입니다.
속성으로 구의 지름을 갖습니다.
지름값을 초기화하는 생성자,
지름 값을 설정하는 메소드,
그것을 반환하는 메소드,
부피와 겉넓이를 반환하는 각각의 메소드,
구의 부피와 넓이를 형식을 가진 문자열로 반환하는 메소드도 가집니다. 

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/

/**상수 파이 값을 정의한 수학 클래스 도입*/
import java.lang.Math;
/**입력을 위한 스캐너 클래스 도입*/
import java.util.Scanner;
/**소수표현 형식 클래스 도입*/
import java.text.DecimalFormat;

class Sphere
{
	/**지름 전용 고정밀 소수 변수 선언*/
	private double diameter;
	/**구 생성자. 지름을 초기화*/
	public Sphere(double d)
	{
		/**지름 변수에 값 저장*/
		diameter = d;
	}
	
	/**지름값 반환 공영 메소드*/
	public double getDiameter()
	{
		/**지름 값 반환*/
		return diameter;
	}
	
	/**지름값 설정 공용 메소드*/
	public void setDiameter(double d)
	{
		/**지름값 저장*/
		diameter = d;
	}
	/**부피값 반환 공용 메소드*/
	public double getVolume()
	{
		/**지름을 반으로 나눠 반지름 계산*/
		double r = this.diameter/2;
		/**부피 공식 4*파이*반지름의 세제곱*/
		return 4 * Math.PI * r * r * r / 3;
	}
	
	/**겉넓이 반환 공용 메소드*/
	public double getSurfaceArea()
	{
		/**반지름 계산*/
		double r = this.diameter/2;
		/**겉넓이 공식 4*파이*반지름의 제곱*/
		return 4 * Math.PI * r * r;
	}
	
	/**소수점 표현 형식 객체.소수점 5자리. 유효하지 않는 자리수까지 0으로 채움*/
	DecimalFormat fmt = new DecimalFormat("0.00000");
	
	/**구의 정보를 문자열로 반환하는 공용 메소드*/
	public String toString()
	{
		/**부피와 겉넓이 각각 한 줄로 하는 문자열*/
		return "Volume : " + fmt.format(this.getVolume()) + "\n"
				+ "Surface Area : " + fmt.format(this.getSurfaceArea()) + "\n";
	}
}

/**
wk05_java06_201415060 클래스는
구 객체를 생성하고
지름을 초기화하며
지름을 입력받고
그것을 가지고 부피와 겉넓이를 계산하여
형식에 맞게 출력하기
위한 클래스입니다.  

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/

public class wk05_java06_201415060 {

	/**
	main 함수는
	구 객체를 생성하고
	지름을 초기화하며
	지름을 입력받고
	그것을 가지고 부피와 겉넓이를 계산하여
	형식에 맞게 출력합니다.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args) {
		
		/**구 개체 생성. 초기 지름 값 0*/
		Sphere sphr = new Sphere( 0 );
		/**지름 입력 지시*/
		System.out.print("Input the diameter: ");
		/**지름 값 입력*/
		Scanner scan = new Scanner(System.in);
		/**지름 변수에 저장*/
		double diam = scan.nextDouble();
		
		/**구의 지름 설정*/
		sphr.setDiameter(diam);
		/**구의 부피와 겉넓이 출력*/
		System.out.print(sphr);

	}

}
