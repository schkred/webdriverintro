package net.phptravels.booking;

import java.time.LocalDate;

import org.testng.annotations.Test;

import com.qagroup.phptravels.MainPage;
import com.qagroup.phptravels.PhpTravelsApp;
import com.qagroup.phptravels.ui.DatePicker;
import com.qagroup.phptravels.ui.MainBookingPanel;

public class BookHotelByCityNameTest {
	PhpTravelsApp phpTtravelsApp = new PhpTravelsApp();
	private MainPage mainPage;
	private DatePicker datePicker;
	private MainBookingPanel mainBookingPanel;
	
	@Test
	public void testBookingHotelByCityName() {
		mainPage = phpTtravelsApp.openMainPage();
		mainBookingPanel = mainPage.getMainBookingPanel();
		mainBookingPanel.selectHotelsTab().openHotelsCheckInDatePicker();
		datePicker = mainPage.getDatePicker();
		
		LocalDate checkInDate = LocalDate.now().plusYears(1).plusMonths(1);
		datePicker.selectDate(checkInDate);
		
		mainPage.getMainBookingPanel().openHotelsCheckOutDatePicker();
		LocalDate checkOutDate = checkInDate.plusDays(3);
		datePicker.selectDate(checkOutDate);
		
		mainBookingPanel.openAdultsAndChildrenPicker();
		mainBookingPanel.selectAdultsAndChildren(4, 2);
		
	}
}
