package steps;

import Pages.*;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;

public class MyStepdefs {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private CoursesPage coursesPage;
    Faker faker = new Faker();
    private String courseName = faker.name().firstName();
    private AddNewCoursePage addNewCoursePage;
    private CourseDetailsPage courseDetailsPage;

    @Given("User is logged in to WINJIGO website")
    public void userIsLoggedInToWINJIGOWebsite() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://swinji.azurewebsites.net");
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);

        loginPage.setEmail("testregister@aaa.com");
        loginPage.setPassword("Wakram_123");
        homePage = loginPage.clickLogin();
    }

    @When("User creates new course")
    public void userCreatesNewCourse() {
        coursesPage = homePage.openCoursesPage();
        addNewCoursePage = coursesPage.createNewCourse();
        addNewCoursePage.setCoursePhoto();
        addNewCoursePage.setCourseName(courseName);
        addNewCoursePage.setSubject("Creative Arts");
        addNewCoursePage.setGrade("1");
        addNewCoursePage.setCourseTeacher();
        courseDetailsPage = addNewCoursePage.createNewCourse();
    }

    @And("User search for the created course")
    public void userSearchForTheCreatedCourse() {
       coursesPage = courseDetailsPage.getAllCourses();
       coursesPage.searchCourses(courseName);
    }

    @Then("Created course should be returned in the list")
    public void createdCourseShouldBeReturnedInTheList() {
        Assert.assertTrue(coursesPage.getSearchCount() > 0);
        Assert.assertTrue(coursesPage.isCourseExisting(courseName));
        driver.quit();
    }
}
