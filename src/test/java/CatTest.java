import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class CatTest {

    Cat cat;
    @Mock
    Feline feline;

    @Test
    public void constructorCat(){
        cat = new Cat(feline);
    }

    @Test
    public void soundTest(){
        cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound(),"Ожидается Мяу");
    }

    @Test
    public void getFoodTest() throws Exception {
        cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Хищник"));
        List<String> expected = List.of("Хищник");
        assertEquals(expected,cat.getFood(),"Ожидается Хищник");
    }
}
