/**
wk11_java03_201415060 Ŭ������  
����� ���ܿ� ���� ���� ��� �帧�� ����ϴ� ���� �����ֱ�
���� Ŭ�����Դϴ�.
@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Nov. 2016
@helper ����
*/
import java.util.Random;
import java.io.*;

public class wk11_java03_201415060
{
	/**
	main �Լ���
	�� �ٷ� ������ �׽�Ʈ �ڷ��� ������ �����
	�� ���� 10���� 99���� ������ �������� ����
	�ϴ�.
	@param args: the command line arguments
	@return void
	*/
	public static void main (String[] args) throws IOException
	{
		/**��� ���� �ִ� ���� ����*/
		final int MAX = 10;
		/**�������� �ް� �μ��� ���� �����ϴ� ����*/
		int value;
		/**�μ��� ���� ����*/
		String file = "test.txt";

		/**���������� ������ ���� ��ü ����*/
		Random rand = new Random();

		/**���Ͼ��� ��ü ����*/
		FileWriter fw = new FileWriter (file);
		/**����Ŭ���� ��ü ����*/
		BufferedWriter bw = new BufferedWriter (fw);
		/**print, println ���� ������ �޼ҵ带 ���� �μ� Ŭ���� ��ü ����*/
		PrintWriter outFile = new PrintWriter (bw);

		/**10���� ���� �̵��ϴ� �ݺ���*/
		for (int line=1; line <= MAX; line++)
		{
			/**10���� ���� �̵��ϴ� �ݺ���*/
			for (int num=1; num <= MAX; num++)
			{
				/**10���� 99���� �������� ����*/
				value = rand.nextInt (90) + 10;
				/**���� ���Ͽ� �μ�*/
				outFile.print (value + "   ");
			}
			/**�� ���� �μ�*/
			outFile.println ();
		}
		/**��� ���� ����*/
		outFile.close();
		/**��� ���� ���� �Ϸ� ǥ��*/
		System.out.println ("Output file has been created - " + file);
	}
}
