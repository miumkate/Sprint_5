import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTest {
    Feline feline;

    @BeforeEach
    public void createFeline(){
        feline = new Feline();
    }

    @Test
    public void eatMeatTest() throws Exception {
        assertEquals("[Животные, Птицы, Рыбы]",feline.eatMeat().toString(),"Ожидается пища для хищника.");
    }

    @Test
    public void getFamilyTest(){
        assertEquals("Кошачьи",feline.getFamily(),"Ожидается семейство Кошачьи.");
    }

    @Test
    public void getKittensNullCountTest(){
        assertEquals(1,feline.getKittens(),"Ожидается один котёнок");
    }

    @ParameterizedTest
    @ValueSource(ints = {0,5,11,-5})
    public void getKittensCountTest(int count){
        assertEquals(count,feline.getKittens(count),"Ожидается "+ count +" котят");
    }

}
