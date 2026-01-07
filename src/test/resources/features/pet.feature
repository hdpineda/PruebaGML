@API
Feature: Gestión de mascotas en Petstore

    @PostPet
    Scenario: Crear una mascota exitosamente
        When creo una nueva mascota con id 12345 y nombre "Snoopy"
        Then el código de respuesta debería ser 200

    @GetPet
    Scenario: Consultar una mascota existente
        When consulto la mascota con id 12345
        Then el código de respuesta debería ser 200

    @UpdatePet
    Scenario: Actualizar el nombre de una mascota
        When actualizo la mascota 12345 con el nuevo nombre "Snoopy Editado"
        Then el código de respuesta debería ser 200

    @DeletePet
    Scenario: Eliminar una mascota por ID
        When elimino la mascota con id 12345
        Then el código de respuesta debería ser 200