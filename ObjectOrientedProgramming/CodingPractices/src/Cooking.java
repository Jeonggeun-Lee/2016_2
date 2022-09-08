
/**
 * 요리하는 프로그램들 중 부모 클래스.
 * 정확히는 요리하는 데 필요한 점 중 내부적인 부분을 담당한다.
 * @author 최중기
 * @version 1.0
 */
public class Cooking
{
	/**
	 * 준비되어있는 재료 목록.
	 * 즉 사용 가능한 재료 목록을 의미한다.
	 */
	private String[] preparedMat;
	/**
	 * 추가된 재료 목록.
	 * 손질 등이 끝나고 추가한 재료 목록을 의미한다.
	 */
	private String[] addedMat;
	/**
	 * 목표 재료 목록.
	 * 최종적으로 완성되어야하는 재료들의 상태를 의미한다.
	 * addedMat과 비교해서 성공 여부를 판단한다.
	 */
	private String[] goalMat;

	
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
	public String[] getPreparedMaterials()
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
	public Cooking(int limit, String[] preparedMaterials, String[] goalMaterials)
	{
		matLimit = limit;
		preparedMat = new String[matLimit];
		addedMat = new String[matLimit];
		goalMat = new String[matLimit];
		
		//준비된 재료들과 목표 재료들을 설정.
		preparedMat = preparedMaterials;
		goalMat = goalMaterials;
	}
	
	/**
	 * 재료를 추가한다. 단 이미 있는 재료는 무시한다.
	 * @param mat 추가하는 재료
	 * @return 재료 추가의 성공 여부
	 */
	public boolean addMaterial(String mat)
	{
		for(int n = 0; n < matLimit; n++)	//addedMat을 뒤져서 mat이 중복되어있는지 검사한다.
		{
			if(addedMat[n] == null)	//접근하다가 비어있는 위치에 접근 > 그 뒤도 비어있으므로 찾지 못한 경우를 의미.
				break;
			
			if(addedMat[n] == mat)	//이미 일치하는 재료가 있는 경우.
				return false;	//재료 추가에 실패함.
		}
		
		//찾지 못하면 재료를 추가한다.
		addedMat[addedNum] = mat;
		addedNum++;
		return true;	//성공적으로 재료를 추가함.
	}
	
	/**
	 * 재료를 제거하는 함수
	 * @param mat 제거할 재료
	 * @return 재료 제거 성공 여부
	 */
	public boolean removeMaterial(String mat)
	{
		for(int n = 0; n < matLimit; n++)	//addedMat을 뒤져서 mat을 찾는다.
		{
			if(addedMat[n] == null)	//접근하다가 비어있는 위치에 접근 > 그 뒤도 비어있으므로 찾지 못한 채로 반환.
				return false;	//재료 제거에 실패.
			
			if(addedMat[n] == mat)	//뺄 재료를 찾음.
			{
				addedMat[n] = null;	//재료를 뺀다.
				
				//뒤에 있는 재료들을 모두 한 칸씩 땡긴다. (혼란을 막기 위함)
				int k;
				for(k = n; k < matLimit; k++)
				{
					addedMat[k] = addedMat[k+1];	//바로 뒤의 재료를 앞의 칸으로 땡겨온다.	

					if( addedMat[k+1] == null)	//다음 위치가 비어있는 경우는 굳이 더 옮길 필요 없음.
						break;
					//위 if문이 뒤에 위치한 이유는 마지막 값은 null로 채워둘 필요가 있기 때문이다.
				}
				if( k == matLimit)	//만약 마지막 값까지 땡겨온 경우,
					addedMat[k] = null;	//마지막 값은 앞으로 땡겨왔으므로 마지막 위치에서 삭제시킨다.
				addedNum--;	//추가된 재료 수가 하나 줄어들게 된다.
				return true;	//성공적으로 재료를 제거함.
			}
		}
		//뺄 재료를 찾지 못한 경우.
		return false;
	}
	
	/**
	 * 재료를 손질하는 함수.
	 * @param mat 손질할 재료
	 * @return 재료가 손질되었는지 여부
	 */
	public boolean trimMaterial(String mat)
	{
		switch(mat)	//재료에 따라 손질 후 상태를 다르게 바꾸어준다.
		{
		//재료를 손질한 뒤에는 break 대신 return true로 빠져나갈 것.
		}
		return false;
	}
	
	/**
	 * 요리를 마무리한다.
	 * @return 요리의 성공 여부.
	 */
	protected boolean succeedCook()
	{
		for(int n = 0; n < matLimit; n++)
		{
			if( addedMat[n] != goalMat[n])	//추가된 재료와 실제 목표 재료들이 다른 경우.
				return false;	//요리 실패를 알림.
		}
		//모두 일치하는 경우
		return true;
	}

}
