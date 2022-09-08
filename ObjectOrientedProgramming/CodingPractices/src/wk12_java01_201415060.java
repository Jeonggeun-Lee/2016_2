/**
wk12_java01_201415060 클래스는  
미로 여행 문제를 푸는 재귀를 예시하기
위한 클래스입니다.
@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Dec. 2016
@helper 없음
*/
public class wk12_java01_201415060
{
	/**
	main 함수는
	미로를 새로 만들고 처음 모습을 인쇄하고 풀기를 시도하고 마지막 형태를 인쇄합
	니다.
	@param args: the command line arguments
	@return void
	*/
	public static void main (String[] args)
	{
		Maze labyrinth = new Maze();

		System.out.println (labyrinth);

		if (labyrinth.traverse (0, 0))
			System.out.println ("The maze was successfully traversed!");
		else
			System.out.println ("There is no possible path.");

		System.out.println (labyrinth);
	}
}
/**미로클래스는
 * 문자로 이루어진 미로를 표현합니다.
 * 목표는 왼쪽 위 구석에서 오른쪽 아래 구석으로 가는 것입니다.
 * 경로로 가능한 곳은 1로 표시합니다.
 * */
class Maze
{
   private final int TRIED = 3;
   private final int PATH = 7;

   private int[][] grid = { {1,1,1,0,1,1,0,0,0,1,1,1,1},
                            {1,0,1,1,1,0,1,1,1,1,0,0,1},
                            {0,0,0,0,1,0,1,0,1,0,1,0,0},
                            {1,1,1,0,1,1,1,0,1,0,1,1,1},
                            {1,0,1,0,0,0,0,1,1,1,0,0,1},
                            {1,0,1,1,1,1,1,1,0,1,1,1,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0},
                            {1,1,1,1,1,1,1,1,1,1,1,1,1} };
   /**traverse 메소드는
    * 미로를 재귀적으로 여행하기를 시도합니다.
    * 탐색을 시도한 위치에 특정 문자를 넣습니다.
    * 그 위치는 결국 탈출 경로의 일부가 됩니다.
    * */
   public boolean traverse (int row, int column)
   {
      boolean done = false;

      if (valid (row, column))
      {
    	  /**탐색을 시도한 위치를 표시*/
         grid[row][column] = TRIED;
         /**행과 열 위치가 목적지에 있다면*/
         if (row == grid.length-1 && column == grid[0].length-1)
        	 /**미로가 풀림을 표현. 반환할 참값을 저장*/
        	 done = true;
         else
         {
        	 /**현 위치의 아래 위치를 탐색. 이곳이 탈출 경로라면 참*/
            done = traverse (row+1, column);
            if (!done)
            	/**현 위치의 오른쪽 위치를 탐색. 이곳이 탈출 경로라면 참*/
            	done = traverse (row, column+1);
            if (!done)
            	/**현 위치의 왼쪽 위치를 탐색. 이곳이 탈출 경로라면 참*/
               done = traverse (row-1, column);
            if (!done)
            	/**현 위치의 위쪽 위치를 탐색. 이곳이 탈출 경로라면 참*/
               done = traverse (row, column-1);
         }
         
         /**이 위치가 탈출 경로라면 1로 표시*/
         if (done)
            grid[row][column] = PATH;
      }
      /**현재 메소드를 재귀 호출한 메소드에 참으로 반환하여 탈출 경로임을 알림*/
      return done;
   }
   
   /**특정 위치가 이동 가능한 곳인지 판단*/
   private boolean valid (int row, int column)
   {
      boolean result = false;
      
      /**미로 행렬 범위 안에 있는지 검사*/
      if (row >= 0 && row < grid.length && column >= 0 &&
         column < grid[row].length)
    	  
    	  /**위치가 막혔거나 이미 탐색한 곳이 아닌지 검사*/
         if (grid[row][column] == 1)
            result = true;

      return result;
   }
   
   /**미로를 문자열로 표현하여 반환*/
   public String toString ()
   {
      String result = "\n";

      for (int row = 0; row < grid.length; row++)
      {
         for (int column=0; column < grid[row].length; column++)
            result += grid[row][column] + "";
         result += "\n";
      }

      return result;
   }
}