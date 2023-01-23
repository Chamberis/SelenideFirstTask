package base;

public class TestBase {

    public static String withClass(String className){
        return  "[contains(concat(' ',normalize-space(@class),' '),' " + className + " ')]";
    }

    public static String withoutClass(String className){
        return "[not(contains(concat(' ',normalize-space(@class),' '),' " + className + " '))]";
    }

    public static String withText(String text){
        return "[.//text()='" + text + "']";
    }
}
