package com.everis.base;

import com.everis.base.models.Orden;
import static io.restassured.RestAssured.given;

public class PetStoreStep {


    private String URL_BASE= "https://petstore.swagger.io/v2";
    private int codigoRespuesta;
    private Orden respuestaOrder;
    private String respuestaError;

    //CREAR ORDEN
    public void crearOrden(int id, int petId, int quantity){

        Orden nuevaOrden = new Orden(id, petId, quantity);

        codigoRespuesta = given()
                .baseUri(URL_BASE)
                .contentType("application/json")
                .body(nuevaOrden)
                .when()
                .post("/store/order")
                .then()
                .statusCode(200)
                .extract()
                .statusCode();

        respuestaOrder = given()
                .baseUri(URL_BASE)
                .when()
                .get("/store/order/"+id)
                .as(Orden.class);

        System.out.println("ID Creado: " + respuestaOrder.getPetId());
        System.out.println("PetID Creado: " + respuestaOrder.getPetId());
        System.out.println("Quantity Creado: " + respuestaOrder.getQuantity());

    }


    public void validarCodigoRespuesta(int codigoEsperdo){
        if(codigoRespuesta != codigoEsperdo){
            throw new AssertionError("Código esperado: " +codigoEsperdo + "Código Obtenido: " +codigoRespuesta);
        }
    }

    public Orden obtenerRespuestaOrder(){
        return respuestaOrder;
    }

    public void consultarOrdenPet(int id){
        codigoRespuesta = given()
                .baseUri(URL_BASE)
                .when()
                .get("/store/order/" + id)
                .then()
                .extract()
                .statusCode();

        if (codigoRespuesta == 200) {
            respuestaOrder = given()
                    .baseUri(URL_BASE)
                    .when()
                    .get("/store/order/" + id)
                    .as(Orden.class);
        } else if (codigoRespuesta == 404) {
            respuestaError = given()
                    .baseUri(URL_BASE)
                    .when()
                    .get("/store/order/" + id)
                    .then()
                    .extract()
                    .path("message");
        } else {
            throw new RuntimeException("Error al consultar la orden. Código: " + codigoRespuesta);
        }
        }

    }




