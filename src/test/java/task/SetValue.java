package task;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import ui.CalcularPrestaciones;

public class SetValue {
    public static Performable setSalario(String salario, String tipo){
        return Task.where("{0} Digita salario y tipo",
                Scroll.to(CalcularPrestaciones.INGRESA_TU_SALARIO_TEXTO),
                Enter.theValue(salario).into(CalcularPrestaciones.SALARIO),
                SelectFromOptions.byVisibleText(tipo).from(CalcularPrestaciones.TIPO));
    }
}
