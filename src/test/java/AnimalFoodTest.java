import com.example.Animal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalFoodTest {
    Animal animal;

    @BeforeEach
    void createAnimal(){
         animal = new Animal();
    }

    @ParameterizedTest
    @CsvSource({"Хищник, '[Животные, Птицы, Рыбы]'", "Травоядное, '[Трава, Различные растения]'"})
    void testGetFoodPredator(String type, String food) throws Exception {
        assertEquals(food,
                animal.getFood(type).toString(),
                "Ожидается соответствие пищи виду животного"
        );
    }

    @Test
    void  testGetFamily(){
       assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи",
               animal.getFamily(),
               "Ожидается перечисление семейств животных");
    }

    @Test
    void testGetFoodException(){
        Throwable exception = assertThrows(Exception.class, () -> animal.getFood("Червяк"));
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }
}
