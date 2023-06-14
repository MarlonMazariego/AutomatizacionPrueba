package question;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class CalculationResult {
    public static Double resultadoTipoCalculo(double salario, String tipo) {
        Double sfinal = (double) 0;
        if(tipo.equals("AFPpatronal")){
            sfinal= afpPatronal(salario, tipo);
        }
        if(tipo.equals("AFPlaboral")){
            sfinal= afpLaboral(salario);
        }
        if(tipo.equals("ISSSlaboral")){
            sfinal = isssLaboral(salario);
        }
        if(tipo.equals("ISSSpatronal")){
            sfinal = isssPatronal(salario, tipo);
        }
        if(tipo.equals("salarioAfp")){
            sfinal = salario-(isssLaboral(salario));
        }
        return sfinal;
    }
    public static Double renta(Double monto, String tipo){
        Double sfinal = (double) 0;
        Double gravado = (monto -(afpLaboral(monto)+isssLaboral(monto)));
        if(tipo.equals("Mensual")) {
            if (gravado >= 0 && gravado <= 472.00) {
                sfinal = 0.00;
            } else if (gravado >= 472.01 && gravado <= 895.24) {
                sfinal = ((gravado- 472.00) * 0.1) + 17.67;
            } else if (gravado >= 895.25 && gravado <= 2038.10) {
                sfinal = ((gravado - 895.24) * 0.2) + 60;
            } else if (gravado >= 2038.11 && gravado <= 1000000000) {
                sfinal = ((gravado - 2038.10) * 0.3) + 288.57;
            }
        }

        if(tipo.equals("Quincenal")) {
            if (gravado >= 0 && gravado <= 236.00) {
                sfinal = 0.00;
            } else if (gravado >= 236.01 && gravado <= 447.62) {
                sfinal = ((gravado- 236.00) * 0.1) + 8.83;
            } else if (gravado >= 447.63 && gravado <= 1019.05) {
                sfinal = ((gravado - 447.62) * 0.2) + 30;
            } else if (gravado >= 1019.06 && gravado <= 1000000000) {
                sfinal = ((gravado - 1019.05) * 0.3) + 144.28;
            }
        }

        if(tipo.equals("Semanal")) {
            if (gravado >= 0 && gravado <= 118.00) {
                sfinal = 0.00;
            } else if (gravado >= 118.01 && gravado <= 223.81) {
                sfinal = ((gravado - 118.00) * 0.1) + 4.42;
            } else if (gravado >= 223.82 && gravado <= 509.52) {
                sfinal = ((gravado - 223.81) * 0.2) + 15;
            } else if (gravado >= 509.53 && gravado <= 1000000000) {
                sfinal = ((gravado - 509.52) * 0.3) + 72.14;
            }

        }
        return sfinal;
    }

    public static Double isssLaboral(Double monto){
        Double sfinal = (double) 0;
        DecimalFormat formato = new DecimalFormat("###.##");
        if(monto>1000){
            sfinal = 30.00;
        }else{
            sfinal= monto*0.03;
        }

        return sfinal;
    }
    public static Double isssPatronal(Double monto, String tipo){
        Double sfinal = (double) 0;

        if(monto>1000){
            sfinal = 75.00;
        }else{
            sfinal= monto*0.075;
        }

        return sfinal;
    }
    public static Double afpPatronal(Double monto, String tipo){
        Double sfinal = (double) 0;
        sfinal= (monto*0.0775);

        return sfinal;
    }
    public static Double afpLaboral(Double monto){
        Double sfinal = (double) 0;

        sfinal= monto*0.0725;

        return sfinal;
    }
    public static Double afpMenosSalario(Double monto){
        Double sfinal = (double) 0;

        sfinal= monto-afpLaboral(monto);
        DecimalFormat formato = new DecimalFormat("###.00");
        return Double.parseDouble(formato.format(sfinal));
    }
    public static Double descuento(Double monto, String tipo){
        Double sfinal = (double) 0;
        DecimalFormat formato = new DecimalFormat("###.00");
        sfinal= afpLaboral(monto)+isssLaboral(monto)+renta(monto, tipo);

        return Double.parseDouble(formato.format(sfinal));
    }
    public static Double liquido(Double monto, String tipo){
        Double sfinal = (double) 0;
        DecimalFormat formato = new DecimalFormat("###.00");
        sfinal=(monto-(afpLaboral(monto)+isssLaboral(monto)+renta(monto, tipo)));

        return Double.parseDouble(formato.format(sfinal));
    }
    public static String twoDecimals(double value){
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(value);
    }


}
