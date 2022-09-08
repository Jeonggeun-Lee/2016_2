/**
wk07_java03_201415060 Ŭ������  
2���� �迭�� ����� �����ϱ�
���� Ŭ�����Դϴ�.
@author 201415060 ������(nalbojima@daum.net)
@version 1.0 Nov. 2016
@helper ����
*/

/**��� �Ҽ����� �ڸ����� ���ϱ� ���� DecimalFormat ����*/
import java.text.DecimalFormat;

public class wk07_java03_201415060
{
	/**
	main �Լ���
	������ ������ �� ��(�Ҵ�)�� ��(������)�� ����� ����ϰ� �μ���
	�ϴ�.
	@param args: the command line arguments
	@return void
	*/

   public static void main (String[] args)
   {	
	   /**3�� 10�� ���� �迭 �ʱ�ȭ*/
      int[][] scores = { {3, 4, 5, 2, 1, 4, 3, 2, 4, 4},
                         {2, 4, 3, 4, 3, 3, 2, 1, 2, 2},
                         {3, 5, 4, 5, 5, 3, 2, 5, 5, 5},
                         {1, 1, 1, 3, 1, 2, 1, 3, 2, 4} };
      /**��, �� ����*/
      final int SODAS = scores.length;
      final int PEOPLE = scores[0].length;
      
      /**��� �� ���ҵ��� ���� �����ϴ� �迭 ����*/
      int[] sodaSum = new int[SODAS];
      int[] personSum = new int[PEOPLE];
      
      /**��� �� ���ҵ��� �迭�� ����*/
      for (int soda=0; soda < SODAS; soda++)
         for (int person=0; person < PEOPLE; person++)
         {
            sodaSum[soda] += scores[soda][person];
            personSum[person] += scores[soda][person];
         }
      /**�Ҽ��� ���� 1 �ڸ������� ���*/
      DecimalFormat fmt = new DecimalFormat ("0.#");
      /**��յ�:*/
      System.out.println ("Averages:");
      /**�� ��� ���*/
      for (int soda=0; soda < SODAS; soda++)
         System.out.println ("Soda #" + (soda+1) + " = " + 
                    fmt.format ((float)sodaSum[soda]/PEOPLE));

      /**�� ��� ���*/
      for (int person=0; person < PEOPLE; person++)
         System.out.println ("Person #" + (person+1) + " = " + 
                    fmt.format ((float)personSum[person]/SODAS));
   }
}
