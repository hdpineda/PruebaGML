@SuiteCompleta
Feature: Interacción con diferentes componentes de The Internet

  Como un automatizador
  Quiero interactuar con diversos elementos web
  Para validar el funcionamiento de los componentes UI

  Background: Background name:
    Given que "Harold" ingresa a la página principal de "The Internet"

  @EscenarioExitoso
  Scenario: Inicio de sesión exitoso por rol
    When ingresa sus credenciales de "admin"
    Then debería ver el mensaje de autenticación

  @Checkboxes
  Scenario: Selección de casillas de verificación
    When navega a la página de Checkboxes selecciona la primera casilla
    Then la casilla debería estar marcada

  @Dropdown
  Scenario: Selección de opciones en una lista desplegable
    When navega a la página de Dropdown selecciona la opción "Option 2"
    Then debería ver que la opción seleccionada es "Option 2"