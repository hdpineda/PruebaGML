package com.example.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import com.example.pages.HomePage;

public class HomeTask {
    public static Performable basicAuth() {
        return Task.where("{0} inicia sesión",
        Open.url("https://admin:admin@the-internet.herokuapp.com/basic_auth")
        );
        
    }

    public static Performable selectFirstCheckbox() {
        return Task.where("{0} selecciona la primera casilla",
        Click.on(HomePage.CHECKBOXES),
        Click.on(HomePage.FIRST_CHECKBOX)
        );
    }

    public static Performable selectDropdownOption(String option) {
        return Task.where("{0} selecciona la opción " + option,
        Click.on(HomePage.DROPDOWN),
        Click.on(HomePage.optionInDropdown(option))
        );
    }
    
}
