package config;

import org.openqa.selenium.WebDriver;

public class env {
	protected static WebDriver driver;
	protected static String SDErpLink = "http://192.168.101.88:3033/login";
	protected static String SDErpLinkTS = "http://192.168.101.88:3033/app/sd-timesheets/new-sd-timesheets-1";   //endpoint url timesheet
	protected static String SDErpLinkIssue = "http://192.168.101.88:3033/app/sd-issue/new-sd-issue-1"; //endpoint url sd issue
}
