package base;

public class TestBase {

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
