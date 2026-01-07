package com.example.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.example.models.Pet;
import com.example.tasks.PetTask;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.is;

public class PetStepDefinitions {
    @Managed
    WebDriver driver;

    private Actor usuario;
    @Before
    public void setUp() {
        usuario = Actor.named("Harold");
        usuario.can(CallAnApi.at("https://petstore.swagger.io/v2"));
    }
    
    @When("creo una nueva mascota con id {long} y nombre {string}")
    public void createPet(long id, String name) {
        Pet myPet = new Pet(id, name, "available");
        usuario.attemptsTo(
            PetTask.withInfo(myPet)
        );
    }

    @When("consulto la mascota con id {long}")
    public void getPet(long id) {
        usuario.attemptsTo(PetTask.withId(id));
    }

    @When("actualizo la mascota {long} con el nuevo nombre {string}")
    public void updatePet(long id, String newName) {
        Pet updatedPet = new Pet(id, newName, "sold");
        usuario.attemptsTo(PetTask.withInfoActualizar(updatedPet));
    }

    @When("elimino la mascota con id {long}")
    public void deletePet(long id) {
        usuario.attemptsTo(PetTask.delate(id));
    }

    @Then("el código de respuesta debería ser {int}")
    public void verifyStatusCode(int code) {
        usuario.should(
        seeThat("El código de respuesta de la API", 
            actor -> SerenityRest.lastResponse().getStatusCode(), 
            is(code)
        )
        );
    }

    
}
