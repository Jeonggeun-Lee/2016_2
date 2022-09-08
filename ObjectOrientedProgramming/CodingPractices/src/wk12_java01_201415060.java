/**
wk12_java01_201415060 Ŭ������  
�̷� ���� ������ Ǫ�� ��͸� �����ϱ�
���� Ŭ�����Դϴ�.
@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Dec. 2016
@helper ����
*/
public class wk12_java01_201415060
{
	/**
	main �Լ���
	�̷θ� ���� ����� ó�� ����� �μ��ϰ� Ǯ�⸦ �õ��ϰ� ������ ���¸� �μ���
	�ϴ�.
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
/**�̷�Ŭ������
 * ���ڷ� �̷���� �̷θ� ǥ���մϴ�.
 * ��ǥ�� ���� �� �������� ������ �Ʒ� �������� ���� ���Դϴ�.
 * ��η� ������ ���� 1�� ǥ���մϴ�.
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
   /**traverse �޼ҵ��
    * �̷θ� ��������� �����ϱ⸦ �õ��մϴ�.
    * Ž���� �õ��� ��ġ�� Ư�� ���ڸ� �ֽ��ϴ�.
    * �� ��ġ�� �ᱹ Ż�� ����� �Ϻΰ� �˴ϴ�.
    * */
   public boolean traverse (int row, int column)
   {
      boolean done = false;

      if (valid (row, column))
      {
    	  /**Ž���� �õ��� ��ġ�� ǥ��*/
         grid[row][column] = TRIED;
         /**��� �� ��ġ�� �������� �ִٸ�*/
         if (row == grid.length-1 && column == grid[0].length-1)
        	 /**�̷ΰ� Ǯ���� ǥ��. ��ȯ�� ������ ����*/
        	 done = true;
         else
         {
        	 /**�� ��ġ�� �Ʒ� ��ġ�� Ž��. �̰��� Ż�� ��ζ�� ��*/
            done = traverse (row+1, column);
            if (!done)
            	/**�� ��ġ�� ������ ��ġ�� Ž��. �̰��� Ż�� ��ζ�� ��*/
            	done = traverse (row, column+1);
            if (!done)
            	/**�� ��ġ�� ���� ��ġ�� Ž��. �̰��� Ż�� ��ζ�� ��*/
               done = traverse (row-1, column);
            if (!done)
            	/**�� ��ġ�� ���� ��ġ�� Ž��. �̰��� Ż�� ��ζ�� ��*/
               done = traverse (row, column-1);
         }
         
         /**�� ��ġ�� Ż�� ��ζ�� 1�� ǥ��*/
         if (done)
            grid[row][column] = PATH;
      }
      /**���� �޼ҵ带 ��� ȣ���� �޼ҵ忡 ������ ��ȯ�Ͽ� Ż�� ������� �˸�*/
      return done;
   }
   
   /**Ư�� ��ġ�� �̵� ������ ������ �Ǵ�*/
   private boolean valid (int row, int column)
   {
      boolean result = false;
      
      /**�̷� ��� ���� �ȿ� �ִ��� �˻�*/
      if (row >= 0 && row < grid.length && column >= 0 &&
         column < grid[row].length)
    	  
    	  /**��ġ�� �����ų� �̹� Ž���� ���� �ƴ��� �˻�*/
         if (grid[row][column] == 1)
            result = true;

      return result;
   }
   
   /**�̷θ� ���ڿ��� ǥ���Ͽ� ��ȯ*/
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