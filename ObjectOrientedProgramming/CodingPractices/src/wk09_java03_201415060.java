/**
wk09_java03_201415060 Ŭ������  
����� ���� �ڷḦ ���������� �����ϴ� ���� ���� �ֱ�
���� Ŭ�����Դϴ�.
@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Nov. 2016
@helper ����
*/

/**FoodItem Ŭ������ ���Ĺ��� ǥ���մϴ�.
 * ���� ������ �����ֱ� ���� �Ļ�Ŭ������ �θ�� ����մϴ�.*/
class FoodItem
{
	final private int CALORIES_PER_GRAM = 9;
	private int fatGrams;
	protected int servings;
   
/**���Ĺ� ��ü�� �����ϰ� ���� �׷� ���� ���� ȸ���� ���ϴ� ������*/
	public FoodItem (int numFatGrams, int numServings)
	{
		fatGrams = numFatGrams;
		servings = numServings;
	}
   
/**���Ĺ��� �������� ��� Į�θ��� ����ϰ� ��ȯ�ϴ� �޼ҵ�*/
	private int calories()
	{
		return fatGrams * CALORIES_PER_GRAM;
	}
   
/**1ȸ �������� ���� Į�θ��� ����ϰ� ��ȯ�ϴ� �޼ҵ�*/
	public int caloriesPerServing()
	{
		return (calories() / servings);
	}
}

/**���� Ŭ������ ���ڸ� ǥ���ϰ� ���Ĺ� Ŭ������ �ڽ��Դϴ�.
 * ��ӿ� ���� ���� ������ ���� �ֱ� ���� ����մϴ�.*/
class Pizza extends FoodItem
{
	/**���� Ŭ������ ������. ������ ���� ����. ���� Ƚ���� ����. 8ȸ�� ����*/
	public Pizza (int fatGrams)
	{
		super (fatGrams, 8);
	}
}

public class wk09_java03_201415060
{
	/**
	main �Լ���
	���� ��ü�� �����ϰ� 1ȸ �������� Į�θ��� �μ���
	�ϴ�.
	@param args: the command line arguments
	@return void
	*/
	public static void main (String[] args)
	{
		Pizza special = new Pizza (275);

		System.out.println ("Calories per serving: " + special.caloriesPerServing());
	}
}
