package helloselenium.authentication;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterCase {
    private WebDriver webDriver;
    @Before
    public void prepareTest(){
        // cần có để load driver.
        System.setProperty("webdriver.chrome.driver", "/home/xuanhung/Documents/chromedriver_linux64/chromedriver");
        // mở trình duyệt.
        webDriver = new ChromeDriver();
    }

    @Test
    public void testLoginFails_WithBlank_Email(){
        // truy cập đến trang login
        webDriver.get("https://accounts.gometaworld.io/service/login?service=MYACCOUNT&continue=https://myaccount.gometaworld.io/");
        // tìm đến input username.
        WebElement usernameInput = webDriver.findElement(By.id("email"));
        // tìm đến password input.
        WebElement passwordInput = webDriver.findElement(By.id("password"));
        // tìm đến nút login.
        WebElement btnLogin = webDriver.findElement(By.xpath("//button[text()=\"Login\"]"));
        // nhập dữ liệu vào input username.
        usernameInput.sendKeys("");
        // nhập dữ liệu vào input password, tạo case lỗi.
        passwordInput.sendKeys("");
        // click submit
        btnLogin.click();
        // lấy text trả về.
        String responseAfterSubmit = webDriver.getPageSource(); // bản chất không cần.
        // có một số trường hợp sẽ phải chờ response trả về. WebDriverWait
        // tìm đến phần tử password trong response mới trả về.
        WebElement newEmailInput = webDriver.findElement(By.id("email"));
        // lấy ra thằng bố.
        WebElement parentOfPassword = (WebElement) ((JavascriptExecutor) webDriver).executeScript(
                "return arguments[0].parentNode;", newEmailInput);
        // lấy ra thằng em của thằng bố.
        WebElement spanRedMessage = parentOfPassword.findElement(By.xpath("following-sibling::*"));
        // in ra text trả về.
        Assert.assertEquals(spanRedMessage.getText(), "* Email is invalid");
        webDriver.quit();
    }

    @Test
    public void testLoginFails_WithBlank_Password(){
        // truy cập đến trang login
        webDriver.get("https://accounts.gometaworld.io/service/login?service=MYACCOUNT&continue=https://myaccount.gometaworld.io/");
        // tìm đến input username.
        WebElement usernameInput = webDriver.findElement(By.id("email"));
        // tìm đến password input.
        WebElement passwordInput = webDriver.findElement(By.id("password"));
        // tìm đến nút login.
        WebElement btnLogin = webDriver.findElement(By.xpath("//button[text()=\"Login\"]"));
        // nhập dữ liệu vào input username.
        usernameInput.sendKeys("xuanhung2401@gmail.com");
        // nhập dữ liệu vào input password, tạo case lỗi.
        passwordInput.sendKeys("");
        // click submit
        btnLogin.click();
        // lấy text trả về.
        String responseAfterSubmit = webDriver.getPageSource(); // bản chất không cần.
        // có một số trường hợp sẽ phải chờ response trả về. WebDriverWait
        // tìm đến phần tử password trong response mới trả về.
        WebElement newPasswordInput = webDriver.findElement(By.id("password"));
        // lấy ra thằng bố.
        WebElement parentOfPassword = (WebElement) ((JavascriptExecutor) webDriver).executeScript(
                "return arguments[0].parentNode;", newPasswordInput);
        // lấy ra thằng em của thằng bố.
        WebElement spanRedMessage = parentOfPassword.findElement(By.xpath("following-sibling::*"));
        // in ra text trả về.
        Assert.assertEquals(spanRedMessage.getText(), "* Password is required.");
        webDriver.quit();
    }

    @Test
    public void testLogin_Success(){
        System.out.println("Test login fails");
    }
}
