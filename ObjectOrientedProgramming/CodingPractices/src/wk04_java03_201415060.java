/**
wk04_java03_201415060 Ŭ������ ������ �Է¹޾� �������� �Ǵ��ϱ� ���� Ŭ�����Դϴ�.  

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
*/

/**�Է��� ���� ��ĳ�� Ŭ���� ����*/
import java.util.Scanner;

public class wk04_java03_201415060 {
	/**
	main �Լ��� ������ �Է¹޾� �������� �Ǵ��մϴ�.
	@param args: the command line arguments
	@return void
	*/
	
	public static void main(String[] args)
	{
		/**�Է��� ���� ��ĳ�� ��ü ����*/
		Scanner scan = new Scanner(System.in);
		/**������ �����ϴ� ���� ����� �ʱ�ȭ*/
		int year = 0;
		
		/**���� �Է��� ����*/
		System.out.print("Enter the year: ");
		/**���� �Է�*/
		year = scan.nextInt();
		
		/**������ 400���� ������*/
		if( year%400==0){
			/**�������� ���*/
			System.out.println(year + " is a leap year.");
		}
		/**������ 400���� ������ �ʰ� 100���� ������*/
		else if( year%100==0){
			/**������ �ƴ��� ���*/
			System.out.println(year + " is not a leap year.");
		}
		/**������ 400���� ������ �ʰ� 100���� ������ �ʰ� 4�� ������*/
		else if( year%4==0){
			/**�������� ���*/
			System.out.println(year + " is a leap year.");
		}
		/**� ��쵵 �ƴϸ�*/
		else {
			/**������ �ƴ��� ���*/
			System.out.println(year + " is not a leap year.");
		}
	}
}
