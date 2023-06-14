package task;

import action.jbmPage;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class OpenBrowser {
    public static Performable goJmbHome(){
        return Task.where("{0} Abrir pagina principal de Jmb Auditores", Open.browserOn().the(jbmPage.class));
    }
}
