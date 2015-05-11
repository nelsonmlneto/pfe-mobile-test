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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

public class ObjectVisualizationTestSuite {
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
  public void testObjectVisualization1() throws Exception {
	  driver.findElement(By.linkText("Objects")).click();
	  driver.findElement(By.linkText("Air Conditioner")).click();
	  
	  assertEquals("Object Visualization", driver.findElement(By.id("labelObjVisualizationTitle")).getText());
	  assertEquals("Air Conditioner", driver.findElement(By.id("textObjName")).getText());	  
  }
  
  @Test
  public void testObjectVisualization2() throws Exception {
	  driver.findElement(By.linkText("Objects")).click();
	  driver.findElement(By.linkText("Clothers Iron")).click();
	
	  assertEquals("Object Visualization", driver.findElement(By.id("labelObjVisualizationTitle")).getText());
	  assertEquals("Clothers Iron", driver.findElement(By.id("textObjName")).getText());
  }
  
  @Test
  public void testObjectVisualization3() throws Exception {  
	  driver.findElement(By.linkText("Objects")).click();
	  driver.findElement(By.linkText("Hair Straightener")).click();
	
	  assertEquals("Object Visualization", driver.findElement(By.id("labelObjVisualizationTitle")).getText());
	  assertEquals("Hair Straightener", driver.findElement(By.id("textObjName")).getText());
  }
  
  @Test
  public void testObjectVisualization4() throws Exception {
	  driver.findElement(By.linkText("Objects")).click();
	  driver.findElement(By.linkText("Couple Bedroom Light")).click();
	
	  assertEquals("Object Visualization", driver.findElement(By.id("labelObjVisualizationTitle")).getText());
	  assertEquals("Couple Bedroom Light", driver.findElement(By.id("textObjName")).getText());
  }
  
  @Test
  public void testObjectVisualization5() throws Exception {
	  driver.findElement(By.linkText("Objects")).click();
	  driver.findElement(By.linkText("Oven")).click();
	
	  assertEquals("Object Visualization", driver.findElement(By.id("labelObjVisualizationTitle")).getText());
	  assertEquals("Oven", driver.findElement(By.id("textObjName")).getText());
  }
  
  @Test
  public void testObjectVisualization6() throws Exception {
	  driver.findElement(By.linkText("Objects")).click();
	  driver.findElement(By.linkText("Kitchen Light")).click();
	
	  assertEquals("Object Visualization", driver.findElement(By.id("labelObjVisualizationTitle")).getText());
	  assertEquals("Kitchen Light", driver.findElement(By.id("textObjName")).getText());
  }
  
  @Test
  public void testObjectVisualization7() throws Exception {
	  driver.findElement(By.linkText("Objects")).click();
	  driver.findElement(By.linkText("TV")).click();
	  
	  assertEquals("Object Visualization", driver.findElement(By.id("labelObjVisualizationTitle")).getText());
	  assertEquals("TV", driver.findElement(By.id("textObjName")).getText());
  }
  
  @Test
  public void testObjectVisualization8() throws Exception {
	  driver.findElement(By.linkText("Objects")).click();
	  driver.findElement(By.linkText("Garage Light")).click();
	
	  assertEquals("Object Visualization", driver.findElement(By.id("labelObjVisualizationTitle")).getText());
	  assertEquals("Garage Light", driver.findElement(By.id("textObjName")).getText());
  }
  
  @Test
  public void testObjectVisualization9() throws Exception {
	  driver.findElement(By.linkText("Objects")).click();
	  
	  WebElement objList = driver.findElement(By.id("listViewObj"));
	  TouchActions touch = new TouchActions(driver).flick(objList, 0, -200, 0);
	  touch.perform();
	  
	  driver.findElement(By.linkText("Shaving Machine")).click();
	
	  assertEquals("Object Visualization", driver.findElement(By.id("labelObjVisualizationTitle")).getText());
	  assertEquals("Shaving Machine", driver.findElement(By.id("textObjName")).getText());
  }
  
  @After
  public void tearDown(){
	  driver.quit();  
  }
  
}
