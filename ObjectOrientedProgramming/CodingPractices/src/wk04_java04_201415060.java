/**
wk01_java01_201415060 Ŭ������ 1~100 ������ ������ ���� ���ߴ� ������ ���� Ŭ�����Դϴ�.  

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
*/

/**�Է��� ���� ��ĳ�� Ŭ���� ����*/
import java.util.Scanner;
/**���������� ���� ������ Ŭ���� ����*/
import java.util.Random;

public class wk04_java04_201415060 {
	/**
	main �Լ��� 1~100 ������ ������ ���� ���ߴ� ������ �մϴ�.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args){
		/**�Է��� ���� ��ĳ�� ��ü ����*/
		Scanner scan = new Scanner(System.in);
		/**����ڰ� �Է��ϴ� ���� ��ǻ�Ͱ� ���� ������ ���� ������ ������ ����� �ʱ�ȭ*/
		int num = 0, com = 0;
		/**����ڰ� ������ ����� �ǻ縦 �����ϴ� ���ڿ� ���� ����� �ʱ�ȭ*/
		String str = "Yes";
		/**������ ���� ���� ������ ��ü ����*/
		Random random = new Random();
		
		/**����� �ǻ簡 "Yes"�� ����*/
		while(str.equals("Yes")){
			/**1~100 ������ ���� �Է� ����, 0 �Է� �� ����*/
			System.out.print("Enter a number(1 to 100, 0 for quit): ");
			/**���� �Է�*/
			num = scan.nextInt();
			
			/**�Է��� ���� ������ �����*/
			if( (num<0)||(num>100)){
				/**������ ����� �˸�*/
				System.out.println(num + " is out of range.");
				/**�ݺ��� ������ �˻�*/
				continue;
			}
			
			/**0�� �Է��ϸ�*/
			else if (num == 0)
			{
				/**���Ḧ ���������� �˸�*/
				System.out.println("You choosed to quit.");
				/**������� �ٽ� Ȯ��*/
				System.out.print("Do you want to continue?(Yes/No): ");
				/**�ǻ縦 �Է�*/
				str = scan.next();
				/**�ݺ��� ������ �˻�*/
				continue;
			}
			
			/**1~100�� ������ ���� ����*/
			com = random.nextInt(100)+1;
			/**�Է��� ���� ������ ���� ������*/
			if(num==com)
			{
				/**���� ������ ���*/
				System.out.println( num + " is the correct number.");
			}
			/**�Է��� ���� ������������ ũ��*/
			else if(num>com)
			{
				/**�Է��� ���� �� ŭ�� �˸�*/
				System.out.println( num + " is higher than the number.");
			}
			/**�Է��� ���� ������������ ������*/
			else
			{
				/**�Է��� ���� �� ������ �˸�*/
				System.out.println( num + " is lower than the number.");
			}
		}
		/**������ ������ �˸�*/
		System.out.println("You choosed to stop.");
	}
}
