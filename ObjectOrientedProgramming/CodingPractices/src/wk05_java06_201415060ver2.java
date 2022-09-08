/**
sphere2 Ŭ������ ���� ǥ���մϴ�. �Ӽ����� ���� ������ �����ϴ�.
�������� �ʱ�ȭ�ϴ� ������, ���� ���� �����ϴ� �޼ҵ� �װ��� ��ȯ�ϴ� �޼ҵ�, ���ǿ� �ѳ��̸� ��ȯ�ϴ� ������ �޼ҵ�, ���� ���ǿ� ���̸� ������ ���� ���ڿ��� ��ȯ�ϴ� �޼ҵ嵵 �����ϴ�. 

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
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
wk05_java06_201415060 Ŭ������ �� ��ü�� �����ϰ� ������ �ʱ�ȭ�ϸ� ������ �Է¹ް� �װ��� ������ ���ǿ� �ѳ��̸� ����Ͽ� ���Ŀ� �°� ����ϱ� ���� Ŭ�����Դϴ�.  

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
*/

public class wk05_java06_201415060ver2 {

	/**
	main �Լ��� �� ��ü�� �����ϰ� ������ �ʱ�ȭ�ϸ� ������ �Է¹ް� �װ��� ������ ���ǿ� �ѳ��̸� ����Ͽ� ���Ŀ� �°� ����մϴ�.
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
