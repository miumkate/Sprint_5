import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    Lion lion;
    String sex;

    @Mock
    Feline feline;

    @Test
    public void constructorFemaleTest() throws Exception{
        sex = "Самка";
        lion = new Lion(sex,feline);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    public void constructorMaleTest() throws Exception{
        sex = "Самец";
        lion = new Lion(sex,feline);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void constructorExceptionTest(){
        sex = "Оно";
        Throwable exception = assertThrows(Exception.class, () -> lion = new Lion(sex,feline));
        assertEquals("Используйте допустимые значения пола животного: самец или самка", exception.getMessage());

    }

    @Test
    public void lionGetKittensTest() throws Exception {
        lion = new Lion("Самка", feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1,lion.getKittens(),"Количество котят = 1");

    }

    @ParameterizedTest
    @CsvSource({"Самец, true", "Самка, false"})
    public void lionHasMaleTest(String sex, boolean result) throws Exception{
        lion = new Lion(sex, feline);
        assertEquals(result, lion.doesHaveMane(),"Передали параметр: " + sex + ". Ожидается, что грива:  " + result);
    }

    @Test
    public void getFoodForLionTest() throws Exception {
        lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные, Птицы, Рыбы"));
        List<String> expected = List.of("Животные, Птицы, Рыбы");
        assertEquals(expected,lion.getFood(),"Ожидается еда для хищника");
    }
}
