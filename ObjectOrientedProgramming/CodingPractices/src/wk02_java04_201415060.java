/**
 wk02_java04_201415060 Ŭ������ ������ �Է� �޾� �����ϴ� ų�ι��͸� ����ϱ� ���� Ŭ�����Դϴ�.  

 @author 201415060 ������(nalbojima@daum.net)
 @version 1.0 Sep. 2016
 @helper ����
 */

/**�Է��� ���� ��ĳ�� Ŭ���� ����*/
import java.util.Scanner;


public class wk02_java04_201415060 {

	/**
	 main �Լ��� �Է¹��� ������ ų�ι��ͷ� �ٲ�  ����մϴ�.
	 @param args: the command line arguments
	 @return void
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**���� ���� ����*/
		double miles;
		/**ų�ι��� ���� ����*/
		double kilometers;
		/**1������ 1.60935ų�ι���*/
		final double CONVERSION_FACTOR = 1.60935;
		/**�Է��� ���� ��ĳ�� ��ü ����*/
		Scanner scan = new Scanner (System.in);
		/**���� �Է��� ����*/
		System.out.print("Input the miles value: ");
		/**�Է��� �� �߿��� �Ҽ��� ���� ������ ����*/
		miles = scan.nextDouble();
		/**���Ͽ��� ų�ι��ͷ��� ����*/
		kilometers = miles * CONVERSION_FACTOR;
		/**���� ų�ι��͸� ���*/
		System.out.println("Kilometers = " + kilometers );
	}

}
