
public class StringDemo {
	public static void main(String[] args){
		String str = "천재용 천재";
		System.out.println(str.length());
		System.out.println(str.indexOf("재용"));
		System.out.println(str.charAt(4));
		System.out.println(str.replace("천재", "둔재"));
		System.out.println(str.substring(2, 5));
	}
}
