/**
wk04_java06_201415060 클래스는
파일 두 개를 한 줄씩 비교하여 차이가 있는 줄을 출력
하기 위한 클래스입니다.

@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Oct. 2016
@helper 없음
*/

/**입력을 위한 스캐너 클래스 도입*/
import java.util.Scanner;
/**입출력 예외를 던지기 위한 입출력 클래스 도입*/
import java.io.*;


public class wk04_java06_201415060 {
	/**
	main 함수는
	파일 두 개를 한 줄씩 비교하여 차이가 있는 줄을 출력
	합니다.
	@param args: the command line arguments
	@return void
	*/
	public static void main(String[] args) {
		/**각 파일의 한 줄을 저장하는 문자열 객체 참조 선언*/
		String line1 = "", line2 = "";
		
		/**파일이 찾기나 열기 실패 검사 시작*/
		try{
			/**파일 스캐너 참조 선언*/
			Scanner fileScan1, fileScan2;
			/**제 1 파일 스캐너 객체 생성*/
			fileScan1 = new Scanner( new File("in1.txt") );
			/**제 2 파일 스캐너 객체 생성*/
			fileScan2 = new Scanner( new File("in2.txt") );
		
			/**줄 반복자 선언과 초기화*/
			int lineIterator = 0;
			/**제 1 파일 또는 제 2 파일에 읽을 문자열이 있는 동안*/
			while( fileScan1.hasNext() || fileScan2.hasNext()){
				/**줄 반복자를 1씩 증가시키면서*/
				lineIterator++;
				/**제 1 파일에서 한 줄을 입력*/
				line1 = fileScan1.nextLine();
				/**제 2 파일에서 한 줄을 입력*/
				line2 = fileScan2.nextLine();
				/**제 1 파일과 제 2 파일이 다르면*/
				if( !line1.equals(line2) ){
					/**다른 줄의 파일에서의 위치를 출력하고*/
					System.out.println("- line "+ lineIterator +" in \"in1.txt\" and \"in2.txt\" ");
					/**제 1 파일의 한 줄 출력*/
					System.out.println(line1);
					/**제 2 파일의 한 줄 출력*/
					System.out.println(line2);
				}
			}
		
		}
		/**예외 받기*/
		catch(FileNotFoundException e){
			/**예외 메세지 출력*/	
			e.printStackTrace();
		}
	}
}
