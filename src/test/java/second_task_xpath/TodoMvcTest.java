package second_task_xpath;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Selenide.*;

public class TodoMvcTest {
    @Test
    public void completesTask() {
        open("https://todomvc.com/examples/emberjs/");

        $x("//*[@id='new-todo']").setValue("a").pressEnter();
        $x("//*[@id='new-todo']").setValue("b").pressEnter();
        $x("//*[@id='new-todo']").setValue("c").pressEnter();
        $$x("//*[@id='todo-list']//li")
                .shouldHave(exactTexts("a", "b", "c"));

        $x("//*[@id='todo-list']//li" + withText("b") + "//*" + withClass("toggle"))
                .click();
        $$x("//*[@id='todo-list']//li" + withClass("completed"))
                .shouldHave(exactTexts("b"));
        $$x("//*[@id='todo-list']//li" + withoutClass("completed"))
                .shouldHave(exactTexts("a", "c"));
    }
    public String withClass(String className){
       return  "[contains(concat(' ',normalize-space(@class),' '),' " + className + " ')]";
    }

    public String withoutClass(String className){
        return "[not(contains(concat(' ',normalize-space(@class),' '),' " + className + " '))]";
    }

    public String withText(String text){
        return "[.//text()='" + text + "']";
    }
}