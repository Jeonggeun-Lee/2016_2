/**
wk07_java05_201415060 클래스는  
1부터 100까지 총 100번 숫자를 뽑고 10으로 나눈 구간의 빈도수의 분포도를 보여주기
위한 클래스입니다.
@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Nov. 2016
@helper 없음
*/
public class wk07_java05_201415060 {
	/**
	main 함수는
	1부터 100까지 총 100번 숫자를 뽑고 10으로 나눈 구간의 빈도수의 분포도를 보여줍
	니다.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args)
	{
		/**구간 개수*/
		final int MAXRANGE = 10;
		/***/
		final int MINRANGE = 1;
		/**뽑는 횟수*/
		final int MAXCOUNT = 100;
		/**구간의 빈도를 저장할 배열 생성*/
		int[] array = new int[MAXRANGE];
		/**뽑는 숫자 저장 변수*/
		int inputnum;

		/**100번 뽑는 동안*/
		for(int count = 0; count<MAXCOUNT; count++)
		{
			/**뽑는 수를 저장*/
			inputnum = (int)(100*Math.random())+1;
			/**뽑은 수가 해당하는 구간의 빈도를 1 증가*/
			array[ (inputnum-1) /10]++;
		}
		/**빈도를 출력*/
		for(int count = MINRANGE-1; count<MAXRANGE; count++)
		{
			/***/
			System.out.print( (count*10+1)+"\t-\t"+((count+1)*10)+"\t|\t" );
			/***/
			for(int asterisk = 0; asterisk<array[count]; asterisk++)
			{
				/***/
				System.out.print("*");
			}
			/***/
			System.out.println();
		}
	}
}
