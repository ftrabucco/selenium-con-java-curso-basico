package curso.selenium.basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElements {
    public static void main (String[] args){
        WebDriver driver;
        String baseUrl="http://live.guru99.com/index.php/tv.html";
        String actualResult="";
        String expectedResult="$615.00";
        String chromePath=System.getProperty("user.dir")+"\\drivers\\chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.get(baseUrl);

        driver.manage().window().maximize();

        //clic en el link TV
        WebElement lnkTV = driver.findElement(By.linkText("TV"));
        lnkTV.click();

        //clic en el boton ADD TO CART
        WebElement btnAddToCar= driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button/span/span"));
        btnAddToCar.click();

        //obtener el precio
        WebElement lblSubtotal =driver.findElement(By.cssSelector("#shopping-cart-table>tbody>tr>td.product-cart-total>span>span"));
        actualResult=lblSubtotal.getText();


        if (actualResult.contentEquals(expectedResult)){
            System.out.println("Prueba Pasada! el resultado actual es: "+ actualResult +" es igual a "+ expectedResult);
        }else{
            System.out.println("Prueba Fallada! el resultado actual es: "+ actualResult +" no es igual a "+ expectedResult);
        }

        driver.close();
    }
}
