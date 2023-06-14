package stepdefinitions;


import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import question.CalculationResult;
import question.GetResults;
import task.*;


import static org.hamcrest.Matchers.equalTo;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;

public class CalcularPrestaciones {
    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    String actor = "Marlon";
    String tipo;
    Double monto;


    @Given("usuario visita web de jmb auditores")
    public void usuario_visita_web_de_jmb_auditores() {
        theActorCalled(actor).attemptsTo(OpenBrowser.goJmbHome());
    }
    @When("busca el apartado de calcular prestaciones")
    public void busca_el_apartado_de_calcular_prestaciones() {
        withCurrentActor(SearchSeccion.calcularPrestacionSec());
    }
    @When("selecciona enlace ver mas")
    public void selecciona_enlace_ver_mas() {
        withCurrentActor(SearchSeccion.clickVerMas());
    }
    @Then("usuario ingresa {string} y {string}")
    public void usuario_ingresa_y(String salario, String periodo) {
        withCurrentActor(SetValue.setSalario( salario,  periodo));
        tipo = periodo;
        monto = Double.parseDouble(salario);
    }
    @Then("da click en boton para calcular")
    public void da_click_en_boton_para_calcular() {
        withCurrentActor(ClickOn.clickCalcular());

    }
    @Then ("ver resultados del calculo")
    public void ver_resultados_del_calculo(){

        withCurrentActor(SearchSeccion.finTablaCalculo());

        theActorInTheSpotlight().should(
                seeThat("Tipo de calculo seleccionado", GetResults.resultadoTipoCalculo(),equalTo(tipo)),
                seeThat("AFP Patronal ", GetResults.resultadoAFPpatronal(), equalTo("$"+CalculationResult.twoDecimals(CalculationResult.afpPatronal(monto, tipo)))),
                seeThat("ISSS Patronal ", GetResults.resultadoISSSpatronal(), equalTo("$"+CalculationResult.twoDecimals(CalculationResult.isssPatronal(monto, tipo)))),
                seeThat("ISSS Laboral ", GetResults.resultadoISSSlaboral(), equalTo("$"+CalculationResult.twoDecimals(CalculationResult.isssLaboral(monto)))),
                seeThat("AFP Laboral", GetResults.resultadoAFPlaboral(), equalTo("$"+CalculationResult.twoDecimals(CalculationResult.afpLaboral(monto)))),
                seeThat("Salario(-)AFP ", GetResults.resultadoSalarioMenosAfp(), equalTo("$"+CalculationResult.twoDecimals(CalculationResult.afpMenosSalario(monto)))),
                seeThat("Descuento total ", GetResults.resultadoDescuento(), equalTo("$"+CalculationResult.twoDecimals(CalculationResult.descuento(monto, tipo)))),
                seeThat("Impuesto sobre la renta", GetResults.resultadoRenta(), equalTo("$"+CalculationResult.twoDecimals(CalculationResult.renta(monto,tipo)))),
                seeThat("Salario liquido", GetResults.resultadoNeto(), equalTo("$"+CalculationResult.twoDecimals(CalculationResult.liquido(monto,tipo))))
        );

    }



}
