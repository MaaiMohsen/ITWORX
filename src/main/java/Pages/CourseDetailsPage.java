package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class CourseDetailsPage {
    private WebDriver driver;
    private By allCourses = By.id("btnMyCoursesList");

    public CourseDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public CoursesPage getAllCourses(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            System.out.println(driver.switchTo().alert().getText());
            alert.accept();
        } catch (Exception e) {
            //exception handling
        }
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(allCourses).click();
        return new CoursesPage(driver);
    }
}
