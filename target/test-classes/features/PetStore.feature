
  Feature: Gestión de ordenes de la tienda
    @CrearOrden
    Scenario Outline: Crear una nueva orden
      Given dado que estoy en la pagina
      When creo una orden con id<id>, petId<petId>, quantity<quantity>
      Then el código de estado de la respuesta debe ser <codigo>
      And la respuesta debe contener el id<id>, petId<petId>, quantity<quantity>
      Examples:
      |id|petId|quantity|codigo|
      |201|2   |3       |200   |
      |202|3   |1       |200   |
      |203|3   |1       |200   |
      |204|3   |1       |200   |


      @ConsultarOrden
      Scenario Outline: Consultar una nueva orden creada
        Given dado que voy a consultar en la pagina
        When consulto una orden con id <id>
        Then el código de estado de la respuesta debe ser <codigo>
        Examples:
          | id  | codigo |
          | 1   | 200    |
          | 10  | 200    |
          | -6 | 404   |
