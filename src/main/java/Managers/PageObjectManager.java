package Managers;

import org.openqa.selenium.WebDriver;

import PageObjects.HomePage;

public class PageObjectManager {

    private final WebDriver webDriver;
    
   
    private HomePage homePage;

    public PageObjectManager(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    
    
    public HomePage getHomePage() {

        if (homePage == null) {
        	homePage = new HomePage(webDriver);
        }
        return homePage;
    }

    
}
