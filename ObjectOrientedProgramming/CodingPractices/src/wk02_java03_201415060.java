/**
 wk01_java01_201415060 Ŭ������ ȭ���� �Է¹޾� �����ϴ� �����µ��� ����ϱ� ���� Ŭ�����Դϴ�.  

 @author 201415060 ������(nalbojima@daum.net)
 @version 1.0 Sep. 2016
 @helper ����
 */

/**�Է��� ���� ��ĳ�� Ŭ���� ����*/
import java.util.Scanner;
public class wk02_java03_201415060 {

	/**
	 main �Լ��� �Է¹��� ȭ�� �µ��� �����µ��� �ٲ�  ����մϴ�.
	 @param args: the command line arguments
	 @return void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**����0���� �ش��ϴ� ȭ���µ� 32*/
		final int BASE = 32;
		/**���� 0.5���� �ö� ��, ȭ���� 9.0���� ���*/
		final double CONVERSION_FACTOR = 9.0/5.0;
		/**ȭ���µ� �Է� ����*/
		System.out.print( "Fahrenheit Equivalent : ");
		/**�Է��� ���� ��ĳ�� ��ü ����*/
		Scanner scan = new Scanner(System.in);
		/**�Է��� �� �߿� �Ҽ��� �޾Ƽ� ȭ�� ������ ����*/
		double fahrenheitEquivalent = scan.nextDouble();
		/**ȭ���µ����� �����µ����� ����*/
		double celsiusTemp = ( fahrenheitEquivalent - BASE ) /  CONVERSION_FACTOR;
		/**���� �µ��� ���*/
		System.out.println( "Celsius Temperature = " + celsiusTemp);
	}
}