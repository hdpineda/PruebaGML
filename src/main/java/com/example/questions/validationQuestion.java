package com.example.questions;

import com.example.pages.HomePage;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;


public class validationQuestion {

    public static Question<String> messageAuth() {
        return new Question<String>() {
            @Override
            public String answeredBy(Actor actor) {
                return HomePage.FLASH_MESSAGE.resolveFor(actor).getText();
            }
        };
    }

    public static Question<Boolean> isFirstCheckboxSelected() {
        return new Question<Boolean>() {
            @Override
            public Boolean answeredBy(Actor actor) {
                return HomePage.FIRST_CHECKBOX.resolveFor(actor).isSelected();
            }
        };
    }

    public static Question<Boolean> selectedOptionInDropdown(String option) {
        return new Question<Boolean>() {
            @Override
            public Boolean answeredBy(Actor actor) {
                return HomePage.optionInDropdown(option).resolveFor(actor).isSelected();
            }
        };
    }

}
