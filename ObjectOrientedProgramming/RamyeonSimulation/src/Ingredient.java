
/**
 * 요리의 재료 클래스.
 * @author 최중기
 * @version 1.0
 */
public class Ingredient 
{
	/**
	 * 요리의 재료 이름.
	 */
	private String name;
	/**
	 * 요리의 현재 상태.
	 */
	private String state = "normal";
	
	/**
	 * 재료의 이름을 설정한다.
	 * 여기서 한번 설정되면 변경되지 않는다.
	 * 재료의 상태는 normal로 고정되어있다.
	 * @param matName	재료의 이름.
	 */
	public Ingredient(String matName)
	{
		name = matName;
	}
	
	/**
	 * 이름뿐만 아니라 상태 또한 설정하는 생성자.
	 * 목표 재료에만 사용하는 것을 추천.
	 * @param matName	재료의 이름
	 * @param matState	재료의 상태
	 */
	public Ingredient(String matName, String matState)
	{
		name = matName;
		state = matState;
	}
	
	public String getName() { return name; }	//재료의 이름을 반환한다.
	public void setState(String s) { state = s; }	//재료의 상태를 설정한다.
	public String getState() { return state; }	//재료의 현재 상태를 반환한다.
	
	/**
	 * 현재 상태에 이름을 덧붙여서 반환한다.
	 */
	public String toString()
	{
		return state + " " + name;
	}
	
	/**
	 * 두 재료가 같은지 구별한다.
	 * 주로 목표 재료와 현재 추가된 재료가 같은 상태인지 판별하는 데에 사용한다.
	 * @param goal
	 * @return
	 */
	public boolean equals(Ingredient goal)
	{
		if( this.getState() == goal.getState() &&	//상태가 같고,
				this.getName() == goal.getName())	//이름도 같다면,
			return true;	//같은 재료인 것으로 구분.
		
		return false;	//그렇지 않으면 다르다.
	}
}
