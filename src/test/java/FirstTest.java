import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FirstTest {

    @Test
    public void Crud() {
        open("https://todomvc.com/examples/emberjs/");
        $("#new-todo").setValue("wash dishes").pressEnter();
        $(".view").shouldHave(exactText("wash dishes"));
        $(".view").hover();
        $(".destroy").click();
        $("#todoapp").shouldNotHave(cssClass(".view"));
    }
}
