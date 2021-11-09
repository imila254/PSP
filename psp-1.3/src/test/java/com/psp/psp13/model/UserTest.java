package com.psp.psp13.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    @Test
    void UserFields_Test(){
        User user = new User( "Vardenis","Pavardenis","861111111","email@email.com","Pieniu g. 5","Password@");
        assertAll(
                () -> assertEquals("Vardenis", user.getName()),
                () -> assertEquals("Pavardenis", user.getSurname()),
                () -> assertEquals("861111111", user.getPhoneNumber()),
                () -> assertEquals("email@email.com", user.getEmail()),
                () -> assertEquals("Pieniu g. 5", user.getAddress()),
                () -> assertEquals("Password@", user.getPassword())
        );
    }

    @Test
    void compateTo_Test(){
        User user1 = new User( "Vardenis","Pavardenis","861111111","email@email.com","Pieniu g. 5","Password@");
        User user2 = new User( "Vardenis","Pavardenis","861111111","email@email.com","Pieniu g. 5","Password@");
        assertEquals(0, user1.compareTo(user2));
    }

    @ParameterizedTest
    @ValueSource(strings = {"email@email.com", "g@mail.com"})
    void isEmailValid_Test(String string){
        User user = new User();
        assertTrue(user.isEmailValid(string));
    }


    @ParameterizedTest
    @ValueSource(strings = {"P@Ssword123", "My$uper$tr0ngP@ssw0rd"})
    void isPasswordValid_Test(String string){
        User user = new User();
        assertTrue(user.isPasswordValid(string));
    }
}
