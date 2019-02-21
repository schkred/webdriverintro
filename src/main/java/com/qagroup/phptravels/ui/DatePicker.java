package com.qagroup.phptravels.ui;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import io.qameta.allure.Step;

public class DatePicker {

	private SearchContext root;

	@FindBy(css = ".datepicker-days .prev")
	private WebElement previousMonthArrow;

	@FindBy(css = ".datepicker-days .switch")
	private WebElement monthOfYearLabel;

	@FindBy(css = ".datepicker-days .next")
	private WebElement nextMonthArrow;

	@FindBy(css = ".datepicker-days .day.old")
	private List<WebElement> previousMonthDays;

	@FindBy(css = ".day:not(.old):not(.new)")
	private List<WebElement> currentMonthDays;

	@FindBy(css = ".datepicker-days .day:not(.old):not(.new):not(.disabled)")
	private List<WebElement> currentMonthAvailableDays;

	@FindBy(css = ".datepicker-days .day.new")
	private List<WebElement> nextMonthDays;

	public DatePicker(WebElement root) {
		this.root = root;
		PageFactory.initElements(new DefaultElementLocatorFactory(root), this);
	}

	@Step("Select date")
	public void selectDate(LocalDate date) {
		selectYear(date.getYear());
		selectMonth(date.getMonth());
		selectDay(date.getDayOfMonth());
	}

	private void selectDay(int dayOfMonth) {
		currentMonthDays.get(dayOfMonth - 1).click();
	}

	// select Month using Date picker buttons
	private void selectMonth(Month month) {
		if (getMonthOnPage().equals(month)) {
			return;
		}
		if (getMonthOnPage().getValue() < month.getValue()) {
			while (!getMonthOnPage().equals(month)) {
				nextMonthArrow.click();
			}
		}
		if (getMonthOnPage().getValue() > month.getValue()) {
			while (!getMonthOnPage().equals(month)) {
				previousMonthArrow.click();
			}
		}
	}

	// get Month currently displayed in Date picker
	private Month getMonthOnPage() {
		return getYearMonth().getMonth();
	}

	// select Year using Date picker buttons
	private void selectYear(int year) {
		if (getYearOnPage() == year) {
			return;
		}
		if (getYearOnPage() < year) {
			while (getYearOnPage() != year) {
				nextMonthArrow.click();
			}
		}
		if (getYearOnPage() > year) {
			while (getYearOnPage() != year) {
				previousMonthArrow.click();
			}
		}
	}

	// get month currently displayed in Date picker
	private int getYearOnPage() {
		return getYearMonth().getYear();
	}

	// read current month and year from Date picker and transform it into YearMonth
	// object
	private YearMonth getYearMonth() {
		return YearMonth.parse(monthOfYearLabel.getText(), DateTimeFormatter.ofPattern("MMMM yyyy", Locale.US));
	}

}
