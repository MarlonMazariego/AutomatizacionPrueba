package task;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import ui.CalcularPrestaciones;
import ui.Home;

public class SearchSeccion {
    public static Performable calcularPrestacionSec(){
        return Task.where("{0} realiza scroll a seccion calcular prestaciones",
        Scroll.to(Home.CALCULAR_PRESTACIONES_TEXTO));
    }

    public static Performable clickVerMas(){
        return Task.where("{0} realiza click en Ver Mas",
                Click.on(Home.VER_MAS));
    }

    public static Performable finTablaCalculo(){
        return Task.where("{0} Visualiza toda la tabla de resultado",
                Scroll.to(CalcularPrestaciones.TEXTO_ISSS_PATRONAL));
    }
}
