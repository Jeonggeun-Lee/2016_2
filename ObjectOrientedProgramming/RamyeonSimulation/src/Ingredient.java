
/**
 * �丮�� ��� Ŭ����.
 * @author ���߱�
 * @version 1.0
 */
public class Ingredient 
{
	/**
	 * �丮�� ��� �̸�.
	 */
	private String name;
	/**
	 * �丮�� ���� ����.
	 */
	private String state = "normal";
	
	/**
	 * ����� �̸��� �����Ѵ�.
	 * ���⼭ �ѹ� �����Ǹ� ������� �ʴ´�.
	 * ����� ���´� normal�� �����Ǿ��ִ�.
	 * @param matName	����� �̸�.
	 */
	public Ingredient(String matName)
	{
		name = matName;
	}
	
	/**
	 * �̸��Ӹ� �ƴ϶� ���� ���� �����ϴ� ������.
	 * ��ǥ ��ῡ�� ����ϴ� ���� ��õ.
	 * @param matName	����� �̸�
	 * @param matState	����� ����
	 */
	public Ingredient(String matName, String matState)
	{
		name = matName;
		state = matState;
	}
	
	public String getName() { return name; }	//����� �̸��� ��ȯ�Ѵ�.
	public void setState(String s) { state = s; }	//����� ���¸� �����Ѵ�.
	public String getState() { return state; }	//����� ���� ���¸� ��ȯ�Ѵ�.
	
	/**
	 * ���� ���¿� �̸��� ���ٿ��� ��ȯ�Ѵ�.
	 */
	public String toString()
	{
		return state + " " + name;
	}
	
	/**
	 * �� ��ᰡ ������ �����Ѵ�.
	 * �ַ� ��ǥ ���� ���� �߰��� ��ᰡ ���� �������� �Ǻ��ϴ� ���� ����Ѵ�.
	 * @param goal
	 * @return
	 */
	public boolean equals(Ingredient goal)
	{
		if( this.getState() == goal.getState() &&	//���°� ����,
				this.getName() == goal.getName())	//�̸��� ���ٸ�,
			return true;	//���� ����� ������ ����.
		
		return false;	//�׷��� ������ �ٸ���.
	}
}
