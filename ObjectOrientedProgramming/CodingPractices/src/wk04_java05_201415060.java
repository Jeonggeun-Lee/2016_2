/**
wk04_java05_201415060 Ŭ������
�ݺ����� ����Ͽ� "*"�� " "�� ������ �ݺ� ����Ͽ� ���������� ����� �����
���� Ŭ�����Դϴ�.  

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
*/
/***/
import java.lang.Math;

public class wk04_java05_201415060
{
	/**
	main �Լ���
	�ݺ����� ����Ͽ� "*"�� " "�� ������ �ݺ� ����Ͽ� ���������� ����� ����ϴ�.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args)
	{
		/**������ �׸� ĵ���� ����, ���� ũ�� ���� ��� MAX_ROWS ����*/
		final int MAX_ROWS = 10;
		
		/**�� �̵� �ݺ��� row�� MAX_ROWS���� 1���� 1�� �����ϴ� ����*/
		for(int row = MAX_ROWS; row >= 1; row--)
		{
			/**�� �̵� �ݺ��� i�� 1���� MAX_ROWS���� 1�� �����ϴ� ����*/
			for(int i = 1; i <= MAX_ROWS; i++)
			{
				/**�� ���� �� �̵� �ݺ��� �̻��� �� "*" ���*/
				if(i >= row) System.out.print("*");
				/**�� ���� �� �̵� �ݺ��� �̸��� �� " * ���*/
				else System.out.print(" ");
			}
			
			/**�� ������ ���� ������ �̵�*/
			System.out.println();
		}
		/**�� �̵� �ݺ��� row�� 1���� MAX_ROWS/2���� 1�� �����ϴ� ����*/
		for(int row = 1; row <= MAX_ROWS/2; row++)
		{
			/**�� �̵� �ݺ��� i�� 1���� MAX_ROWS���� 1�� �����ϴ� ����*/
			for(int i = 1; i <= MAX_ROWS; i++)
			{	
				/**�� �̵� �ݺ��ڿ� MAX_ROWS�� ������ �Ÿ��� �� �̵� �ݺ��� ũ�� �̸��� �� "*" ���*/
				if( Math.abs( i-MAX_ROWS/2 ) < row ) System.out.print("*");
				/**�� �̵� �ݺ��ڿ� MAX_ROWS�� ������ �Ÿ��� �� �̵� �ݺ��� ũ�� �̻��� �� " " ���*/
				else System.out.print(" ");
			}
			/**�� ������ ���� ������ �̵�*/
			System.out.println();
		}
		
		/**�� �̵� �ݺ��� row��  MAX_ROWS/2+1���� MAX_ROWS 1�� �����ϴ� ����*/
		for(int row = MAX_ROWS/2 + 1; row <= MAX_ROWS; row++)
		{
			/**�� �̵� �ݺ��� i�� 1���� MAX_ROWS���� 1�� �����ϴ� ����*/
			for(int i = 1; i <= MAX_ROWS; i++)
			{	
				/**�� �̵� �ݺ��ڿ� MAX_ROWS�� ������ �Ÿ���
				 * MAX_ROWS�� �� �̵� �ݺ��� ���� ������ �� "*" ���*/
				if( Math.abs( i-MAX_ROWS/2 ) <= MAX_ROWS - row ) System.out.print("*");
				/**�� �̵� �ݺ��ڿ� MAX_ROWS�� ������ �Ÿ���
				 * MAX_ROWS�� �� �̵� �ݺ��� ���� �ʰ��� �� " " ���*/
				else System.out.print(" ");
			}
			/**�� ������ ���� ������ �̵�*/
			System.out.println();
		}
		
		/**�� �̵� �ݺ��� row�� 1���� MAX_ROWS���� 1�� �����ϴ� ����*/
		for(int row = 1; row <= MAX_ROWS; row++)
		{
			/**�� �̵� �ݺ��� i�� 1���� MAX_ROWS���� 1�� �����ϴ� ����*/
			for(int i = 1; i <= MAX_ROWS; i++)
			{
				/**�� ���� �ప �̻��̸� "*" ���*/
				if(i >= row) System.out.print("*");
				/**�� ���� �ప �̸��̸� " " ���*/
				else System.out.print(" ");
			}
			
			/**�� ������ ���� ������ �̵�*/
			System.out.println();
		}
		
		/**�� �̵� �ݺ��� row�� MAX_ROWS���� 1���� 1�� �����ϴ� ����*/
		for(int row = MAX_ROWS; row >= 1; row--)
		{
			/**�� �̵� �ݺ��� star�� 1���� row������ 1�� �����ϴ� ����*/
			for(int star = 1; star <= row; star++)
				/**"*"���*/
				System.out.print("*");
			
			/**�� ���� row���� �� ���� ������ �̵�*/
			System.out.println();
		}
	}	
}
