package second_task_xpath;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;

import common.xpathselectors.X;

public class TodoMvcTest extends X {
    @Test
    public void completesTask() {
        open("https://todomvc.com/examples/emberjs/");

        $x("//*[@id='new-todo']").setValue("a").pressEnter();
        $x("//*[@id='new-todo']").setValue("b").pressEnter();
        $x("//*[@id='new-todo']").setValue("c").pressEnter();
        $$x("//*[@id='todo-list']//li")
                .shouldHave(exactTexts("a", "b", "c"));

        $x("//*[@id='todo-list']//li" + X.filterByText("b") + "//*" + filterByClass("toggle"))
                .click();
        $$x("//*[@id='todo-list']//li" + X.filterByClass("completed"))
                .shouldHave(exactTexts("b"));
        $$x("//*[@id='todo-list']//li" + X.filterByNoClass("completed"))
                .shouldHave(exactTexts("a", "c"));
    }
}