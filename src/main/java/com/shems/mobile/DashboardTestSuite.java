package com.shems.mobile;

import static org.junit.Assert.*;
import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.common.device.DeviceTargetPlatform;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardTestSuite {

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
  public void testGoalAndConsumedMarch() throws Exception {
	  
	  driver.findElement(By.linkText("March")).click();
	  driver.findElement(By.xpath("//AppCompatTextView[1]")).click();
	  
	  assertEquals("100", driver.findElement(By.id("textGoal")).getText());
	  assertEquals("84", driver.findElement(By.id("textConsumed")).getText());
  }
  
  @Test
  public void testGoalAndConsumedFebruary() throws Exception {
	  driver.findElement(By.linkText("March")).click();
	  driver.findElement(By.xpath("//AppCompatTextView[2]")).click();
	  
	  assertEquals("100", driver.findElement(By.id("textGoal")).getText());
	  assertEquals("89", driver.findElement(By.id("textConsumed")).getText());
  }
  
  @Test
  public void testGoalAndConsumedJanuary() throws Exception {
	  driver.findElement(By.linkText("March")).click();
	  driver.findElement(By.xpath("//AppCompatTextView[3]")).click();
	  
	  assertEquals("100", driver.findElement(By.id("textGoal")).getText());
	  assertEquals("77", driver.findElement(By.id("textConsumed")).getText());
  }
   
  @After
  public void tearDown(){
	  driver.quit();  
  }
	
}
