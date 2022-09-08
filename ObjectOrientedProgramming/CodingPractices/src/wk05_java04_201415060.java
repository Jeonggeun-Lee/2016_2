/**
Num Ŭ������
������ ǥ��
�ϱ� ���� Ŭ�����Դϴ�.  

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
*/

class Num
{
	/**�� ���� ���� ����*/
	private int value;
	
	/**������ ���� �޼ҵ�. �Ű� ������ �ʱⰪ.*/
	public Num(int update)
	{
		/**�ʱⰪ�� �� ������ ����*/
		value = update;
	}
	
	/**�� ���� ���� �޼ҵ�. �Ű������� ���� ��*/
	public void setValue(int update)
	{
		/**�� ������ ���� �� ����*/
		value = update;
	}
	
	/**��ü�� ���ڿ��� �ٲٴ� ���� �޼ҵ�. ���� ���ڿ��� ��ȯ*/
	public String toString()
	{
		/***/
		return value + "";
	}
}

/**
ParameterModifier Ŭ������
���� �Ű������� ���� ������ Num �� ��ü �� ���� ���� �Ѳ����� ����ϰ�
���� ������ �� 1 Num�� ��ü�� ���� �ٲٰ� �� 2 Num �� ��ü�� ������ �ٸ� ��ü�� �����ϰ� �ϸ�
�� �� �ٽ� �� ������ ���
�ϱ� ���� Ŭ�����Դϴ�.

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
*/

class ParameterModifier
{
	/**���� �Ű������� ���� ������ Num�� ��ü 2���� �ٲٴ� �޼ҵ�*/
	public void changeValue(int f1, Num f2, Num f3)
	{
		/**���� �ٲٱ� �� ������ ��ü �� ���*/
		System.out.println("Before changing the values");
		/***/
		System.out.println("f1\tf2\tf3");
		/***/
		System.out.println(f1 + "\t" + f2 + "\t" + f3 );
		
		/**���� ������ 999 ����*/
		f1 = 999;
		/**�� 1 Num �� ��ü�� ���� 888�� ����*/
		f2.setValue(888);
		/**�� 2 Num �� ��ü�� ������ 777���� ������ Num���� ��ü�� ������ �ٲ�*/
		f3 = new Num(777);
		
		/**�ٲ� ���� ���*/
		System.out.println("After changing the values");
		/***/
		System.out.println("f1\tf2\tf3");
		/***/
		System.out.println(f1 + "\t" + f2 + "\t" + f3 );
	}
}

/**
wk05_java04_201415060 Ŭ������
���� ������ �� Num�� ��ü�� ����� �ʱ�ȭ �ϰ�
�� ���� ����� ��
Ư���� ���� ��ü�� �̿��� ���� �Ű������� �Ѳ����� �ٲٴ� �޼ҵ带 ȣ���ϰ�
ȣ�� �� ���� �Լ��� ���� �Ű� ������ ������ �� ��ü�� ���� ����ϱ�
���� Ŭ�����Դϴ�.

@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper ����
*/

public class wk05_java04_201415060 {
	/**
	main �Լ���
	���� ������ �� Num�� ��ü�� ����� �ʱ�ȭ �ϰ�
	�� ���� ����� ��
	Ư���� ���� ��ü�� �̿��� ���� �Ű������� �Ѳ����� �ٲٴ� �޼ҵ带 ȣ���ϰ�
	ȣ�� �� ���� �Լ��� ���� �Ű� ������ ������ �� ��ü�� ���� ���
	�մϴ�.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args)
	{
		/**Ư���� ������ ���� ��ü ����*/
		ParameterModifier modifier = new ParameterModifier();
		
		/**���� ���� ����� �ʱ�ȭ*/
		int a1 = 111;
		/**�� 1 Num ��ü ����*/
		Num a2 = new Num(222);
		/**�� 2 Num ��ü ����*/
		Num a3 = new Num(333);
		
		/**���� ��ü�� ���� �޼ҵ� ȣ�� �� ������ �� ��ü�� ��*/
		System.out.println("Before calling changeValues");
		/***/
		System.out.println("a1\ta2\ta3");
		/***/
		System.out.println(a1 + "\t" + a2 + "\t" + a3 );
		
		/**���� �޼ҵ� ȣ��*/
		modifier.changeValue(a1, a2, a3);
		
		/**���� �޼ҵ� ȣ�� �� ���ο��� ���� ������ �� ��ü�� �� ���*/
		System.out.println("After calling changeValues");
		/***/
		System.out.println("a1\ta2\ta3");
		/***/
		System.out.println(a1 + "\t" + a2 + "\t" + a3 );
		
	}

}
