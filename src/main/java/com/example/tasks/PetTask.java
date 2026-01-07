package com.example.tasks;

import com.example.models.Pet;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class PetTask {

    public static Performable withInfo(Pet pet){
        return Task.where("servicio post",
                Post.to("/pet")
                        .with(request -> request
                                .header("Content-Type", "application/json")
                                .body(pet)
                        )

        );

    }
    public static Performable withId(long petId){
        return Task.where("servico get",
        Get.resource("/pet/{petId}")
                .with(request -> request.pathParam("petId", petId))
            
        );
    }

    public static Performable withInfoActualizar(Pet pet){
        return Task.where("servicio put",
            Put.to("/pet")
                .with(request -> request.header("Content-Type", "application/json").body(pet))
        );
    }

    public static Performable delate(long petId){
        return Task.where("servicio delete",
            Delete.from("/pet/{petId}")
                .with(request -> request.pathParam("petId", petId))
        );
    }
    
}
