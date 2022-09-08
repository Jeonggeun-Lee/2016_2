/**
wk07_java03_201415060 클래스는  
2차원 배열의 사용을 예시하기
위한 클래스입니다.
@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Nov. 2016
@helper 없음
*/

/**출력 소수점의 자릿수를 정하기 위한 DecimalFormat 도입*/
import java.text.DecimalFormat;

public class wk07_java03_201415060
{
	/**
	main 함수는
	조사한 점수의 각 행(소다)과 열(응답자)의 평균을 계산하고 인쇄합
	니다.
	@param args: the command line arguments
	@return void
	*/

   public static void main (String[] args)
   {	
	   /**3행 10열 점수 배열 초기화*/
      int[][] scores = { {3, 4, 5, 2, 1, 4, 3, 2, 4, 4},
                         {2, 4, 3, 4, 3, 3, 2, 1, 2, 2},
                         {3, 5, 4, 5, 5, 3, 2, 5, 5, 5},
                         {1, 1, 1, 3, 1, 2, 1, 3, 2, 4} };
      /**행, 열 갯수*/
      final int SODAS = scores.length;
      final int PEOPLE = scores[0].length;
      
      /**행과 열 원소들의 합을 저장하는 배열 생성*/
      int[] sodaSum = new int[SODAS];
      int[] personSum = new int[PEOPLE];
      
      /**행과 열 원소들을 배열에 더함*/
      for (int soda=0; soda < SODAS; soda++)
         for (int person=0; person < PEOPLE; person++)
         {
            sodaSum[soda] += scores[soda][person];
            personSum[person] += scores[soda][person];
         }
      /**소수점 이하 1 자리까지만 출력*/
      DecimalFormat fmt = new DecimalFormat ("0.#");
      /**평균들:*/
      System.out.println ("Averages:");
      /**행 평균 출력*/
      for (int soda=0; soda < SODAS; soda++)
         System.out.println ("Soda #" + (soda+1) + " = " + 
                    fmt.format ((float)sodaSum[soda]/PEOPLE));

      /**열 평균 출력*/
      for (int person=0; person < PEOPLE; person++)
         System.out.println ("Person #" + (person+1) + " = " + 
                    fmt.format ((float)personSum[person]/SODAS));
   }
}
