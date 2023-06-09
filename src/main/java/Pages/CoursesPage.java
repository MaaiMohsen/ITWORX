package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoursesPage {
    private WebDriver driver;
    private By addNewCourseButton = By.id("btnListAddCourse");
    private By searchField = By.id("txtCourseSearch");
    private By searchButton = By.id("btnCourseSearch");
    private By searchCount = By.id("spnTotalSearchResultsCount");

    public CoursesPage(WebDriver driver) {
        this.driver = driver;
    }

    public AddNewCoursePage createNewCourse(){
        driver.findElement(addNewCourseButton).click();
        return new AddNewCoursePage(driver);
    }

    public void searchCourses(String courseName){
        driver.findElement(searchField).sendKeys(courseName);
        driver.findElement(searchButton).click();
    }

    public int getSearchCount(){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchCount));
        return Integer.valueOf(driver.findElement(searchCount).getText());
    }

    public boolean isCourseExisting(String courseName){
        String cssSelector = "li[data-winji-course='" + courseName + "']";
         return driver.findElements(By.cssSelector(cssSelector)).size() !=0;
    }
}
