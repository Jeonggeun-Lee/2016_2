/**
wk04_java01_201415060 Ŭ������ 
������ �Է� �޾�
���� ������ ����ϰ�
�ڸ�Ʈ�� ���
�ϱ� ���� Ŭ�����Դϴ�.

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
*/

/**�Է��� ���� ��ĳ�� Ŭ���� ����*/
import java.util.Scanner;
public class wk04_java01_201415060
{

/**
main �Լ���
������ �Է� �޾�
���� ������ ����ϰ�
�ڸ�Ʈ�� ���
�մϴ�.
@param args: the command line arguments
@return void
*/
	
	public static void main(String[] args)
	{
		/**����, ���� ���� ���� ���� ����*/
		int grade, category;
		
		/**�Է��� ���� ��ĳ�� ��ü ����*/
		Scanner scan = new Scanner(System.in);
		
		/**���� �Է� ���� 0~100*/
		System.out.print("Enter a numeric grade (0 to 100): ");
		/**���� �Է�*/
		grade = scan.nextInt();
		
		/**���� ���� ��� 0~59, 60~69, 70~79, 80~89, 90~99, 100*/
		category = grade/10;
		
		/**���� ������ ���� �ٸ� �ڸ�Ʈ ���*/
		switch(category)
		{
		/***/
		case 10:
			/***/
			System.out.println("That grade is a perfect score. Well done.");
			/***/
			break;
		/***/
		case 9:
			/***/
			System.out.println("That grade is well above average. Excellent.");
			/***/
			break;
		/***/	
		case 8:
			/***/
			System.out.println("That grade is above average. Nice job.");
			/***/
			break;
		/***/
		case 7:
			/***/
			System.out.println("That grade is average.");
			/***/
			break;
		/***/
		case 6:
			/***/
			System.out.print("That grade is below average. Please see the");
			/***/
			System.out.println("instructor for assistance.");
			/***/
			break;
		/***/
		default:
			/***/
			System.out.println("That grade is not passing.");
		}
	}
}
