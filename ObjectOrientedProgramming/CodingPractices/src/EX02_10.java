
public class EX02_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int iResult, num1 =  25, num2 = 40, num3 = 17, num4 = 5;
		double fResult, val1 = 17.0, val2 = 12.78;
		
		iResult = num1 / num4;
		System.out.println("iResult=="+iResult);
		fResult = num1 / num4;
		System.out.println("fResult=="+fResult);
		iResult = num3 / num4;
		System.out.println("iResult=="+iResult);
		fResult = num3 / num4;
		System.out.println("fResult=="+fResult);
		fResult = val1 / num4;
		System.out.println("fResult=="+fResult);
		fResult = val1 / val2;
		System.out.println("fResult=="+fResult);
		iResult = num1 / num2;
		System.out.println("iResult=="+iResult);
		fResult = (double) num1 / num2;
		System.out.println("fResult=="+fResult);
		fResult = num1 / (double) num2;
		System.out.println("fResult=="+fResult);
		fResult = (double) (num1 / num2);
		System.out.println("fResult=="+fResult);
		iResult = (int) (val1 / num4);
		System.out.println("iResult=="+iResult);
		fResult = (int) (val1 / num4);
		System.out.println("fResult=="+fResult);
		fResult = (int) ( (double) num1 / num2 );
		System.out.println("fResult=="+fResult);
		iResult = num3 % num4;
		System.out.println("iResult=="+iResult);
		iResult = num2 % num3;
		System.out.println("iResult=="+iResult);
		iResult = num3 % num2;
		System.out.println("iResult=="+iResult);
		iResult = num2 % num4;
		System.out.println("iResult=="+iResult);


	}

}
