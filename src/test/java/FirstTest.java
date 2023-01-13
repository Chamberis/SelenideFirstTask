import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class FirstTest {

//    @Test
//    public void Crud() {
//        open("https://todomvc.com/examples/emberjs/");
//        $("#new-todo").setValue("wash dishes").pressEnter();
//        $(".view").shouldHave(exactText("wash dishes"));
//        $(".view").doubleClick();
//        $(".editing").append(" and clean room").pressEnter();
//        $(".view").shouldHave(exactText("wash dishes and clean room"));
//        $(".view").hover();
//        $(".destroy").click();
//        $("#todoapp").shouldNotHave(cssClass(".view"));
//    }

    @Test
    public void crudTodo() {
        // open TodoMVC page https://todomvc.com/examples/emberjs/
        open("https://todomvc.com/examples/emberjs/");
        // add todos: "a", "b", "c"
        $("#new-todo").setValue("a").pressEnter();
        $("#new-todo").setValue("b").pressEnter();
        $("#new-todo").setValue("c").pressEnter();
        // todos should be "a", "b", "c"
//        $("li:nth-child(1)").shouldHave(exactText("a"));
//        $("li:nth-child(2)").shouldHave(exactText("b"));
//        $("li:nth-child(3)").shouldHave(exactText("c"));
        $$("#todo-list li").shouldHave(CollectionCondition.texts("a", "b", "c"));
        // toggle b
        $("#todo-list li:nth-child(2) .toggle").click();
        // completed todos should be b
        $("#todo-list li:nth-child(3) a").click();
        $(".view").shouldHave(exactText("b"));
        // active todos should be a, c
        $("#todo-list li:nth-child(2) a").click();
        $("#todo-list li:nth-child(1)").shouldHave(exactText("a"));
        $("#todo-list li:nth-child(2)").shouldHave(exactText("c"));
    }

}
