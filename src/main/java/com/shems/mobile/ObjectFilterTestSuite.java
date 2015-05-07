package com.shems.mobile
;

import static org.testng.AssertJUnit.assertTrue;
import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.common.device.DeviceTargetPlatform;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ObjectFilterTestSuite {
  private static WebDriver driver;

  

  @BeforeSuite
  public static void setUpAll() throws Exception {
	  
	  SelendroidCapabilities capa = new SelendroidCapabilities();
	  capa.setAut("com.shems.mobile:1.0");	  
      capa.setPlatformVersion(DeviceTargetPlatform.ANDROID19);     
      
      capa.setEmulator(true);
      capa.setModel("Galaxy Nexus");
      
	  driver = new SelendroidDriver(capa);
  }
  

  @Test
  public void testObjectFilterAll() throws Exception {
	  System.out.println("Teste");
	  
	  WebElement inputField = driver.findElement(By.id("textGoal"));
	  System.out.println(">>> " + inputField.getText());
	
	  //assertTrue(isElementPresent(By.linkText("General Energy Consumption")));
	  assertTrue(isElementPresent(By.linkText("General Energy Consumption")));
	  
  }
  

  @AfterSuite
  public static void tearDown() throws Exception {
	  driver.quit();
  }
  
  private boolean isElementPresent(By by) {
    try {
    	driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    	driver.findElement(by);
    	driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
    	return true;
    
    } catch (NoSuchElementException e) {
    	return false;
    }
  }
    
}
