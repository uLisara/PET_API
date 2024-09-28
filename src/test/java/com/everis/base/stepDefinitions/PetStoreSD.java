package com.everis.base.stepDefinitions;

import com.everis.base.PetStoreStep;
import com.everis.base.models.Orden;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PetStoreSD {

    @Steps
    PetStoreStep petStore;
    @Given("dado que estoy en la pagina")
    public void dadoQueEstoyEnLaPagina() {
    }

    @Given("dado que voy a consultar en la pagina")
    public void dadoQueVoyAConsultarEnLaPagina() {
    }

    @When("creo una orden con id{int}, petId{int}, quantity{int}")
    public void creoUnaOrdenConIdIdPetIdPetIdQuantityQuantity(int id, int petId, int quantity){
        petStore.crearOrden(id,petId, quantity);
    }

    @Then("el código de estado de la respuesta debe ser {int}")
    public void elCódigoDeEstadoDeLaRespuestaDebeSerCodigo(int codigo) {
        petStore.validarCodigoRespuesta(codigo);
    }

    @And("la respuesta debe contener el id{int}, petId{int}, quantity{int}")
    public void laRespuestaDebeContenerElIdIdPetIdPetIdQuantityQuantity(int id, int petId, int quantity) {
        Orden orden = petStore.obtenerRespuestaOrder();
        assertNotNull(orden);
        assertEquals(id, orden.getId());
        assertEquals(petId, orden.getPetId());
        assertEquals(quantity, orden.getQuantity());
    }

    @When("consulto una orden con id {int}")
    public void consultoUnaOrdenConIdId(int codigo) {
        petStore.consultarOrdenPet(codigo);
    }


        
    }


