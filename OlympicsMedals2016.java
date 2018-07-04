package asserttion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OlympicsMedals2016 {
	static WebDriver d;
	@BeforeClass //runs once for all tests
	public void setUp() {
		
	//	System.out.println("Setting up WebDriver in BeforeClass...");
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.manage().window().fullscreen();
	}
	
		@Test
		public void url() throws InterruptedException {
			d.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
			
//	
		//WebElement col=d.findElement(By.xpath("(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter'])/tbody/tr/td[1]"));
		List<WebElement> col1=d.findElements(By.xpath("(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter'])/tbody/tr/td[1]"));
		int  col5=0;
		List<Integer> col3=new ArrayList<>();
		//System.out.println(row1.size());
		for(int i=0;i<col1.size()-1;i++) {
		col5=Integer.parseInt(col1.get(i).getText());
			col3.add(col5);
		}
		//System.out.println(col3);
		List<Integer> col4=new ArrayList<>(col3);
		Collections.sort(col3);
	//	System.out.println(col4+ " "+ col3);
				
		Assert.assertEquals(col3, col4);	
		d.findElement(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/thead/tr/th[2]")).click();
		//(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter'])/tbody/tr/th
		Thread.sleep(3000);
		
		List<WebElement> row= d.findElements(By.xpath("(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter'])/tbody/tr/th"));
			String row2="";
			List<String> row4=new ArrayList<>();
			SortedSet<String> sets=new TreeSet<>();
		for(int i=0;i<row.size()-1;i++) {
			
			row4.add(row.get(i).getText());
			sets.add(row.get(i).getText());
		}
		
	
		Assert.assertEquals(row4, sets);
		
		//WebElement col=d.findElement(By.xpath("(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter'])/tbody/tr/td[1]"));
		List<WebElement> coll=d.findElements(By.xpath("(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter'])/tbody/tr/td[1]"));
		int  coll6=0;
		List<Integer> coll2=new ArrayList<>();
		//System.out.println(row1.size());
		for(int i=0;i<coll.size();i++) {
		coll6=Integer.parseInt(coll.get(i).getText());
			coll2.add(coll6);
		}
		Assert.assertNotEquals(coll2, col4);
		//System.out.println(coll2);
		//System.out.println(col4);
}
		@Test
		public void coldMedal() {
	
	OlympicsMedals2016 name =new OlympicsMedals2016();
	
	d.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
	// (//table[@class='wikitable sortable plainrowheaders jquery-tablesorter'])/tbody/tr/td[2]
	medalTable("(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter'])/tbody/tr/td[2]");
	String cold7=name.medalTable("(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter'])/tbody/tr/td[2]");
	System.out.println(cold7);
	String silver=name.medalTable("(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter'])/tbody/tr/td[3]");
	System.out.println(silver);
	String bronze=name.medalTable("(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter'])/tbody/tr/td[4]");
	System.out.println(bronze);
	
	
}
@Test
public void colAndRow() throws InterruptedException {

	OlympicsMedals2016 name =new OlympicsMedals2016();
	
	d.get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
	name.xlsheet("Japan");
	//name.twoCountry(18);
	//name.count18(11);
}public void count18(int count) {

	  List<WebElement> nocCountries = d.findElements(
              By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']//th/a"));
      List<WebElement> silverNum = d.findElements(
              By.xpath("//table[@class='wikitable sortable plainrowheaders " + "jquery-tablesorter']//tr/td[3]"));
      Map<String, Integer> silver18Map = new HashMap<>();
      for (int i = 0; i < 10; i++) {
          if (Integer.parseInt(silverNum.get(i).getText()) == 18) {
              silver18Map.put(nocCountries.get(i).getText(), Integer.valueOf(silverNum.get(i).getText()));
              System.out.println(nocCountries.get(i).getText() + " is the country that has "
                      + Integer.valueOf(silverNum.get(i).getText()) + " silver medals");
          }
      }
  }


		
		
	
	public void xlsheet(String country) throws InterruptedException {
		

		List<WebElement> coll=d.findElements(By.xpath("//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th"));
		
		List<String> country1 = new ArrayList<>();
		for(int i=0;i<coll.size();i++) {
			country1.add(coll.get(i).getText());
			
		}	String rowCol="";
		System.out.println(country1);
				for(int k=0;k<country1.size();k++) {
			//		Thread.sleep(3000);
				
				if(country1.get(k).contains(country)) {
					
					rowCol=2+" "+(k+1);
					System.out.println(2+" "+(k+1));
					break;
				}
			}String ac=2+" "+6;
			Assert.assertEquals(rowCol,ac);
		}
		
		
		
		
		
		
		
	
	
	
	
public String  medalTable(String xpathMedal) {
	
		List<WebElement> country = d.findElements(
				By.xpath("(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter'])/tbody/tr/th"));

		List<String> country1 = new ArrayList<>();
		for (int i = 0; i < country.size()-1; i++) {

			country1.add(country.get(i).getText());

		}
		List<WebElement> cold = d.findElements(By.xpath(xpathMedal));
		List<Integer> cold1 = new ArrayList<>();
		Map<String,Integer> medal=new HashMap<>();

		for (int i = 0; i < cold.size()-1; i++) {

			medal.put(country1.get(i),Integer.parseInt(cold.get(i).getText()));
cold1.add(Integer.parseInt(cold.get(i).getText()));
		}
		
	Integer max=Collections.max(cold1);
	
	SortedSet<Integer> sets = new TreeSet<>(cold1);
	
		String country6 = (String)this.getKeyFromValue(medal, max);
		Assert.assertEquals(country6," United States (USA)");
		return country6;	
			
}

public Object getKeyFromValue(Map m, Object value) {
	for (Object o: m.keySet()) {
		if(m.get(o).equals(value)) {
			return o;
		}
	}
	return null;
}
public List twoCountry(int sum) {
	
List<WebElement> country = d.findElements(
		By.xpath("(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter'])/tbody/tr/th"));

List<String> country1 = new ArrayList<>();
for (int i = 0; i < country.size()-1; i++) {

	country1.add(country.get(i).getText());

}
List<WebElement> cold = d.findElements(By.xpath("(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter'])/tbody/tr/td[4]"));
List<Integer> numOfMedals= new ArrayList<>();

Map<String,Integer> medal=new HashMap<>();

for (int i = 0; i < cold.size()-1; i++) {

	medal.put(country1.get(i),Integer.parseInt(cold.get(i).getText()));
numOfMedals.add(Integer.parseInt(cold.get(i).getText()));

}
int countryNum2=0;
int countryNum1=0;
int num1=0;
for(int i=0;i<numOfMedals.size();i++) {
	for(int j=0;j<numOfMedals.size();j++) {
		num1=numOfMedals.get(i);
	if(num1+numOfMedals.get(j)==sum && i!=j) {
	 countryNum1=num1;
	 countryNum2=numOfMedals.get(j);
	
	}
	}
}


String countrySt2= (String)this.getKeyFromValue(medal, countryNum2);

String countrySt= (String)this.getKeyFromValue(medal, countryNum1);
List<String> twocountry = new ArrayList<>();
twocountry.add(countrySt2);
twocountry.add(countrySt);
List<String> twocountry2 = new ArrayList<>();
twocountry2.add(" Italy (ITA)");
twocountry2.add(" Australia (AUS)");
System.out.println(twocountry);
Assert.assertEquals(twocountry,twocountry2);
return twocountry;	
	
}

	}




