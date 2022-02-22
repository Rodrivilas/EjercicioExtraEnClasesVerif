package ejercicioEnClase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class MetodosBeckaMockYStaticTest {
    Utils utilsmock= Mockito.mock(Utils.class);
    @BeforeAll
    public static void before(){
        MockedStatic<Helpers> helpersmock= Mockito.mockStatic(Helpers.class);
        helpersmock.when(()-> Helpers.aplicaBeca("10933055")).thenReturn(false);
        helpersmock.when(()-> Helpers.aplicaBeca("21133055")).thenReturn(true);
    }

    @Test
    public void conBeca(){
        Mockito.when(utilsmock.getNota("10933055")).thenReturn(20);
        MetodosBeca metodosBeca=new MetodosBeca(utilsmock);
        String expected ="";
        String actual = metodosBeca.recomendacionBeca("10933055");
        Assertions.assertEquals(expected,actual,"Errror");
        Mockito.verify(utilsmock).getNota("10933055");
    }
}
