package com.crm.qa.pages;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NameDemo {

	public static void main(String[] args) {
		String homePage = "http://www.google.com";
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;

		System.setProperty("webdriver.chrome.driver", "C:\\Udaya\\Softwares\\Selenium_Software\\chrome\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.zlti.com");
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		System.out.println("Number of elements:" +elements.size());
		for(WebElement e : elements) {
			System.out.println("total number og links : " + e.getAttribute("href"));
		//	driver.navigate().to(e.getAttribute("href"));
		/*
		 * if(url == null || url.isEmpty()){ System.out.
		 * println("URL is either not configured for anchor tag or it is empty");
		 * continue; }
		 */
			
		/*
		 * if(!url.startsWith(homePage)){
		 * System.out.println("URL belongs to another domain, skipping it."); continue;
		 * }
		 */

			try {
			huc = (HttpURLConnection)(new URL(url).openConnection());

			huc.setRequestMethod("HEAD");

			huc.connect();

			respCode = huc.getResponseCode();
			System.out.println(driver.getTitle());
			if(respCode >= 400){
			System.out.println(url+" is a broken link");
			}
			else{
			System.out.println(url+" is a valid link");
			}
			}catch (MalformedURLException me) {
				// TODO Auto-generated catch block
				me.printStackTrace();
				} catch (IOException ie) {
				// TODO Auto-generated catch block
				ie.printStackTrace();
				}
		}
		/*
		 * for (int i=0; i<elements.size();i++){ System.out.println("Radio button text:"
		 * + elements.get(i).getAttribute("value")); }
		 */
		driver.close();
	}
}