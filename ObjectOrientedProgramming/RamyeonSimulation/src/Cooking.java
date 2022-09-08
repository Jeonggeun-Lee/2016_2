
/**
 * 요리하는 프로그램들 중 부모 클래스.
 * 정확히는 요리하는 데 필요한 점 중 내부적인 부분을 담당한다.
 * GUI는 해당되지 않음.
 * @author 최중기
 * @version 2.1
 */
public class Cooking
{
	/**
	 * 준비되어있는 재료 목록.
	 * 즉 사용 가능한 재료 목록을 의미한다.
	 */
	private Ingredient[] preparedMat;
	/**
	 * 추가된 재료 목록.
	 * 손질 등이 끝나고 추가한 재료 목록을 의미한다.
	 */
	private Ingredient[] addedMat;
	/**
	 * 목표 재료 목록.
	 * 최종적으로 완성되어야하는 재료들의 상태를 의미한다.
	 * addedMat과 비교해서 성공 여부를 판단한다.
	 */
	private Ingredient[] goalMat;

	
	/**
	 * 재료가 현재 몇 개 추가됬는지를 확인하는 용도.
	 * addedMat에 접근하는 용도로도 주로 사용.
	 */
	private int addedNum = 0;
	
	/**
	 * 재료의 한계 개수.
	 * 위 배열의 크기들을 결정한다.
	 * 생성자 밖에서는 변경시키지 말 것.
	 */
	private int matLimit;
	
	
	/**
	 * 준비된 재료들을 받아온다. 주로 재료 추가라든가 등에 연계하기 위해 사용될 것으로 추정.
	 * @return 준비되어있는 재료들.
	 */
	public Ingredient[] getPreparedMaterials()
	{
		return preparedMat;
	}
	
	/**
	 * 이 클래스의 생성자.
	 * 재료들의 개수와 배열 크기, 그리고 미리 설정되어야할 필요가 있는 두 변수를 설정한다.
	 * @param limit 재료들의 한계 개수를 의미한다. 준비된 재료들 개수보다 살짝 크게하는 게 좋음.
	 * @param preparedMaterials 준비된 재료들의 목록을 설정.
	 * @param goalMaterials 목표로 하는, 추가되어야할 재료들의 목록.
	 */
	public Cooking(int limit, Ingredient[] preparedMaterials, Ingredient[] goalMaterials)
	{
		matLimit = limit;
		preparedMat = new Ingredient[matLimit];
		addedMat = new Ingredient[matLimit];
		goalMat = new Ingredient[matLimit];
		
		//준비된 재료들과 목표 재료들을 설정.
		preparedMat = preparedMaterials;
		goalMat = goalMaterials;
	}
	
	/**
	 * mat이 추가된 재료에 있는지 확인하는 함수
	 * @param mat
	 * @return 추가된 재료 목록에서의 mat의 번호
	 */
	private int findIngredient(Ingredient mat)
	{
		for(int n = 0; n < matLimit; n++)	//addedMat을 뒤져서 mat이 이미 잊는지 찾기 위한 for문.
		{
			if(addedMat[n] == null)	//접근하다가 비어있는 위치에 접근 > 그 뒤도 비어있으므로 찾지 못한 경우를 의미.
				return -1;	//재료를 찾지 못했음을 알린다.
			
			if(addedMat[n].equals(mat))	//이미 일치하는 재료가 있는 경우.
				return n;	//해당 재료의 번호를 반환해준다..
		}
		
		return -1;
	}
	
	/**
	 * 재료를 추가한다. 단 이미 있는 재료는 무시한다.
	 * @param mat 추가하는 재료
	 * @return 재료 추가된 번호
	 */
	public int addIngredient(Ingredient mat)
	{
		if(findIngredient(mat) >= 0)	//만약 이미 재료가 추가되어있다면,
			return -1;	//재료 추가 실패!
		
		//찾지 못했다면 재료를 추가한다.
		addedMat[addedNum] = mat;
		addedNum++;
		return addedNum - 1;	//재료를 추가해둔 위치를 반환한다.
	}
	
	/**
	 * 재료를 제거하는 함수
	 * @param mat 제거할 재료
	 * @return 재료를 제거한 번호
	 */
	public int removeIngredient(Ingredient mat)
	{
		int matNum = findIngredient(mat);	//mat을 찾아서 저장.
		
		if( matNum == -1 )	//재료를 찾지 못한 경우,
			return -1;	//재료 빼기는 실패.
		else	//찾은 경우
		{
			addedMat[matNum] = null;	//재료를 뺀다.
			
			//뒤에 있는 재료들을 모두 한 칸씩 땡긴다. (혼란을 막기 위함)
			int k;
			for(k = matNum; k < matLimit - 1; k++)
			{
				addedMat[k] = addedMat[k+1];	//바로 뒤의 재료를 앞의 칸으로 땡겨온다.	

				if( addedMat[k+1] == null)	//다음 위치가 비어있는 경우는 굳이 더 옮길 필요 없음.
					break;
				//위 if문이 뒤에 위치한 이유는 마지막 값은 null로 채워둘 필요가 있기 때문이다.
			}
			
			if( k == matLimit)	//만약 마지막 값까지 땡겨온 경우,
				addedMat[k] = null;	//마지막 값은 앞으로 땡겨왔으므로 마지막 위치는 삭제시킨다.
			
			addedNum--;	//추가된 재료 수가 하나 줄어들게 된다.
			return matNum;	//제거한 재료의 위치를 반환한다.
		}
	}
	
	/**
	 * 재료를 손질하는 함수.
	 * @param mat 손질할 재료
	 * @return 재료가 손질 이후 바뀐 재료의 상태
	 */
	public String trimIngredient(Ingredient mat)
	{
		if(mat.getState() != "normal")	//아직 다듬어지지 않은 재료만 변경한다.
			return mat.getState();
		
		switch(mat.getName())
		{
		//재료를 손질한 후에는 return true로 빠져나갈 것. (성공했음을 알리기 위함)
		case "mat1":
			mat.setState("trimmed");
			return "trimmed";
		}
		
		//switch문에 해당하는 재료가 없었던 경우,
		return "normal";	//손질하는 재료가 아니었으므로 normal을 그대로 반환.
	}
	
	/**
	 * 요리를 마무리한다.
	 * @return 요리의 성공 여부.
	 */
	protected boolean succeedCook()
	{
		//for(int n = 0; n < matLimit; n++)
		//{
		//	if( addedMat[n].equals(goalMat[n]) == false )	//추가된 재료와 실제 목표 재료들이 다른 경우.
		//		return false;	//요리 실패를 알림.
		//}
		
		//재료들의 순서와는 관계없이 성공 여부를 체크한다.
		for(int i = 0; i < matLimit; i++)
		{
			if(goalMat[i] == null)	//목표 재료가 matLimit보다 작을 수도 있으므로
				break;	//그런 경우 for문을 중단.
			
			boolean check = false;	//일치하는 재료가 있는지 확인하는 용도.
			for(int j = 0; j < matLimit; j++)	//추가된 재료를 모두 확인해서 목표와 일치하는 재료가 있는지 체크.
			{
				if( addedMat[j] == null )	//만약 재료가 없는 경우
					break;	//이 for문을 빠져나간다.
				
				if( addedMat[j].equals(goalMat[i]) )	//하나라도 재료가 일치한다면,
					check = true;	//해당 목표는 달성.
			}
			if( check == false )	//만약 일치하는 목표가 없었다면,
				return false;	//요리 실패!
		}
		
		//모두 일치하는 경우
		return true;
	}
	
	protected Ingredient[] getAddedMaterials()
	{
		return addedMat;
	}

}
