package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By coursesButton = By.id("btnMyCoursesList");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public CoursesPage openCoursesPage(){
        driver.findElement(coursesButton).click();
        return new CoursesPage(driver);
    }
}
