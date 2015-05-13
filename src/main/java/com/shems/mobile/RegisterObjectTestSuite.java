package com.shems.mobile;

import static org.junit.Assert.assertEquals;

import java.util.List;

import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.common.device.DeviceTargetPlatform;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterObjectTestSuite {
	private static WebDriver driver;
	
	private final String OFF = "off";
	private final String ON = "on";
	
	@Before
	public void setUp() throws Exception {
		SelendroidCapabilities capa = new SelendroidCapabilities();
		capa.setAut("com.shems.mobile:1.0");	  
		capa.setPlatformVersion(DeviceTargetPlatform.ANDROID19);     
	  
		capa.setEmulator(true);
		capa.setModel("Galaxy Nexus");
	  
		driver = new SelendroidDriver(capa);  
	}
	
	 @Test
	 public void testRegisterObject1() throws Exception{
		
		 driver.findElement(By.linkText("Objects")).click();
		 driver.findElement(By.id("buttonAddObj")).click();
		 driver.findElement(By.id("editSerial")).sendKeys("123456");
		 driver.findElement(By.id("editName")).sendKeys("Washing Machine");
		 driver.findElement(By.linkText("Kitchen")).click();
		 driver.findElement(By.xpath("//AppCompatTextView[1]")).click();
		 driver.findElement(By.id("editDescription")).sendKeys("The Washing Machine of the Garage");
		 driver.findElement(By.id("buttonRegister")).click();
		 
		 driver.findElement(By.linkText("All")).click();
		 driver.findElement(By.xpath("//AppCompatTextView[2]")).click();
		 
		 List<WebElement> statusList = driver.findElements(By.id("textStatus"));
		 assertEquals(this.OFF, statusList.get(2).getText());
		 
		 driver.findElement(By.linkText("Washing Machine")).click();    
		 driver.findElement(By.id("switchOnOff")).click();    
		 assertEquals(this.ON, driver.findElement(By.id("textObjStatus")).getText());
		 		 
	 }
	
	@After
	public void tearDown(){
		driver.quit();  
	}
	  
}
