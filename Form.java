    package curso.selenium.basico;

    import org.openqa.selenium.*;
    import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.support.ui.Select;

    public class Form {
        static WebDriver driver;

        public static void main (String[]args){
            String chromePath=System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";
            String baseURL="http://newtours.demoaut.com/";
            System.setProperty("webdriver.chrome.driver",chromePath);
            driver=new ChromeDriver();
            driver.get(baseURL);
            driver.manage().window().maximize();

            try {
                driver.findElement(By.linkText("REGISTER")).click();

                WebElement txtFirstName= driver.findElement(By.name("firstName"));
                txtFirstName.sendKeys("Pepito");
                Thread.sleep(1500);
                txtFirstName.clear();
                Thread.sleep(1500);
                txtFirstName.sendKeys("Fran");

                driver.findElement(By.name("address1")).sendKeys("Test Adress");

                Select dropContry=new Select(driver.findElement(By.name("country")));
                Thread.sleep(2000);
                dropContry.selectByVisibleText("ARGENTINA");

                driver.findElement(By.id("email")).sendKeys("testmail@gmail.com");
                driver.findElement(By.name("password")).sendKeys("123");

                WebElement txtConfirm = driver.findElement(By.name("confirmPassword"));
                txtConfirm.sendKeys("123");

                txtConfirm.submit();

                System.out.println("Prueba exitosa"+driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")).getText());

            } catch (NoSuchElementException ne){
                System.err.println("No se encontro el webElement" + ne.getMessage());
            }catch (WebDriverException we){
                System.err.println("Webriver Falló: "+ we.getMessage());
            }catch (Exception ex){
                System.err.println(ex.getMessage());
            } finally {
                driver.quit();
            }
        }
    }
