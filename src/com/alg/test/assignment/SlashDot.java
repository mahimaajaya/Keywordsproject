package com.alg.test.assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SlashDot {

	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "C:\\Working\\Workspace\\SeleniumExamples\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://slashdot.org/");

		//String cmtcnt = driver.findElement(By.xpath("//table[@class='thisday-tb']/tbody/tr/td[3]")).getText();
		
		//System.out.println(cmtcnt);     
		List<WebElement> comment_cnt = driver.findElements(By.xpath("//table[@class='thisday-tb']/tbody/tr/td[3]"));
		
		System.out.println(+comment_cnt.size());
		int total = 0;
		for(int i=0; i<comment_cnt.size(); i++){
			String Str_count = comment_cnt.get(i).getText();
			int count = Integer.parseInt(Str_count);
			total = total +count;
			}
		
		System.out.println("Total no of comments =" +total);
		driver.quit();
		
	}

}
