import com.fasterxml.jackson.core.JsonProcessingException;
import petstore.PetStore;
import petstore.PetStoreServices;
import petstore.models.Pet;
import org.junit.Test;
import utils.ArrayUtilities;
import utils.Printer;
import java.util.List;

import static utils.MappingUtilities.Json.*;

public class AppTest {

    static Printer printer = new Printer(AppTest.class);

    @Test
    public void getRandomItemTest() {
        List<Integer> numList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(ArrayUtilities.getRandomItemFrom(numList));
    }

    @Test
    public void dataGeneratorPetTest() {
        printer.info("Test!");
    }

    @Test
    public void stringToObjectTest() throws JsonProcessingException {
        Pet pet = fromJsonString("{\"id\" : null, \"category\" : {\"id\" : null, \"name\" : \"Cats\"},\"name\" : \"Whiskers\", \"photoUrls\" : [ \"https://example.com/cat.jpg\" ],\"tags\" : [ {\"id\" : 123456789, \"name\" : \"Furry\"}, {\"id\" : 987654321, \"name\" : \"Playful\"} ],\"status\" : \"Available\"}", Pet.class);
        System.out.println(getJsonStringFor(pet));
    }

    @Test
    public void petStatusTest() {
        PetStore petStore = new PetStore();
        petStore.getPetsByStatus(PetStoreServices.PetStatus.pending);
    }

    @Test
    public void petPostTest() {
        PetStore petStore = new PetStore();
        Pet pet = new Pet();
        pet.setName("doggie");
        List<String> photoUrls = List.of("string");
        pet.setPhotoUrls(photoUrls);
        pet.setStatus("available");
        petStore.postPet(pet);
    }
}
