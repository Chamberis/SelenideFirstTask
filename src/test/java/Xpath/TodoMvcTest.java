package Xpath;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;

public class TodoMvcTest {
    @Test
    public void completesTask() {
        open("https://todomvc.com/examples/emberjs/");

        $x("//*[@id=\"new-todo\"]").setValue("a").pressEnter();
        $x("//*[@id=\"new-todo\"]").setValue("b").pressEnter();
        $x("//*[@id=\"new-todo\"]").setValue("c").pressEnter();
        $$x("//*[@id=\"todo-list\"]/li").shouldHave(exactTexts("a", "b", "c"));

        $x("(//input[@class='toggle'])[2]").click();
        $$x("//*[contains(concat(\" \", normalize-space(@class), \" \"), \" completed \")]").shouldHave(exactTexts("b"));
        $$x("//ul/li[not(contains(concat(\" \", normalize-space(@class), \" \"), \" completed \"))]").shouldHave(exactTexts("a", "c"));
    }
}