package br.senac.go.app;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import br.senac.go.app.data.model.Veiculo;

public class VeiculoTelaTest {

    @Rule
    public ActivityTestRule activity = new ActivityTestRule(Veiculo.class, true , true);

    @Test
    public void deve_aparecer_cadastro_veiculo(){
        Espresso.onView(ViewMatchers.withText("Cadastro de Veículo"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}
