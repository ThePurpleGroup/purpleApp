package br.senac.go.app;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import br.senac.go.app.data.model.Login;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

public class LoginTelaTest {

    @Rule
    public ActivityTestRule activity = new ActivityTestRule(Login.class, true,true);

    @Test
    public void deve_aparecer_login(){
        onView(withText("Login"))
                .check(matches(isDisplayed()));

    }

}
