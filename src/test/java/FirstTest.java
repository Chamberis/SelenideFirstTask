import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.lang.module.Configuration;

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
    public void CrudTodo() {
        // open TodoMVC page https://todomvc.com/examples/emberjs/
        open("https://todomvc.com/examples/emberjs/");
        // add todos: "a", "b", "c"
        $("#new-todo").setValue("a").pressEnter();
        $("#new-todo").setValue("b").pressEnter();
        $("#new-todo").setValue("c").pressEnter();
        // todos should be "a", "b", "c"
        $("li:nth-child(1)").shouldHave(exactText("a"));
        $("li:nth-child(2)").shouldHave(exactText("b"));
        $("li:nth-child(3)").shouldHave(exactText("c"));
        // toggle b
        $("li:nth-child(2) .toggle").click();
        // completed todos should be b
        $("li:nth-child(3) a").click();
        $(".view").shouldHave(exactText("b"));
        // active todos should be a, c
        $("li:nth-child(2) a").click();
        $("li:nth-child(1)").shouldHave(exactText("a"));
        $("li:nth-child(2)").shouldHave(exactText("c"));
    }

}
