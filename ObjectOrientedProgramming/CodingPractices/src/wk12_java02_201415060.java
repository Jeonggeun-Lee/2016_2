/**
wk12_java02_201415060 클래스는  
고전 하노이 탑 퍼즐을 풀어서 재귀를 예시하기
위한 클래스입니다.
@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Dec. 2016
@helper 없음
*/

public class wk12_java02_201415060
{
	/**
	main 함수는
	하노이 탑 퍼즐을 만들고 풉
	니다.
	@param args: the command line arguments
	@return void
	*/
	
	public static void main (String[] args)
	{
		TowersOfHanoi towers = new TowersOfHanoi (4);
		towers.solve();
	}
}

/**하노이 탑 클래스는 고전 하노이 타워 퍼즐을 표현합니다.
 * */

class TowersOfHanoi
{
   private int totalDisks;
   /**특정 수의 판을 가진 퍼즐을 설정*/
   public TowersOfHanoi (int disks)
   {
      totalDisks = disks;
   }
   /**퍼즐을 풀기 위해 탑을 옮기는 메소드에 최초 호출을 수행
    * 탑 2를 이용해 탑 1에서 탑 3으로 판을 옮김*/
   public void solve ()
   {
      moveTower (totalDisks, 1, 3, 2);
   }
   /**moveTower 메소드는 특정 수의 판을 하나의 탑에서 다른 탑으로 옮김
    * n-1개의 부분 판을 제 3의 기둥으로 옮기고 가장 큰 하나의 판을 목적 기둥으로 옮김
    * 다시 제 3의 기둥에 옮긴 n-1개의 판을 목적 기둥에 옮김
    * 기초 경우는 1개의 판만 있을 때.*/
   private void moveTower (int numDisks, int start, int end, int temp)
   {
      if (numDisks == 1)
         moveOneDisk (start, end);
      else
      {
         moveTower (numDisks-1, start, temp, end);
         moveOneDisk (start, end);
         moveTower (numDisks-1, temp, end, start);
      }
   }
   /**특정 출발 탑에서 특정 목적 탑으로 하나의 판을 옮기는 것을 알림을 인쇄*/
   private void moveOneDisk (int start, int end)
   {
      System.out.println ("Move one disk from " + start + " to " +
         end);
   }
}