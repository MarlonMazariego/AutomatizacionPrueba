package ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends PageObject {
    @Override
    protected void setDriver(WebDriver driver, long timeout){
        super.setDriver(driver,timeout);
    }
    public static Target VER_MAS = Target.the("Ver mas")
            .located(By.cssSelector("a[href='/calcular-prestaciones']"));
    public static  Target CALCULAR_PRESTACIONES_TEXTO = Target.the("Calcular prestaciones")
            .located(By.xpath("//span[normalize-space()='Calcular prestaciones']"));
}
