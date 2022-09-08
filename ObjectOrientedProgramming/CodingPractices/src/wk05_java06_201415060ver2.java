/**
sphere2 클래스는 구를 표현합니다. 속성으로 구의 지름을 갖습니다.
지름값을 초기화하는 생성자, 지름 값을 설정하는 메소드 그것을 반환하는 메소드, 부피와 겉넓이를 반환하는 각각의 메소드, 구의 부피와 넓이를 형식을 가진 문자열로 반환하는 메소드도 가집니다. 

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/

import java.lang.Math;
import java.util.Scanner;
import java.text.DecimalFormat;

class Sphere2
{
	private float diameter;
	public Sphere2(float d)
	{
		diameter = d;
	}
	public float getDiameter()
	{
		return diameter;
	}
	public void setDiameter(float d)
	{
		diameter = d;
	}
	public float getVolume()
	{
		float r = this.diameter/2;
		return (float) (4 * Math.PI * r * r * r / 3);
	}
	
	public float getSurfaceArea()
	{
		float r = this.diameter/2;
		return (float) (4 * Math.PI * r * r);
	}
/*	
	DecimalFormat fmt = new DecimalFormat("0.#####");
	
	public String toString()
	{
		return "Volume : " + fmt.format(this.getVolume()) + "\n"
				+ "Surface Area : " + fmt.format(this.getSurfaceArea()) + "\n";
	}
	*/
	
	public String toString()
	{
		return "Volume : " + this.getVolume() + "\n"
				+ "Surface Area : " + this.getSurfaceArea() + "\n";
	}
}



/**
wk05_java06_201415060 클래스는 구 객체를 생성하고 지름을 초기화하며 지름을 입력받고 그것을 가지고 부피와 겉넓이를 계산하여 형식에 맞게 출력하기 위한 클래스입니다.  

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/

public class wk05_java06_201415060ver2 {

	/**
	main 함수는 구 객체를 생성하고 지름을 초기화하며 지름을 입력받고 그것을 가지고 부피와 겉넓이를 계산하여 형식에 맞게 출력합니다.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args) {
		
		Sphere2 sphr = new Sphere2( 0 );
		System.out.print("Input the diameter: ");
		Scanner scan = new Scanner(System.in);
		float diam = (float) scan.nextDouble();
		
		sphr.setDiameter(diam);
		System.out.print(sphr);

	}

}
