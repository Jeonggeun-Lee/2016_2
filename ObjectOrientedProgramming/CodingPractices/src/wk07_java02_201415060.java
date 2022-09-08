/**
wk07_java02_201415060 클래스는  
CD모음집 객체를 생성하고 CD를 추가하고 모음집의 내용물을 출력하기
위한 클래스입니다.
@author 201415060 이정근(nalbojima@daum.net)
@version 1.0 Nov. 2016
@helper 없음
*/

/**소수점 자릿수 표현을 위한 DecimalFormat 클래스 도입*/
import java.text.DecimalFormat;

/**CD를 표현하는 클래스*/
class CD
{
	/**제목, 가수, 가격, CD모음의 순번*/
   private String title, artist;
   private double cost;
   private int tracks;
   
   /**특정 정보를 가지고 CD를 생성*/
   public CD (String name, String singer, double price, int numTracks)
   {
      title = name;
      artist = singer;
      cost = price;
      tracks = numTracks;
   }
   
   /**CD정보를 문자열로 표현하는 메소드*/
   
   public String toString()
   {
	   /**소수점 이하 두자리까지만 출력, 마지막 0은 출력안함*/
      DecimalFormat fmt = new DecimalFormat("#.##");
      
      String description;
      /**-가격	트랙	제목	가수*/
      description ="- " + fmt.format(cost) + "\t" + tracks + "\t";
      description += title + "\t" + artist;

      return description;
   }
}

/**CD모음 객체*/

class CDCollection
{
	/**CD 배열*/
	private CD[] collection;
	/**CD개수*/
	private int count;
	/**총 가격*/
	private double totalCost;
	
/**처음 텅빈 CD 모음을 생성*/
	public CDCollection ()
	{
		collection = new CD[100];
		count = 0;
		totalCost = 0.0;
	}

/**CD를 추가하고 필요하면 CD모음집의 크기를 늘리는 함수*/

	public void addCD (String title, String artist, double cost, int tracks)
	{
		/**들어있는 CD 개수가 CD모음집 길이와 같으면 CD모음집 크기를 늘림*/
		if (count == collection.length)
			increaseSize();
		/**CD개수의 첨수의 배열에 CD 추가, 총가격 증가, CD개수 증가*/
		collection[count] = new CD (title, artist, cost, tracks);
		totalCost += cost;
		count++;
	}

	/**CD모음집의 내용물을 문자열로 반환*/

	public String toString()
	{
		DecimalFormat fmt = new DecimalFormat("#.##");

		String report = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
		report += "My CD Collection\n";

		report += "- Number of CDs = " + count + "\n";
		report += "- Total cost = " + fmt.format(totalCost) + "\n";
		report += "- Average cost = " + fmt.format(totalCost/count);

		report += "\nCD List:\n";

		for (int cd = 0; cd < count; cd++)
			report += collection[cd].toString() + "\n";

		return report;
	}

/**CD모음집의 용량을 늘린다. 더큰 배열을 생성하고 전 배열을 거기에 복사*/	
	private void increaseSize ()
	{
		CD[] temp = new CD[collection.length * 2];

		for (int cd = 0; cd < collection.length; cd++)
		temp[cd] = collection[cd];

		collection = temp;
	}
}

public class wk07_java02_201415060 {
	/**
	main 함수는
	CD모음집 객체를 생성하고 CD를 추가하고 모음집의 내용물을 출력합
	니다.
	@param args: the command line arguments
	@return void
	*/
	   public static void main (String[] args)
	   {
	      CDCollection music = new CDCollection ();

	      music.addCD ("Storm Front", "Billy Joel", 14.95, 10);
	      music.addCD ("Come On Over", "Shania Twain", 14.95, 16);
	      music.addCD ("Soundtrack", "Les Miserables", 17.95, 33);
	      music.addCD ("Graceland", "Paul Simon", 13.90, 11);

	      System.out.print (music);

	      music.addCD ("Double Live", "Garth Brooks", 19.99, 26);
	      music.addCD ("Greatest Hits", "Jimmy Buffet", 15.95, 13);

	      System.out.print (music);
	   }
}
