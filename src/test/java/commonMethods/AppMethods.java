package commonMethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;

public class AppMethods extends TestBase 
{
	
	//Method to Find the available flights
	public static void findFlights(String deprtCity, String destcity)
	{
		log.info("Inside the findFlights Test");
		WebElement departCity = driver.findElement(By.xpath(OR.getProperty("selectDepartCity")));
		WebElement destCity = driver.findElement(By.xpath(OR.getProperty("selectDestCity")));
		Select depart = new Select(departCity);
		depart.selectByValue(deprtCity);
		log.info("Selected Departure City: " + OR.getProperty("selectDepartCity"));
		Select dest = new Select(destCity);
		dest.selectByValue(destcity);
		log.info("Selected Departure City: " + OR.getProperty("selectDestCity"));
		driver.findElement(By.xpath(OR.getProperty("btnFindFlights"))).click();
		log.info("Clicked on Find Flights button.");
	}
	
	
    //Method to choose the flight from available flights list
	public static void chooseTheFlight(String flightNo)
	{
		List<WebElement> rows = driver.findElements(By.xpath(OR.getProperty("flightsTableRows")));
		List<WebElement> cols = driver.findElements(By.xpath(OR.getProperty("flightsTableCols")));		

		for (int row = 1; row <= rows.size(); row++)
		{
			String fltNo = null;

			for (int col = 1; col <= cols.size(); col++) 
			{
				fltNo = driver.findElement(By.xpath(OR.getProperty("flightsTableRows")+"[" + row + "]/td[" + col + "]")).getText();
				if (fltNo.equals(flightNo)) 
				{
					driver.findElement(By.xpath(OR.getProperty("flightsTableRows")+"[" + row + "]"+OR.getProperty("chooseFlightBtn"))).click();
					break;
				}
			}
			if (fltNo.equals("12")) 
			{
				break;
			}

		}	

	}
	

	
	//Method to enter the passenger details
	public static void enterPasangerDetails(String name, String address, String city, String state, String zipCode, String card, String cardNumber, String cardMonth, String cardYear, String nameOnCard)
	{
		 driver.findElement(By.xpath(OR.getProperty("name"))).sendKeys(name);
		 driver.findElement(By.xpath(OR.getProperty("address"))).sendKeys(address);
		 driver.findElement(By.xpath(OR.getProperty("city"))).sendKeys(city);
		 driver.findElement(By.xpath(OR.getProperty("state"))).sendKeys(state);
		 driver.findElement(By.xpath(OR.getProperty("zipCode"))).sendKeys(zipCode);
		 WebElement cardtype =driver.findElement(By.xpath(OR.getProperty("cardType")));
		 Select selectCard = new Select(cardtype);
		 selectCard.selectByValue(card);		 
		 driver.findElement(By.xpath(OR.getProperty("cardNumber"))).sendKeys(cardNumber);
		 driver.findElement(By.xpath(OR.getProperty("cardMonth"))).sendKeys(cardMonth);
		 driver.findElement(By.xpath(OR.getProperty("cardYear"))).sendKeys(cardYear);
		 driver.findElement(By.xpath(OR.getProperty("nameOnCard"))).sendKeys(nameOnCard);
		 driver.findElement(By.xpath(OR.getProperty("purchaseFlightBtn"))).click();
		 
	}
	
	//Method to get the purchase details
	public static void purchaseDetails()
	{
		List<WebElement> rows = driver.findElements(By.xpath(OR.getProperty("purchaseDetailsRows")));
		List<WebElement> cols = driver.findElements(By.xpath(OR.getProperty("purchaseDetailsCols")));		
		
		for(int row=1; row <= rows.size();row++)
		{
			for(int col=1; col<= cols.size(); col++)
			{
				System.out.print(driver.findElement(By.xpath(OR.getProperty("purchaseDetailsRows")+"["+row+"]/td["+col+"]")).getText()+"\t\t");
			
			}
			System.out.println();
			
		}
		
		}
		 
	
	
	
}













