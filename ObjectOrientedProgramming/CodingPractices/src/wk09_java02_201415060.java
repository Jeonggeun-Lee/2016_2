/**
wk09_java02_201415060 Ŭ������  
�������� �޼ҵ��� ����� �����ֱ�
���� Ŭ�����Դϴ�.
@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Nov. 2016
@helper ����
*/

/**Thought Ŭ������ �ϳ��� ������ ǥ���մϴ�.
 * �θ� Ŭ�����μ� �Ļ�Ŭ������ �������� �޼ҵ��� ����� ���� �ݴϴ�.*/
class Thought
{
	/**�޼����� �μ��ϴ� �޼ҵ�*/

	public void message()
	{
		System.out.println ("I feel like I'm diagonally parked in a " + "parallel universe.");
	}
}

/**Advice Ŭ������ ��� ǥ���մϴ�.
 * �������� �޼ҵ��� ����� �����ֱ� ���� ����մϴ�.*/

class Advice extends Thought
{
	/**�޼����� ����ϴ� �޼ҵ�
	 *�θ� �޼ҵ带 ������*/
	public void message()
	{
		System.out.println ("Warning: Dates in calendar are closer " + "than they appear.");
/**��������� �θ� ������ �޼ҵ带 ȣ��*/
		super.message();
	}
}


public class wk09_java02_201415060
{
	
/**
main �Լ���
�� ��ü�� �����ϰ� ������ �޼��� �޼ҵ带 ȣ����
�ϴ�.
@param args: the command line arguments
@return void
*/
	public static void main (String[] args)
	{
		Thought parked = new Thought();
		Advice dates = new Advice();

		parked.message();
      /**�Ļ�Ŭ�������� �������� �޼ҵ��Դϴ�.*/
		dates.message();
	}
}
