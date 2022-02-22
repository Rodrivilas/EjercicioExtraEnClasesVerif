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
        helpersmock.when(()-> Helpers.aplicaBeca("1231234")).thenReturn(true);
        helpersmock.when(()-> Helpers.aplicaBeca("12341234")).thenReturn(true);
    }

    @Test
    public void noAplicaBeca(){
        MetodosBeca metodosBeca=new MetodosBeca(utilsmock);
        String expected ="EL ESTUDIANTE NO CURSO AUN EL 60% DE LAS MATERIAS";
        String actual = metodosBeca.recomendacionBeca("10933055");
        Assertions.assertEquals(expected,actual,"Error output no coincide");
    }

    @Test
    public void aplicaBeca(){
        Mockito.when(utilsmock.getNota("21133055")).thenReturn(95);
        MetodosBeca metodosBeca=new MetodosBeca(utilsmock);
        String expected ="SI APLICA A BECA";
        String actual = metodosBeca.recomendacionBeca("21133055");
        Assertions.assertEquals(expected,actual,"Error output no coincide");
        Mockito.verify(utilsmock).getNota("21133055");
    }

    @Test
    public void noAplicaBecaPromedio(){
        Mockito.when(utilsmock.getNota("1231234")).thenReturn(89);
        MetodosBeca metodosBeca=new MetodosBeca(utilsmock);
        String expected ="NO APLICA A BECA POR PROMEDIO ACADEMICO";
        String actual = metodosBeca.recomendacionBeca("1231234");
        Assertions.assertEquals(expected,actual,"Error output no coincide");
        Mockito.verify(utilsmock).getNota("1231234");
    }

    @Test
    public void aplicaBeca90(){
        Mockito.when(utilsmock.getNota("12341234")).thenReturn(90);
        MetodosBeca metodosBeca=new MetodosBeca(utilsmock);
        String expected ="SI APLICA A BECA";
        String actual = metodosBeca.recomendacionBeca("12341234");
        Assertions.assertEquals(expected,actual,"Error output no coincide");
        Mockito.verify(utilsmock).getNota("12341234");
    }
}
