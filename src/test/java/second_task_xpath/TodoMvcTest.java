package second_task_xpath;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;

public class TodoMvcTest {
    public void toggleTodo(String name){
        $x("//*[@id='todo-list']//li[.//text()='" + name + "']//*[contains(concat(' ',normalize-space(@class),' '),' toggle ')]")
                .click();
    }
    public void checkCompleted(String todoVal){
        $$x("//*[@id='todo-list']//li[contains(concat(' ', normalize-space(@class), ' '), ' completed ')]")
                .shouldHave(exactTexts(todoVal));
    }
    public void checkActive(String todoVal1, String todoVal2){
        $$x("//*[@id='todo-list']//li[not(contains(concat(' ', normalize-space(@class), ' '), ' completed '))]")
                .shouldHave(exactTexts(todoVal1, todoVal2));
    }
    @Test
    public void completesTask() {
        open("https://todomvc.com/examples/emberjs/");

        $x("//*[@id='new-todo']").setValue("a").pressEnter();
        $x("//*[@id='new-todo']").setValue("b").pressEnter();
        $x("//*[@id='new-todo']").setValue("c").pressEnter();
        $$x("//*[@id='todo-list']//li")
                .shouldHave(exactTexts("a", "b", "c"));

        toggleTodo("b");
        checkCompleted("b");
        checkActive("a", "c");
    }
}