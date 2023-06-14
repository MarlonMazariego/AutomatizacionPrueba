Feature: calcularPrestaciones
  Como usuario quiero calcular prestaciones mensuales, quincenales y mensuales

  Scenario Outline: calcular prestacion salarial
    Given usuario visita web de jmb auditores
    When busca el apartado de calcular prestaciones
    When selecciona enlace ver mas
    Then usuario ingresa "<salario>" y "<periodo>"
    Then da click en boton para calcular
    Then ver resultados del calculo
    Examples:
      | salario | periodo |
      | 900 | Mensual |
      | 225 | Quincenal |
      | 100 | Semanal |


