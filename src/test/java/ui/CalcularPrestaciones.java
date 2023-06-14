package ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class CalcularPrestaciones extends PageObject {
    public static  By PRUEBA = By.xpath("//input[@id='afpPatronal']");

    public static final  Target INGRESA_TU_SALARIO_TEXTO = Target.the("Ingresa tu salario")
            .located(By.xpath("//td[normalize-space()='Ingresa tu salario:']"));
    public static  final Target SALARIO = Target.the("Salario").
            locatedBy("//input[@id='salario']");
    public static final Target TIPO = Target.the("Tipo")
            .locatedBy("#tipo");
    public static final Target CALCULAR = Target.the("Calcular")
            .locatedBy("#calcular");
    public static  final Target FINAL = Target.the("Borrar")
            .locatedBy("#borrar");
    public static  final Target TIPO_CALCULO = Target.the("Tipo Calculo")
            .located(By.cssSelector("#tipoCalculo"));
    public static  final Target  AFP_PATRONAL = Target.the("AFP Patronal")
            .located(By.xpath("//input[@id='afpPatronal']"));
    public static  final Target ISSS_PATRONAL = Target.the("ISSS Patronal")
            .locatedBy("#isssPatronal");
    public static  final Target ISSS = Target.the("ISSS Laboral")
            .locatedBy("#isss");
    public static  final Target AFP = Target.the("AFP Laboral")
            .locatedBy("#afp");
    public static  final Target SALARIO_AFP = Target.the("Salario (-) AFP")
            .locatedBy("#salario-afp");
    public static final Target DESCUENTO_TOTAL = Target.the("Descuento Total")
            .locatedBy("#descuentoT");
    public static  final Target RENTA = Target.the("Impuesto sobre la renta")
            .locatedBy("#renta");
    public static  final Target SALARIO_NETO = Target.the("Salario Liquido")
            .locatedBy("#salarioNeto");
    public static  final  Target TEXTO_ISSS_PATRONAL = Target.the("ISSS PATRONAL")
            .located(By.xpath("//td[normalize-space()='ISSS Patronal:']"));

}
