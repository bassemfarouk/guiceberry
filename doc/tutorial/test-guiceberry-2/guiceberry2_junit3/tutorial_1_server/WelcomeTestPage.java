package guiceberry2_junit3.tutorial_1_server;

import com.google.inject.Inject;

import guiceberry2_junit3.tutorial_1_server.prod.PetOfTheMonth;
import guiceberry2_junit3.tutorial_1_server.prod.PortNumber;

import junit.framework.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public final class WelcomeTestPage {
  @Inject
  WebDriver driver;
  
  @Inject
  @PortNumber
  int portNumber;
  
  public void goTo() {
    driver.get("http://localhost:" + portNumber);
  }
  
  public void assertWelcomeMessage() {
    WebElement element = driver.findElement(By.xpath("//div[@id='welcome']"));
    TestCase.assertEquals("Welcome!", element.getText());
  }
  
  public void assertTitle() {
    TestCase.assertEquals("Welcome to the pet store", driver.getTitle());
  }

  public void assertPetOfTheMonth(PetOfTheMonth petOfTheMonth) {
    WebElement element = driver.findElement(By.xpath("//div[@id='potm']"));
    TestCase.assertEquals(petOfTheMonth.toString(), element.getText());
  }
}