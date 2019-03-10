package com.qagroup.phptravels.ui;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import io.qameta.allure.Step;

public class MainBookingPanel {

	private SearchContext root;

	@FindBy(css = "[data-title='hotels']")
	private WebElement hotelsTab;
	
	@FindBy(css = "select2-choice")
	private WebElement searchByHotelOrCityInput;

	@FindBy(css = "[name=checkin]")
	private WebElement checkInField;

	@FindBy(css = "[name=checkout]")
	private WebElement checkOutField;

	@FindBy(id = "travellersInput")
	private WebElement adultsAndChildrenField;

	@FindBy(id = "adultMinusBtn")
	private WebElement minusAdultsButton;

	@FindBy(id = "adultPlusBtn")
	private WebElement plusAdultsButton;

	@FindBy(id = "childMinusBtn")
	private WebElement minusChildrenButton;

	@FindBy(id = "childPlusBtn")
	private WebElement plusChildrenButton;

	@FindBy(id = "adultInput")
	private WebElement numberOfAdultsInput;

	@FindBy(id = "childInput")
	private WebElement numberOfChildrenInput;

	public MainBookingPanel(WebElement mainBookingPanel) {
		this.root = mainBookingPanel;
		PageFactory.initElements(new DefaultElementLocatorFactory(root), this);
	}

	@Step("Select 'Hotels' tab on Main booking panel")
	public MainBookingPanel selectHotelsTab() {
		hotelsTab.click();
		return this;
	}
	
	public void searchByHotelOrCity(String string) {
		searchByHotelOrCityInput.click();
		searchByHotelOrCityInput.sendKeys("Dubai");
		
	}

	@Step("Open 'Check in' date picker")
	public void openHotelsCheckInDatePicker() {
		checkInField.click();
	}

	@Step("Open 'Check out' date picker")
	public void openHotelsCheckOutDatePicker() {
		checkOutField.click();
	}

	@Step("Open 'Adults and children' picker")
	public void openAdultsAndChildrenPicker() {
		adultsAndChildrenField.click();
	}

	@Step("Set the number of adults and children")
	public void selectAdultsAndChildren(int adults, int children) {
		setNumberOfAdults(adults);
		setNumberOfChildren(children);
	}

//    private void setNumberOfAdults(int adults) {
//        numberOfAdultsInput.clear();
//        numberOfAdultsInput.sendKeys(Integer.toString(adults));
//    }

	private void setNumberOfAdults(int adults) {
		int currentValue = Integer.valueOf(numberOfAdultsInput.getAttribute("value"));
		if (currentValue == adults) {
			return;
		}
		if (currentValue < adults) {
			while (currentValue != adults) {
				plusAdultsButton.click();
				currentValue = Integer.valueOf(numberOfAdultsInput.getAttribute("value"));
			}
		}
		if (currentValue > adults) {
			while (currentValue != adults) {
				minusAdultsButton.click();
				currentValue = Integer.valueOf(numberOfAdultsInput.getAttribute("value"));
			}
		}
	}
//
//    private void setNumberOfChildren(int children) {
//        numberOfChildrenInput.clear();
//        numberOfChildrenInput.sendKeys(Integer.toString(children));
//    }
	private void setNumberOfChildren(int children) {
		int currentValue = Integer.valueOf(numberOfChildrenInput.getAttribute("value"));
		if (currentValue == children) {
			return;
		}
		if (currentValue < children) {
			while (currentValue != children) {
				plusChildrenButton.click();
				currentValue = Integer.valueOf(numberOfAdultsInput.getAttribute("value"));
			}
		}
		if (currentValue > children) {
			while (currentValue != children) {
				minusChildrenButton.click();
				currentValue = Integer.valueOf(numberOfAdultsInput.getAttribute("value"));
			}
		}
	}
}