package com.shems.mobile
;

import static org.junit.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;
import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.common.device.DeviceTargetPlatform;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

public class ObjectFilterTestSuite {
  private static WebDriver driver;

    
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
  public void testObjectFilterAll() throws Exception {
	  	  
	driver.findElement(By.linkText("Objects")).click();
	  
	assertTrue(isElementPresent(By.linkText("Air Conditioner")));
	assertTrue(isElementPresent(By.linkText("Clothes Iron")));
	assertTrue(isElementPresent(By.linkText("Hair Straightener")));
	assertTrue(isElementPresent(By.linkText("Couple Bedroom Light")));
	assertTrue(isElementPresent(By.linkText("Oven")));
	assertTrue(isElementPresent(By.linkText("Kitchen Light")));
	assertTrue(isElementPresent(By.linkText("TV")));
	assertTrue(isElementPresent(By.linkText("Garage Light")));
	  	  
	WebElement objList = driver.findElement(By.id("listViewObj"));
	TouchActions touch = new TouchActions(driver).flick(objList, 0, -200, 0);
	touch.perform();

	assertTrue(isElementPresent(By.linkText("Shaving Machine")));
	    
  }
  
  @Test
  public void testObjectFilterKitchen() throws Exception {
	  
	driver.findElement(By.linkText("Objects")).click();
	driver.findElement(By.linkText("All")).click();
	driver.findElement(By.xpath("//AppCompatTextView[2]")).click();
	
	assertTrue(isElementPresent(By.linkText("Oven")));
	assertTrue(isElementPresent(By.linkText("Kitchen Light")));
	
	assertFalse(isElementPresent(By.linkText("Air Conditioner")));
	assertFalse(isElementPresent(By.linkText("Clothers Iron")));  
	assertFalse(isElementPresent(By.linkText("Hair Straightener")));  
	assertFalse(isElementPresent(By.linkText("Couple Bedroom Light"))); 
	assertFalse(isElementPresent(By.linkText("TV")));
	assertFalse(isElementPresent(By.linkText("Garage Light")));  
	assertFalse(isElementPresent(By.linkText("Shaving Machine"))); 
	  
  }
  
  @Test
  public void testObjectFilterBathroom() throws Exception {
	
	driver.findElement(By.linkText("Objects")).click();
	driver.findElement(By.linkText("All")).click();
	driver.findElement(By.xpath("//AppCompatTextView[8]")).click();
	
	assertTrue(isElementPresent(By.linkText("Hair Straightener")));	
	assertTrue(isElementPresent(By.linkText("Shaving Machine")));
	
	assertFalse(isElementPresent(By.linkText("Air Conditioner")));
	assertFalse(isElementPresent(By.linkText("Clothers Iron")));  
	assertFalse(isElementPresent(By.linkText("Couple Bedroom Light")));
	assertFalse(isElementPresent(By.linkText("Oven")));
	assertFalse(isElementPresent(By.linkText("Kitchen Light")));  
	assertFalse(isElementPresent(By.linkText("TV")));
	assertFalse(isElementPresent(By.linkText("Garage Light")));  

  }
    
  @Test
  public void testObjectFilterKidsBedroom() throws Exception{
	
	driver.findElement(By.linkText("Objects")).click();
	driver.findElement(By.linkText("All")).click();
	driver.findElement(By.xpath("//AppCompatTextView[6]")).click();
	
	assertFalse(isElementPresent(By.linkText("Air Conditioner")));
	assertFalse(isElementPresent(By.linkText("Clothes Iron")));
	assertFalse(isElementPresent(By.linkText("Hair Straightener")));
	assertFalse(isElementPresent(By.linkText("Couple Bedroom Light")));
	assertFalse(isElementPresent(By.linkText("Oven")));
	assertFalse(isElementPresent(By.linkText("Kitchen Light")));
	assertFalse(isElementPresent(By.linkText("TV")));
	assertFalse(isElementPresent(By.linkText("Garage Light")));
	assertFalse(isElementPresent(By.linkText("Shaving Machine")));
	  
  }
  
  @After
  public void tearDown(){
	  driver.quit();  
  }

  
  private boolean isElementPresent(By by) {
    try {
    	driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    	driver.findElement(by);
    	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    	return true;
    
    } catch (Exception e) {
    	System.out.println(e.toString());
    	return false;
    }
  }
    
}
