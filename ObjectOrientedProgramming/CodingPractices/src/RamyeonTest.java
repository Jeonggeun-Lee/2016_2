/**
 * 라면 끓이기 실행 테스트 클래스
 * @author 이정근
 * @version 1.0
 */

public class RamyeonTest {

	public static void main(String[] args)
	{
		/**라면 객체 생성*/
		Ramyeon ramyeon = new Ramyeon();
		
		/**라면 종류 주문: 치즈 라면*/
		ramyeon.menuOrder(Ramyeon.Ramen.Cheese);
		System.out.print(ramyeon);
		
		/**물 넣음*/
		ramyeon.addMat("물");
		System.out.print(ramyeon);
		
		/**물 끓임*/
		ramyeon.boil();
		System.out.print(ramyeon);
		
		/**면 넣음*/
		ramyeon.addMat("면");
		System.out.print(ramyeon);
		
		/**스프 넣음*/
		ramyeon.addMat("스프");
		System.out.print(ramyeon);
		
		/**파 손질*/
		ramyeon.changeMat("파");
		
		/**손질한 파 넣음*/
		ramyeon.addMat("손질한 파");
		System.out.print(ramyeon);
		
		/**치즈 넣음*/
		ramyeon.addMat("치즈");
		
		/**치즈 라면 완성*/
		System.out.print(ramyeon);
		
		ramyeon.subtractMat("끓인 물");
		
		System.out.print(ramyeon);
		

	}
	
}
