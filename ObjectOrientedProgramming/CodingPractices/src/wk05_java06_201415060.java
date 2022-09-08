/**
sphere Ŭ������
���� ǥ��
�ϴ� Ŭ�����Դϴ�.
�Ӽ����� ���� ������ �����ϴ�.
�������� �ʱ�ȭ�ϴ� ������,
���� ���� �����ϴ� �޼ҵ�,
�װ��� ��ȯ�ϴ� �޼ҵ�,
���ǿ� �ѳ��̸� ��ȯ�ϴ� ������ �޼ҵ�,
���� ���ǿ� ���̸� ������ ���� ���ڿ��� ��ȯ�ϴ� �޼ҵ嵵 �����ϴ�. 

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
*/

/**��� ���� ���� ������ ���� Ŭ���� ����*/
import java.lang.Math;
/**�Է��� ���� ��ĳ�� Ŭ���� ����*/
import java.util.Scanner;
/**�Ҽ�ǥ�� ���� Ŭ���� ����*/
import java.text.DecimalFormat;

class Sphere
{
	/**���� ���� ������ �Ҽ� ���� ����*/
	private double diameter;
	/**�� ������. ������ �ʱ�ȭ*/
	public Sphere(double d)
	{
		/**���� ������ �� ����*/
		diameter = d;
	}
	
	/**������ ��ȯ ���� �޼ҵ�*/
	public double getDiameter()
	{
		/**���� �� ��ȯ*/
		return diameter;
	}
	
	/**������ ���� ���� �޼ҵ�*/
	public void setDiameter(double d)
	{
		/**������ ����*/
		diameter = d;
	}
	/**���ǰ� ��ȯ ���� �޼ҵ�*/
	public double getVolume()
	{
		/**������ ������ ���� ������ ���*/
		double r = this.diameter/2;
		/**���� ���� 4*����*�������� ������*/
		return 4 * Math.PI * r * r * r / 3;
	}
	
	/**�ѳ��� ��ȯ ���� �޼ҵ�*/
	public double getSurfaceArea()
	{
		/**������ ���*/
		double r = this.diameter/2;
		/**�ѳ��� ���� 4*����*�������� ����*/
		return 4 * Math.PI * r * r;
	}
	
	/**�Ҽ��� ǥ�� ���� ��ü.�Ҽ��� 5�ڸ�. ��ȿ���� �ʴ� �ڸ������� 0���� ä��*/
	DecimalFormat fmt = new DecimalFormat("0.00000");
	
	/**���� ������ ���ڿ��� ��ȯ�ϴ� ���� �޼ҵ�*/
	public String toString()
	{
		/**���ǿ� �ѳ��� ���� �� �ٷ� �ϴ� ���ڿ�*/
		return "Volume : " + fmt.format(this.getVolume()) + "\n"
				+ "Surface Area : " + fmt.format(this.getSurfaceArea()) + "\n";
	}
}

/**
wk05_java06_201415060 Ŭ������
�� ��ü�� �����ϰ�
������ �ʱ�ȭ�ϸ�
������ �Է¹ް�
�װ��� ������ ���ǿ� �ѳ��̸� ����Ͽ�
���Ŀ� �°� ����ϱ�
���� Ŭ�����Դϴ�.  

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
*/

public class wk05_java06_201415060 {

	/**
	main �Լ���
	�� ��ü�� �����ϰ�
	������ �ʱ�ȭ�ϸ�
	������ �Է¹ް�
	�װ��� ������ ���ǿ� �ѳ��̸� ����Ͽ�
	���Ŀ� �°� ����մϴ�.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args) {
		
		/**�� ��ü ����. �ʱ� ���� �� 0*/
		Sphere sphr = new Sphere( 0 );
		/**���� �Է� ����*/
		System.out.print("Input the diameter: ");
		/**���� �� �Է�*/
		Scanner scan = new Scanner(System.in);
		/**���� ������ ����*/
		double diam = scan.nextDouble();
		
		/**���� ���� ����*/
		sphr.setDiameter(diam);
		/**���� ���ǿ� �ѳ��� ���*/
		System.out.print(sphr);

	}

}
