package com.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    Animal animal = new Animal();

    @Test
    public void getFoodReturnsPlantListForHerbivore() throws Exception {
        List<String> expected = List.of("Трава", "Различные растения");
        assertEquals(expected, animal.getFood("Травоядное"));
    }

    @Test
    public void getFoodReturnsMeatListForPredator() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, animal.getFood("Хищник"));
    }

    @Test
    public void getFoodThrowsExceptionForUnknownType() {
        Exception exception = assertThrows(Exception.class, () -> {
            animal.getFood("Инопланетянин");
        });
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    @Test
    public void getFamilyReturnsExpectedText() {
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, animal.getFamily());
    }
}
