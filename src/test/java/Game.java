import Base.Browserfactory;
import Base.FileReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class Game extends FileReader
{
    public WebDriver driver;

    @Test
    public void Gameytest() throws IOException {
        Browserfactory browserfactory = Browserfactory.getInstance();
        driver = browserfactory.instanciateBrowser();
        driver.get("https://keytodatascience.com/games");
        driver.findElement(By.xpath("//button[text()='Start']")).click();
        //Thread.sleep(2000);
        List<WebElement> numbers = driver.findElements(By.xpath("//div[@class='col']//div"));
        int j=1;
        while (j<=25)
        {
            for (int i = 0; i < 25; i++)
            {
                if (Integer.parseInt(numbers.get(i).getText()) == j)
                {
                    numbers.get(i).click();
                    j++;
                    break;
                }
            }
        }
        numbers.clear();
        numbers = driver.findElements(By.xpath("//div[@class='col']//div"));
        int temp=0;
        while (j<=50)
        {
            for(int i=0;i<25;i++)
            {
                String s=numbers.get(i).getText();
                if(!s.equalsIgnoreCase(""))
                    temp =Integer.parseInt(s);
                if(temp==j)
                {
                    numbers.get(i).click();
                    j++;
                    break;
                }
            }
        }

    }
}
