package CssSelectors;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;
public class TodoMvcTest {

    @Test
    public void crudTodo() {
        open("https://todomvc.com/examples/emberjs/");

        $("#new-todo").setValue("a").pressEnter();
        $("#new-todo").setValue("b").pressEnter();
        $("#new-todo").setValue("c").pressEnter();
        $$("#todo-list li").shouldHave(exactTexts("a", "b", "c"));

        $("#todo-list li:nth-of-type(2) .toggle").click();
        $$("#todo-list li.completed").shouldHave(exactTexts("b"));
        $$("#todo-list li:not(.completed)").shouldHave(exactTexts("a", "c"));
    }

}
