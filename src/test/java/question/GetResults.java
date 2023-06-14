package question;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.questions.TextContent;
import net.serenitybdd.screenplay.questions.targets.TheTarget;
import ui.CalcularPrestaciones;

import static ui.CalcularPrestaciones.*;


public class GetResults implements Question<String> {


    public static Question<String> resultadoTipoCalculo(){

        return  actor ->TIPO_CALCULO.resolveFor(actor).getValue();
    }

    public static Question<String> resultadoAFPpatronal() {

        return actor -> AFP_PATRONAL.resolveFor(actor).getValue();

    }
    public static Question<String> resultadoISSSpatronal() {

        return actor -> ISSS_PATRONAL.resolveFor(actor).getValue();
    }
    public static Question<String> resultadoISSSlaboral() {

        return actor -> ISSS.resolveFor(actor).getValue();
    }
    public static Question<String> resultadoAFPlaboral() {

        return actor -> AFP.resolveFor(actor).getValue();
    }
    public static Question<String> resultadoSalarioMenosAfp() {

        return actor -> SALARIO_AFP.resolveFor(actor).getValue();
    }
    public static Question<String> resultadoDescuento() {

        return actor -> DESCUENTO_TOTAL.resolveFor(actor).getValue();
    }
    public static Question<String> resultadoRenta() {

        return actor -> RENTA.resolveFor(actor).getValue();
    }
    public static Question<String> resultadoNeto() {

        return actor -> SALARIO_NETO.resolveFor(actor).getValue();
    }

    @Override
    public String answeredBy(Actor actor) {
        return null;
    }
}
