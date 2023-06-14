package task;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import ui.CalcularPrestaciones;

public class ClickOn {
    public static Performable clickCalcular(){
        return Task.where("{0 Click en boton Calcular}",Click.on(CalcularPrestaciones.CALCULAR));
    }
    public static Performable clickBorrar(){
        return Task.where("{0 Click en boton Borrar}",Click.on(CalcularPrestaciones.CALCULAR));
    }
}
