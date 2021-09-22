package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import commonMethods.AppMethods;

public class BookFlight extends AppMethods
{
	
	
	@Test(dataProvider="getData")
	public static void bookFlightTicketUsingVisaCard(String deprtCity, String desctcity,String flightNo, String name, String address, String city, String state, String zipCode, String cardType, String cardNumber, String cardMonth, String cardYear, String nameOnCard)
	{
		findFlights(deprtCity,desctcity);		
		chooseTheFlight(flightNo);
		enterPasangerDetails(name, address, city, state, zipCode, cardType, cardNumber, cardMonth, cardYear, nameOnCard);
		purchaseDetails();		
		
	}	
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object [][] data = new Object[1][13];
		data[0][0] = "Mexico City";
		data[0][1] = "New York";
		data[0][2] = "12";
		data[0][3] = "Hanamanth";
		data[0][4] = "Bangalore";
		data[0][5] = "Bangalore";
		data[0][6] = "Karnataka";
		data[0][7] = "560001";
		data[0][8] = "visa";
		data[0][9] = "12345678910";
		data[0][10] = "11";
		data[0][11] = "2025";
		data[0][12] = "Hanamanth Pujari";	
		
		
		
		return data;
		
		
	}
}


