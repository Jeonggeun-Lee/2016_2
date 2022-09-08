/**
wk07_java05_201415060 Ŭ������  
1���� 100���� �� 100�� ���ڸ� �̰� 10���� ���� ������ �󵵼��� �������� �����ֱ�
���� Ŭ�����Դϴ�.
@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Nov. 2016
@helper ����
*/
public class wk07_java05_201415060 {
	/**
	main �Լ���
	1���� 100���� �� 100�� ���ڸ� �̰� 10���� ���� ������ �󵵼��� �������� ������
	�ϴ�.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args)
	{
		/**���� ����*/
		final int MAXRANGE = 10;
		/***/
		final int MINRANGE = 1;
		/**�̴� Ƚ��*/
		final int MAXCOUNT = 100;
		/**������ �󵵸� ������ �迭 ����*/
		int[] array = new int[MAXRANGE];
		/**�̴� ���� ���� ����*/
		int inputnum;

		/**100�� �̴� ����*/
		for(int count = 0; count<MAXCOUNT; count++)
		{
			/**�̴� ���� ����*/
			inputnum = (int)(100*Math.random())+1;
			/**���� ���� �ش��ϴ� ������ �󵵸� 1 ����*/
			array[ (inputnum-1) /10]++;
		}
		/**�󵵸� ���*/
		for(int count = MINRANGE-1; count<MAXRANGE; count++)
		{
			/***/
			System.out.print( (count*10+1)+"\t-\t"+((count+1)*10)+"\t|\t" );
			/***/
			for(int asterisk = 0; asterisk<array[count]; asterisk++)
			{
				/***/
				System.out.print("*");
			}
			/***/
			System.out.println();
		}
	}
}
