
/**
 * �丮�ϴ� ���α׷��� �� �θ� Ŭ����.
 * ��Ȯ���� �丮�ϴ� �� �ʿ��� �� �� �������� �κ��� ����Ѵ�.
 * @author ���߱�
 * @version 1.0
 */
public class Cooking
{
	/**
	 * �غ�Ǿ��ִ� ��� ���.
	 * �� ��� ������ ��� ����� �ǹ��Ѵ�.
	 */
	private String[] preparedMat;
	/**
	 * �߰��� ��� ���.
	 * ���� ���� ������ �߰��� ��� ����� �ǹ��Ѵ�.
	 */
	private String[] addedMat;
	/**
	 * ��ǥ ��� ���.
	 * ���������� �ϼ��Ǿ���ϴ� ������ ���¸� �ǹ��Ѵ�.
	 * addedMat�� ���ؼ� ���� ���θ� �Ǵ��Ѵ�.
	 */
	private String[] goalMat;

	
	/**
	 * ��ᰡ ���� �� �� �߰�������� Ȯ���ϴ� �뵵.
	 * addedMat�� �����ϴ� �뵵�ε� �ַ� ���.
	 */
	private int addedNum = 0;
	
	/**
	 * ����� �Ѱ� ����.
	 * �� �迭�� ũ����� �����Ѵ�.
	 * ������ �ۿ����� �����Ű�� �� ��.
	 */
	private int matLimit;
	
	
	/**
	 * �غ�� ������ �޾ƿ´�. �ַ� ��� �߰���簡 � �����ϱ� ���� ���� ������ ����.
	 * @return �غ�Ǿ��ִ� ����.
	 */
	public String[] getPreparedMaterials()
	{
		return preparedMat;
	}
	
	/**
	 * �� Ŭ������ ������.
	 * ������ ������ �迭 ũ��, �׸��� �̸� �����Ǿ���� �ʿ䰡 �ִ� �� ������ �����Ѵ�.
	 * @param limit ������ �Ѱ� ������ �ǹ��Ѵ�. �غ�� ���� �������� ��¦ ũ���ϴ� �� ����.
	 * @param preparedMaterials �غ�� ������ ����� ����.
	 * @param goalMaterials ��ǥ�� �ϴ�, �߰��Ǿ���� ������ ���.
	 */
	public Cooking(int limit, String[] preparedMaterials, String[] goalMaterials)
	{
		matLimit = limit;
		preparedMat = new String[matLimit];
		addedMat = new String[matLimit];
		goalMat = new String[matLimit];
		
		//�غ�� ����� ��ǥ ������ ����.
		preparedMat = preparedMaterials;
		goalMat = goalMaterials;
	}
	
	/**
	 * ��Ḧ �߰��Ѵ�. �� �̹� �ִ� ���� �����Ѵ�.
	 * @param mat �߰��ϴ� ���
	 * @return ��� �߰��� ���� ����
	 */
	public boolean addMaterial(String mat)
	{
		for(int n = 0; n < matLimit; n++)	//addedMat�� ������ mat�� �ߺ��Ǿ��ִ��� �˻��Ѵ�.
		{
			if(addedMat[n] == null)	//�����ϴٰ� ����ִ� ��ġ�� ���� > �� �ڵ� ��������Ƿ� ã�� ���� ��츦 �ǹ�.
				break;
			
			if(addedMat[n] == mat)	//�̹� ��ġ�ϴ� ��ᰡ �ִ� ���.
				return false;	//��� �߰��� ������.
		}
		
		//ã�� ���ϸ� ��Ḧ �߰��Ѵ�.
		addedMat[addedNum] = mat;
		addedNum++;
		return true;	//���������� ��Ḧ �߰���.
	}
	
	/**
	 * ��Ḧ �����ϴ� �Լ�
	 * @param mat ������ ���
	 * @return ��� ���� ���� ����
	 */
	public boolean removeMaterial(String mat)
	{
		for(int n = 0; n < matLimit; n++)	//addedMat�� ������ mat�� ã�´�.
		{
			if(addedMat[n] == null)	//�����ϴٰ� ����ִ� ��ġ�� ���� > �� �ڵ� ��������Ƿ� ã�� ���� ä�� ��ȯ.
				return false;	//��� ���ſ� ����.
			
			if(addedMat[n] == mat)	//�� ��Ḧ ã��.
			{
				addedMat[n] = null;	//��Ḧ ����.
				
				//�ڿ� �ִ� ������ ��� �� ĭ�� �����. (ȥ���� ���� ����)
				int k;
				for(k = n; k < matLimit; k++)
				{
					addedMat[k] = addedMat[k+1];	//�ٷ� ���� ��Ḧ ���� ĭ���� ���ܿ´�.	

					if( addedMat[k+1] == null)	//���� ��ġ�� ����ִ� ���� ���� �� �ű� �ʿ� ����.
						break;
					//�� if���� �ڿ� ��ġ�� ������ ������ ���� null�� ä���� �ʿ䰡 �ֱ� �����̴�.
				}
				if( k == matLimit)	//���� ������ ������ ���ܿ� ���,
					addedMat[k] = null;	//������ ���� ������ ���ܿ����Ƿ� ������ ��ġ���� ������Ų��.
				addedNum--;	//�߰��� ��� ���� �ϳ� �پ��� �ȴ�.
				return true;	//���������� ��Ḧ ������.
			}
		}
		//�� ��Ḧ ã�� ���� ���.
		return false;
	}
	
	/**
	 * ��Ḧ �����ϴ� �Լ�.
	 * @param mat ������ ���
	 * @return ��ᰡ �����Ǿ����� ����
	 */
	public boolean trimMaterial(String mat)
	{
		switch(mat)	//��ῡ ���� ���� �� ���¸� �ٸ��� �ٲپ��ش�.
		{
		//��Ḧ ������ �ڿ��� break ��� return true�� �������� ��.
		}
		return false;
	}
	
	/**
	 * �丮�� �������Ѵ�.
	 * @return �丮�� ���� ����.
	 */
	protected boolean succeedCook()
	{
		for(int n = 0; n < matLimit; n++)
		{
			if( addedMat[n] != goalMat[n])	//�߰��� ���� ���� ��ǥ ������ �ٸ� ���.
				return false;	//�丮 ���и� �˸�.
		}
		//��� ��ġ�ϴ� ���
		return true;
	}

}
