
/**
 * �丮�ϴ� ���α׷��� �� �θ� Ŭ����.
 * ��Ȯ���� �丮�ϴ� �� �ʿ��� �� �� �������� �κ��� ����Ѵ�.
 * GUI�� �ش���� ����.
 * @author ���߱�
 * @version 2.1
 */
public class Cooking
{
	/**
	 * �غ�Ǿ��ִ� ��� ���.
	 * �� ��� ������ ��� ����� �ǹ��Ѵ�.
	 */
	private Ingredient[] preparedMat;
	/**
	 * �߰��� ��� ���.
	 * ���� ���� ������ �߰��� ��� ����� �ǹ��Ѵ�.
	 */
	private Ingredient[] addedMat;
	/**
	 * ��ǥ ��� ���.
	 * ���������� �ϼ��Ǿ���ϴ� ������ ���¸� �ǹ��Ѵ�.
	 * addedMat�� ���ؼ� ���� ���θ� �Ǵ��Ѵ�.
	 */
	private Ingredient[] goalMat;

	
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
	public Ingredient[] getPreparedMaterials()
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
	public Cooking(int limit, Ingredient[] preparedMaterials, Ingredient[] goalMaterials)
	{
		matLimit = limit;
		preparedMat = new Ingredient[matLimit];
		addedMat = new Ingredient[matLimit];
		goalMat = new Ingredient[matLimit];
		
		//�غ�� ����� ��ǥ ������ ����.
		preparedMat = preparedMaterials;
		goalMat = goalMaterials;
	}
	
	/**
	 * mat�� �߰��� ��ῡ �ִ��� Ȯ���ϴ� �Լ�
	 * @param mat
	 * @return �߰��� ��� ��Ͽ����� mat�� ��ȣ
	 */
	private int findIngredient(Ingredient mat)
	{
		for(int n = 0; n < matLimit; n++)	//addedMat�� ������ mat�� �̹� �ش��� ã�� ���� for��.
		{
			if(addedMat[n] == null)	//�����ϴٰ� ����ִ� ��ġ�� ���� > �� �ڵ� ��������Ƿ� ã�� ���� ��츦 �ǹ�.
				return -1;	//��Ḧ ã�� �������� �˸���.
			
			if(addedMat[n].equals(mat))	//�̹� ��ġ�ϴ� ��ᰡ �ִ� ���.
				return n;	//�ش� ����� ��ȣ�� ��ȯ���ش�..
		}
		
		return -1;
	}
	
	/**
	 * ��Ḧ �߰��Ѵ�. �� �̹� �ִ� ���� �����Ѵ�.
	 * @param mat �߰��ϴ� ���
	 * @return ��� �߰��� ��ȣ
	 */
	public int addIngredient(Ingredient mat)
	{
		if(findIngredient(mat) >= 0)	//���� �̹� ��ᰡ �߰��Ǿ��ִٸ�,
			return -1;	//��� �߰� ����!
		
		//ã�� ���ߴٸ� ��Ḧ �߰��Ѵ�.
		addedMat[addedNum] = mat;
		addedNum++;
		return addedNum - 1;	//��Ḧ �߰��ص� ��ġ�� ��ȯ�Ѵ�.
	}
	
	/**
	 * ��Ḧ �����ϴ� �Լ�
	 * @param mat ������ ���
	 * @return ��Ḧ ������ ��ȣ
	 */
	public int removeIngredient(Ingredient mat)
	{
		int matNum = findIngredient(mat);	//mat�� ã�Ƽ� ����.
		
		if( matNum == -1 )	//��Ḧ ã�� ���� ���,
			return -1;	//��� ����� ����.
		else	//ã�� ���
		{
			addedMat[matNum] = null;	//��Ḧ ����.
			
			//�ڿ� �ִ� ������ ��� �� ĭ�� �����. (ȥ���� ���� ����)
			int k;
			for(k = matNum; k < matLimit - 1; k++)
			{
				addedMat[k] = addedMat[k+1];	//�ٷ� ���� ��Ḧ ���� ĭ���� ���ܿ´�.	

				if( addedMat[k+1] == null)	//���� ��ġ�� ����ִ� ���� ���� �� �ű� �ʿ� ����.
					break;
				//�� if���� �ڿ� ��ġ�� ������ ������ ���� null�� ä���� �ʿ䰡 �ֱ� �����̴�.
			}
			
			if( k == matLimit)	//���� ������ ������ ���ܿ� ���,
				addedMat[k] = null;	//������ ���� ������ ���ܿ����Ƿ� ������ ��ġ�� ������Ų��.
			
			addedNum--;	//�߰��� ��� ���� �ϳ� �پ��� �ȴ�.
			return matNum;	//������ ����� ��ġ�� ��ȯ�Ѵ�.
		}
	}
	
	/**
	 * ��Ḧ �����ϴ� �Լ�.
	 * @param mat ������ ���
	 * @return ��ᰡ ���� ���� �ٲ� ����� ����
	 */
	public String trimIngredient(Ingredient mat)
	{
		if(mat.getState() != "normal")	//���� �ٵ������ ���� ��Ḹ �����Ѵ�.
			return mat.getState();
		
		switch(mat.getName())
		{
		//��Ḧ ������ �Ŀ��� return true�� �������� ��. (���������� �˸��� ����)
		case "mat1":
			mat.setState("trimmed");
			return "trimmed";
		}
		
		//switch���� �ش��ϴ� ��ᰡ ������ ���,
		return "normal";	//�����ϴ� ��ᰡ �ƴϾ����Ƿ� normal�� �״�� ��ȯ.
	}
	
	/**
	 * �丮�� �������Ѵ�.
	 * @return �丮�� ���� ����.
	 */
	protected boolean succeedCook()
	{
		//for(int n = 0; n < matLimit; n++)
		//{
		//	if( addedMat[n].equals(goalMat[n]) == false )	//�߰��� ���� ���� ��ǥ ������ �ٸ� ���.
		//		return false;	//�丮 ���и� �˸�.
		//}
		
		//������ �����ʹ� ������� ���� ���θ� üũ�Ѵ�.
		for(int i = 0; i < matLimit; i++)
		{
			if(goalMat[i] == null)	//��ǥ ��ᰡ matLimit���� ���� ���� �����Ƿ�
				break;	//�׷� ��� for���� �ߴ�.
			
			boolean check = false;	//��ġ�ϴ� ��ᰡ �ִ��� Ȯ���ϴ� �뵵.
			for(int j = 0; j < matLimit; j++)	//�߰��� ��Ḧ ��� Ȯ���ؼ� ��ǥ�� ��ġ�ϴ� ��ᰡ �ִ��� üũ.
			{
				if( addedMat[j] == null )	//���� ��ᰡ ���� ���
					break;	//�� for���� ����������.
				
				if( addedMat[j].equals(goalMat[i]) )	//�ϳ��� ��ᰡ ��ġ�Ѵٸ�,
					check = true;	//�ش� ��ǥ�� �޼�.
			}
			if( check == false )	//���� ��ġ�ϴ� ��ǥ�� �����ٸ�,
				return false;	//�丮 ����!
		}
		
		//��� ��ġ�ϴ� ���
		return true;
	}
	
	protected Ingredient[] getAddedMaterials()
	{
		return addedMat;
	}

}
