package common.xpathselectors;

public class X {
    public static String hasClass(String name) {
        return "contains(concat(' ',normalize-space(@class),' '),' " + name + " ')";
    }

    public static String filterByClass(String name) {
        return "[" + hasClass(name) + "]";
    }

    public static String filterByNoClass(String name) {
        return "[not(" + hasClass(name) + ")]";
    }

    public static String filterByText(String text) {
        return "[.//text()='" + text + "']";
    }
}

