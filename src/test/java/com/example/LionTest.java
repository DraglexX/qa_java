package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LionTest {

    private Feline felineMock;

    @BeforeEach
    public void setup() {
        felineMock = mock(Feline.class);
    }

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    public void lionHasCorrectManeBasedOnSex(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(sex, felineMock);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @Test
    public void getKittensUsesFelineMock() {
        when(felineMock.getKittens()).thenReturn(5);
        try {
            Lion lion = new Lion("Самец", felineMock);
            assertEquals(5, lion.getKittens());
        } catch (Exception e) {
            fail("Constructor threw exception unexpectedly");
        }
    }

    @Test
    public void getFoodUsesFelineMock() throws Exception {
        List<String> food = List.of("Мясо", "Курица");
        when(felineMock.getFood("Хищник")).thenReturn(food);
        Lion lion = new Lion("Самка", felineMock);
        assertEquals(food, lion.getFood());
    }

    @Test
    public void throwsExceptionIfSexInvalid() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Робот", felineMock);
        });
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
}
