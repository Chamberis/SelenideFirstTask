package fourth_task_xpath_dsl;

import dsl.X.Its;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;
import static dsl.X.any;

public class TodoMvcTest {
    @Test
    void completesTask() {
        open("http://todomvc.com/examples/emberjs/");

        $x(any().by(Its.id("new-todo")).x()).setValue("a").pressEnter();
        $x(any().by(Its.id("new-todo")).x()).setValue("b").pressEnter();
        $x(any().by(Its.id("new-todo")).x()).setValue("c").pressEnter();

        $$x(any().by(Its.id("todo-list")).child("li").x())
                .shouldHave(exactTexts("a", "b", "c"));

        $x(any().by(Its.id("todo-list"))
                .child("li").by(Its.descendantText("b"))
                .descendant().by(Its.cssClass("toggle"))
                .x())
                .click();

        $$x(any().by(Its.id("todo-list"))
                .child("li").by(Its.cssClass("completed"))
                .x())
                .shouldHave(exactTexts("b"));

        $$x(any().by(Its.id("todo-list"))
                .child("li").byNot(Its.cssClass("completed"))
                .x())
                .shouldHave(exactTexts("a", "c"));
    }
}