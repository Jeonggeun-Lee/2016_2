
public class StringDemo {
	public static void main(String[] args){
		String str = "õ��� õ��";
		System.out.println(str.length());
		System.out.println(str.indexOf("���"));
		System.out.println(str.charAt(4));
		System.out.println(str.replace("õ��", "����"));
		System.out.println(str.substring(2, 5));
	}
}
