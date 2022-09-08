import java.util.Scanner;
import java.io.*;

public class wk04_java06_201415060_ver2 {
	
	public static void main(String[] args) {
		Scanner fileScan1, fileScan2;
		String line1 = "", line2 = "";		
		boolean isNext1, isNext2;
		int diffType;
		int filesHaveSmthFlag = 0;
		
		try{
			fileScan1 = new Scanner( new File("in1.txt") );
			fileScan2 = new Scanner( new File("in2.txt") );
			for(;;){
				isNext1 = fileScan1.hasNext();
				isNext2 = fileScan2.hasNext();
				if(!isNext1 && !isNext2){
					diffType = 0;
					break;
				}
				else filesHaveSmthFlag = 1;
				
				if(!isNext1 && isNext2){
					diffType = 1;
					break;
				}
				else if(isNext1 && !isNext2){
					diffType = 2;
					break;
				}
				
				line1 = fileScan1.nextLine();
				line2 = fileScan2.nextLine();
				if( !line1.equals(line2) ){
					diffType = 3;
					break;
				}
			}
			
			if(diffType == 0 || diffType==3){
				if(filesHaveSmthFlag == 0) System.out.println("Files have no line");
				else{
					System.out.println(line1);
					System.out.println(line2);
				}
			}
			if(diffType==1){
				System.out.println("File1 has less line(s)");
				System.out.println("File1 == Null");
				System.out.println("Flie2 == "+line2);
			}
			if(diffType==2){
				System.out.println("File1 has more line(s)");
				System.out.println("File1 == " + line1);
				System.out.println("Flie2 == Null");
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}

}
