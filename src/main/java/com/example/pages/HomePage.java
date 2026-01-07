package com.example.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomePage extends PageObject{
    
    public void openPage() {
        this.open();
    }

    // elementos basic auth
    public static final Target BASIC_AUTH = Target.the("campo de usuario")
            .located(By.xpath("//a[contains(text(),'Basic Auth')]"));

    public static final Target FLASH_MESSAGE = Target.the("mensaje de alerta")
            .located(By.tagName("p"));
    
    // elementos Checkboxes
    public static final Target CHECKBOXES = Target.the("primera casilla")
            .located(By.xpath("//a[contains(text(),'Checkboxes')]"));
    public static final Target FIRST_CHECKBOX = Target.the("primera casilla para seleccionar")
            .located(By.xpath("//form[@id='checkboxes']/input[1]"));
    // elementos Dropdown
    public static final Target DROPDOWN = Target.the("menú desplegable")
            .located(By.xpath("//a[contains(text(),'Dropdown')]"));
    public static Target optionInDropdown(String option) {
        return Target.the("opción " + option + " del menú desplegable")
                .located(By.xpath("//select[@id='dropdown']/option[text()='" + option + "']"));
    }


    
}
