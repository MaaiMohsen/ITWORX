package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewCoursePage {
    private WebDriver driver;
    private By selectCoverButton = By.id("spnPhotoCover");
    private By coverPhoto = By.id("imgAddEditCourses2");
    private By selectPhotoArea = By.cssSelector("div[class='lms-course-cover-dropdown fade-in-down custom-scroll visible']");
    private By courseName = By.id("txtCourseName");
    private By subjectDropdown = By.id("courseSubject");
    private By gradDropdown = By.id("courseGrade");
    private By courseTeacher = By.id("teacherOnBehalf");
    private By teacher = By.id("lnkCourseOwnerMail");
    private By createCourseButton = By.id("btnSaveAsDraftCourse");

    public AddNewCoursePage(WebDriver driver) {
        this.driver = driver;
    }

    public void setCoursePhoto(){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectCoverButton));
        driver.findElement(selectCoverButton).click();
        driver.findElement(coverPhoto).click();
        driver.findElement(selectPhotoArea).click();
    }

    public void setCourseName(String name){
        driver.findElement(courseName).sendKeys(name);
    }

    public void setSubject (String subject){
        Select dropdown = new Select(driver.findElement(subjectDropdown));
        dropdown.selectByVisibleText(subject);
    }

    public void setGrade (String grade){
        Select dropdown = new Select(driver.findElement(gradDropdown));
        dropdown.selectByVisibleText(grade);
    }

    public void setCourseTeacher(){
        driver.findElement(courseTeacher).click();
        driver.findElement(teacher).click();
    }

    public CourseDetailsPage createNewCourse(){
        driver.findElement(createCourseButton).click();
        return new CourseDetailsPage(driver);
    }
}
