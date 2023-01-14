import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;

public class TodoMvcTest {
    @Test
    public void completesTask() {
        open("https://todomvc.com/examples/emberjs/");

        $x("//div/section/header/input").setValue("a").pressEnter();
        $x("//div/section/header/input").setValue("b").pressEnter();
        $x("//div/section/header/input").setValue("c").pressEnter();
        $$x("//*[@id=\"todo-list\"]/li").shouldHave(exactTexts("a", "b", "c"));

        $x("//div/section/section/ul/li[2]/div/input").click();
        $$x("//li[contains(@class, \"completed\")]").shouldHave(exactTexts("b"));
        $$x("//section/section/ul/li[not(contains(@class, \"completed\"))]").shouldHave(exactTexts("a", "c"));
    }
}