/**
wk03_java04_201415060 Ŭ������ �� ���� ������ �Է� �޾�, ������ �������� ���� ����ϱ� ���� Ŭ�����Դϴ�.  

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Sep. 2016
@helper ����
*/

/**�Է��� ���� ��ĳ�� Ŭ���� ����*/
import java.util.Scanner;
/**������ �޼ҵ带 ���� ���� Ŭ���� ����*/
import java.lang.Math;
public class wk03_java04_201415060 {
	/**
	main �Լ���  �� ���� ������ �Է� �޾�, ������ �������� ���� ����մϴ�.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**�Է��� ���� ��ĳ�� ��ü ����*/
		Scanner scan = new Scanner(System.in);
		/**�Է� ���� �� ������ ���� ����*/
		int num1, num2;
		
		/**�� 1 ���� �Է� ����*/
		System.out.print("Enter the first number: ");
		/**�� 1 ���� �Է�*/
		num1 = scan.nextInt();
		/**�� 2 ���� �Է� ����*/
		System.out.print("Enter the second number: ");
		/**�� 2 ���� �Է�*/
		num2 = scan.nextInt();
		
		/**�� ���� ������ �������� ���� ���*/
		System.out.println( (int)Math.pow(num1, 3)+(int)Math.pow(num2, 3) );
	}

}
