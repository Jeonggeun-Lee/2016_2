/**
wk03_java08_201415060 Ŭ������ ����� �������� �ﰢ���� �� ���� �Է¹޾� ���̸� ����Ͽ� ����ϴ� Ŭ�����Դϴ�.  

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Sep. 2016
@helper ����
*/

/**
main �Լ��� ����� �������� �ﰢ���� �� ���� �Է¹޾� ���̸� ����Ͽ� ����մϴ�.
@param args: the command line arguments
@return void
*/

/**�Է��� ���� ��ĳ�� Ŭ���� ����*/
import java.util.Scanner;
/**��� ������ ���� �ڸ��� ���� Ŭ���� ����*/
import java.text.DecimalFormat;


public class wk03_java08_201415060 {

	/**
	main �Լ��� ����� �������� �ﰢ���� �� ���� ���� �Է¹޾� ���̸� ����Ͽ� ����մϴ�.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**������ ���� a, b, c�� ���� ������ ���� ���� s, ���� area*/
		double a, b, c, s, area;
		/**�ڸ��� ���� ��ü ����, �Ҽ��� ���� ���ڸ������� ���*/
		DecimalFormat fmt = new DecimalFormat("0.###");
		/**�Է��� ���� ��ĳ�� ��ü ����*/
		Scanner scan = new Scanner(System.in);
		/**�� �� a �Է� ����*/
		System.out.print("side a: ");
		/**�� �� a �Է�*/
		a = scan.nextInt();
		/**�� �� b �Է� ����*/
		System.out.print("side b: ");
		/**�� �� b �Է�*/
		b = scan.nextInt();
		/**�� �� c �Է� ����*/
		System.out.print("side c: ");
		/**�� �� c �Է�*/
		c = scan.nextInt();
		
		/**�� ���� ���� ���� ���� ���� ����*/
		s = (1.0 / 2.0)* (a+b+c);
		/**����� �������� ���� ���� ����*/
		area = Math.sqrt( s*(s-a)*(s-b)*(s-c) );
		
		/**���� ���. �Ҽ��� ���� ���ڸ�������*/
		System.out.println("Area = "+fmt.format(area));
	}

}
