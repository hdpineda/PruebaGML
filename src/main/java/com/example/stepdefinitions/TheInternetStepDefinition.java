package com.example.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.GivenWhenThen;
import org.openqa.selenium.WebDriver;
import com.example.tasks.HomeTask;
import com.example.pages.HomePage;
import com.example.questions.validationQuestion;
import static org.hamcrest.Matchers.is;


public class TheInternetStepDefinition {
    @Managed
    WebDriver driver;

    private Actor usuario;
    @Before
    public void setUp() {
        usuario = Actor.named("Harold");
        usuario.can(BrowseTheWeb.with(driver));
    }

    @Given("que {string} ingresa a la página principal de {string}")
    public void queIngresaALaPaginaPrincipalDe(String string, String string2) {
        usuario.attemptsTo(
            Open.browserOn().the(HomePage.class)
        );
    }
    // escenario 1
    @When("ingresa sus credenciales de {string}")
    public void ingresaSusCredencialesDe(String string) {
        usuario.attemptsTo(
            HomeTask.basicAuth()
        );
        
    }

    @Then("debería ver el mensaje de autenticación")
    public void deberiaVerElMensajeDeAutenticacion() {
        usuario.should(
            GivenWhenThen.seeThat(
                validationQuestion.messageAuth(),
                is("Congratulations! You must have the proper credentials.")
            )
        );
        
    }
    
    
    // escenario 2
    @When("navega a la página de Checkboxes selecciona la primera casilla")
    public void navegaALaPaginaDeCheckboxesSeleccionaLaPrimeraCasilla() {
        usuario.attemptsTo(
            HomeTask.selectFirstCheckbox()
        );
    }
    @Then("la casilla debería estar marcada")
    public void laCasillaDeberiaEstarMarcada() {
        usuario.should(
            GivenWhenThen.seeThat(
                validationQuestion.isFirstCheckboxSelected(),
                is(true)
            )
        );
    }

    // escenario 3
    @When("navega a la página de Dropdown selecciona la opción {string}")
    public void navegaALaPaginaDeDropdownSeleccionaLaOpcion(String option) {
        usuario.attemptsTo(
            HomeTask.selectDropdownOption(option)
        );

    }
    @Then("debería ver que la opción seleccionada es {string}")
    public void deberíaVerQueLaOpcionSeleccionadaEs(String option) {
        usuario.should(
            GivenWhenThen.seeThat(
                validationQuestion.selectedOptionInDropdown(option),
                is(true)
            )
        );
        
    }

}
