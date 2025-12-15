import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class VitimexTest{

    WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.vietjetair.com/vi/");
    }

    @Test
    public void loginAndSearchFlight() throws InterruptedException {

        // ===== Đồng ý cookie =====
        driver.findElement(By.xpath("//h5[normalize-space()='Đồng ý']")).click();
        Thread.sleep(5000);

        // ===== Đăng nhập =====
        driver.findElement(By.xpath("//span[normalize-space()='Đăng nhập']")).click();
        Thread.sleep(30000);

        // ===== Chọn Một chiều =====
        driver.findElement(
                By.xpath("//label[contains(normalize-space(),'Một chiều')]")
        ).click();
        Thread.sleep(5000);

        // ===== Điểm đi =====
        driver.findElement(By.tagName("body")).click();
        Thread.sleep(2000);

        // ===== Điểm khởi hành =====
        driver.findElement(
                By.xpath("//div[@role='button' and .//p[normalize-space()='Điểm khởi hành']]")
        ).click();
        Thread.sleep(3000);

        // Chọn Jakarta (quốc tế)
        driver.findElement(
                By.xpath("//*[contains(normalize-space(),'Hà Nội')]")
        ).click();
        Thread.sleep(3000);

        // ===== Điểm đến =====
        driver.findElement(
                By.xpath("//div[@role='button' and .//p[normalize-space()='Điểm đến']]")
        ).click();
        Thread.sleep(3000);

        // Chọn TP. Hồ Chí Minh
        driver.findElement(
                By.xpath("//*[contains(normalize-space(),'Hồ Chí Minh')]")
        ).click();
        Thread.sleep(3000);

        // ===== Ngày đi =====
        driver.findElement(
                By.xpath("//div[@role='button' and .//p[normalize-space()='Ngày đi']][1]")
        ).click();
        Thread.sleep(3000);

        // Chọn ngày khả dụng đầu tiên
        driver.findElement(
                By.xpath("(//div[contains(@class,'DayPicker-Day') and " +
                        "not(contains(@class,'disabled'))])[1]")
        ).click();
        Thread.sleep(3000);

        // ===== Tìm chuyến bay =====
        driver.findElement(
                By.xpath("//span[normalize-space()='Tìm chuyến bay']/ancestor::button")
        ).click();
        Thread.sleep(10000);

        System.out.println("✅ Đã tìm chuyến bay 1 chiều Jakarta → TP.HCM");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
