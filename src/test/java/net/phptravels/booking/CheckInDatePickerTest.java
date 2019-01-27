package net.phptravels.booking;

import java.time.LocalDate;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.qagroup.phptravels.MainPage;
import com.qagroup.phptravels.PhpTravelsApp;
import com.qagroup.phptravels.ui.DatePicker;
import com.qagroup.phptravels.ui.MainBookingPanel;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Epic("Booking")
@Feature("Booking")
@Story("Booking via Main booking panel")
public class CheckInDatePickerTest {

	private PhpTravelsApp phpTravelsApp = new PhpTravelsApp();
	private MainPage mainPage;
	private DatePicker datePicker;
	private MainBookingPanel mainBookingPanel;

	@Test
	public void testHotelBooking() {
		mainPage = phpTravelsApp.openMainPage();
		mainBookingPanel = mainPage.mainBookingPanel();
		datePicker = mainBookingPanel.openHotelsCheckInDatePicker();

		LocalDate testDate = LocalDate.now().plusYears(2);

		datePicker.selectDate(testDate);
	}

	//	@AfterMethod(alwaysRun = true)
	//	private void tearDown() {
	//		phpTravelsApp.close();
	//	}

	private void waitFor(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
