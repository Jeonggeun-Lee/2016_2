/**
wk01_java01_201415060 Ŭ������ 2���� ����� ��ǥ �ΰ��� �Է¹޾� �Ÿ��� ����ϱ� ���� Ŭ�����Դϴ�.  

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Sep. 2016
@helper ����
*/

/**�Է��� ���� ��ĳ�� Ŭ���� ����*/
import java.util.Scanner;
/**������ �Լ��� ������ �Լ��� ���� ���� Ŭ���� ����*/
import java.lang.Math;

public class wk03_java06_201415060 {

	/**
	main �Լ��� 2���� ����� ��ǥ �ΰ��� �Է¹޾� �Ÿ��� ����մϴ�.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**�� ��ǥ�� x, y ���� ����*/
		int x1, y1, x2, y2;
		/**�Ÿ� ��� �� ���� ���� ����*/
		double distance;
		/**�Է��� ���� ��ĳ�� ��ü ����*/
		Scanner scan = new Scanner(System.in);
		/**�� 1 ��ǥ�� x ���� �Է� ����*/
		System.out.print("x1: ");
		/**�� 1 ��ǥ�� x ���� �Է�*/
		x1 = scan.nextInt();
		/**�� 1 ��ǥ�� y ���� �Է� ����*/
		System.out.print("y1: ");
		/**�� 1 ��ǥ�� y ���� �Է�*/
		y1 = scan.nextInt();
		/**�� 2 ��ǥ�� x ���� �Է� ����*/
		System.out.print("x2: ");
		/**�� 2 ��ǥ�� x ���� �Է�*/
		x2 = scan.nextInt();
		/**�� 2 ��ǥ�� y ���� �Է� ����*/
		System.out.print("y2: ");
		/**�� 2 ��ǥ�� y ���� �Է�*/
		y2 = scan.nextInt();
		
		/**�Ÿ� �������� �Ÿ� ��� �� ����*/
		distance = Math.sqrt( Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
		/**�Ÿ� ���*/
		System.out.println("Distance = " + distance);
	}

}
