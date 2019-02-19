package net.phptravels.booking;

import com.qagroup.phptravels.MainPage;
import com.qagroup.phptravels.PhpTravelsApp;

public class BookHotelByCityNameTest {
	PhpTravelsApp phpTtravelsApp = new PhpTravelsApp();
	private MainPage mainPage;
	
	public void testBookingHotelByCityName() {
		mainPage = phpTtravelsApp.openMainPage();
		mainPage.getMainBookingPanel().selectHotelsTab();
		
	}
}
