package com.javarush;
import com.javarush.kulikov.Cipher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class EncryptedTest {

    private Cipher cipher;

    @BeforeEach
    void initSetUp() {
        cipher = new Cipher();
    }

    @Test
    void verbagingTheShiftOne() {
        //Act
        var encrypt = cipher.encrypt("Привет мир!", 1);

        //Assert
        assertEquals("Рсйгжу нйс!", encrypt);
    }

    @Test
    void verbagingTheShiftEndAlphabet() {
        //Act
        var encrypt = cipher.encrypt("Привет мир!", 0);

        //Assert
        assertEquals("Привет мир!", encrypt);
    }

    @Test
    @DisplayName("Проверка на выбрасывание Exception")
    void verbagingTheShiftNegative() {
        //Assert
        assertThrows(IllegalArgumentException.class, () ->
            cipher.encrypt("Привет мир!", -1));
    }

}
