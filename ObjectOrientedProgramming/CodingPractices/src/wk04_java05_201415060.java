/**
wk04_java05_201415060 클래스는
반복문을 사용하여 "*"와 " "를 적절히 반복 출력하여 기하학적인 모양을 만들기
위한 클래스입니다.  

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/
/***/
import java.lang.Math;

public class wk04_java05_201415060
{
	/**
	main 함수는
	반복문을 사용하여 "*"와 " "를 적절히 반복 출력하여 기하학적인 모양을 만듭니다.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args)
	{
		/**도형을 그릴 캔버스 가로, 세로 크기 저장 상수 MAX_ROWS 선언*/
		final int MAX_ROWS = 10;
		
		/**행 이동 반복자 row가 MAX_ROWS에서 1까지 1씩 감소하는 동안*/
		for(int row = MAX_ROWS; row >= 1; row--)
		{
			/**열 이동 반복자 i가 1에서 MAX_ROWS까지 1씩 증가하는 동안*/
			for(int i = 1; i <= MAX_ROWS; i++)
			{
				/**열 값이 행 이동 반복자 이상일 때 "*" 출력*/
				if(i >= row) System.out.print("*");
				/**열 값이 행 이동 반복자 미만일 때 " * 출력*/
				else System.out.print(" ");
			}
			
			/**행 끝에서 다음 행으로 이동*/
			System.out.println();
		}
		/**행 이동 반복자 row가 1에서 MAX_ROWS/2까지 1씩 증가하는 동안*/
		for(int row = 1; row <= MAX_ROWS/2; row++)
		{
			/**열 이동 반복자 i가 1에서 MAX_ROWS까지 1씩 증가하는 동안*/
			for(int i = 1; i <= MAX_ROWS; i++)
			{	
				/**열 이동 반복자와 MAX_ROWS의 절반의 거리가 행 이동 반복자 크기 미만일 때 "*" 출력*/
				if( Math.abs( i-MAX_ROWS/2 ) < row ) System.out.print("*");
				/**열 이동 반복자와 MAX_ROWS의 절반의 거리가 행 이동 반복자 크기 이상일 때 " " 출력*/
				else System.out.print(" ");
			}
			/**행 끝에서 다음 행으로 이동*/
			System.out.println();
		}
		
		/**행 이동 반복자 row가  MAX_ROWS/2+1에서 MAX_ROWS 1씩 증가하는 동안*/
		for(int row = MAX_ROWS/2 + 1; row <= MAX_ROWS; row++)
		{
			/**열 이동 반복자 i가 1에서 MAX_ROWS까지 1씩 증가하는 동안*/
			for(int i = 1; i <= MAX_ROWS; i++)
			{	
				/**열 이동 반복자와 MAX_ROWS의 절반의 거리가
				 * MAX_ROWS와 행 이동 반복자 차이 이하일 때 "*" 출력*/
				if( Math.abs( i-MAX_ROWS/2 ) <= MAX_ROWS - row ) System.out.print("*");
				/**열 이동 반복자와 MAX_ROWS의 절반의 거리가
				 * MAX_ROWS와 행 이동 반복자 차이 초과일 때 " " 출력*/
				else System.out.print(" ");
			}
			/**행 끝에서 다음 행으로 이동*/
			System.out.println();
		}
		
		/**행 이동 반복자 row가 1에서 MAX_ROWS까지 1씩 증가하는 동안*/
		for(int row = 1; row <= MAX_ROWS; row++)
		{
			/**열 이동 반복자 i가 1에서 MAX_ROWS까지 1씩 증가하는 동안*/
			for(int i = 1; i <= MAX_ROWS; i++)
			{
				/**열 값이 행값 이상이면 "*" 출력*/
				if(i >= row) System.out.print("*");
				/**열 값이 행값 미만이면 " " 출력*/
				else System.out.print(" ");
			}
			
			/**행 끝에서 다음 행으로 이동*/
			System.out.println();
		}
		
		/**행 이동 반복자 row가 MAX_ROWS에서 1까지 1씩 감소하는 동안*/
		for(int row = MAX_ROWS; row >= 1; row--)
		{
			/**열 이동 반복자 star가 1에서 row값까지 1씩 증가하는 동안*/
			for(int star = 1; star <= row; star++)
				/**"*"출력*/
				System.out.print("*");
			
			/**열 값이 row값일 때 다음 행으로 이동*/
			System.out.println();
		}
	}	
}
