package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTest {

    Feline feline = new Feline();

    @Test
    public void getKittensReturnsDefaultOne() {
        assertEquals(1, feline.getKittens());
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "1, 1",
            "3, 3",
            "10, 10"
    })
    public void getKittensReturnsCorrectCount(int input, int expected) {
        assertEquals(expected, feline.getKittens(input));
    }

    @Test
    public void getFamilyReturnsCorrectValue() {
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void eatMeatReturnsPredatorFood() throws Exception {
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.eatMeat());
    }
}
