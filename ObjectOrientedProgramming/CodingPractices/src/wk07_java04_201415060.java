/**
wk07_java04_201415060 Ŭ������  
0�̻� 50������ �� 10���� �Է� �޾� �Է��� ���� ������ ����ϱ�
���� Ŭ�����Դϴ�.
@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Nov. 2016
@helper ����
*/

/**�� �Է��� ���� ��ĳ�� Ŭ���� ����*/
import java.util.Scanner;
public class wk07_java04_201415060 {

/**
main �Լ���
0�̻� 50������ �� 10���� �Է� �޾� �Է��� ���� ������ �����
�ϴ�.
@param args: the command line arguments
@return void
*/
	
	public static void main(String[] args)
	{
		/**�ִ� �Է� ����*/
		final int MAXRANGE = 50;
		/**�ּ� �Է� ����*/
		final int MINRANGE = 0;
		/**�Է� ����*/
		final int MAXCOUNT = 10;
		/**�Է°� ���� �迭*/
		int[] array = new int[MAXRANGE+1];
		/**�Է� �� ���� ����*/
		int inputnum;
		/**�� �Է��� ���� ��ĳ�� ��ü ����*/
		Scanner scan = new Scanner(System.in);
		/**�Է� ���� ��ŭ ���� �ݺ�*/
		for(int count = 0; count<MAXCOUNT; count++)
		{
			/**0���� 50���� �� �Է� ����*/
			System.out.print(count+1+". Enter the number(0 to 50): ");
			/**���� �Է�*/
			inputnum = scan.nextInt();
			/**�ش� ������ �迭 ���� 1 ����*/
			array[inputnum]++;
		}
		/**�ּҿ��� �ִ� �������� �Է� ���� ���� �󵵸� ���*/
		for(int count = MINRANGE; count<=MAXRANGE; count++)
		{
			/***/
			if(array[count]>=1) System.out.println(count+" ; "+array[count]);
		}
	}
}
