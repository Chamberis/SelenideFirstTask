package dsl;

public class X {
    private String selector;

    public X(String selectorStart) {
        selector = selectorStart;
    }

    public static X any() {
        return new X(".//*");
    }

    public X child(String tag) {
        selector += "/" + tag;
        return this;
    }

    public X child() {
        child("*");
        return this;
    }

    public X descendant(String tag) {
        selector += "//" + tag;
        return this;
    }

    public X descendant() {
        descendant("*");
        return this;
    }

    public X by(String predicate) {
        selector += "[" + predicate + "]";
        return this;
    }

    public X byNot(String predicate) {
        by(Its.not(predicate));
        return this;
    }

    public String x() {
        return selector;
    }

    public static class Its {
        public static String id(String value) {
            return "@id='" + value + "'";
        }

        public static String descendantText(String text) {
            return ".//text()='" + text + "'";
        }

        public static String cssClass(String name) {
            return "contains(" +
                    "concat(' ',normalize-space(@class), ' '), " +
                    "' " + name + " '" +
                    ")";
        }

        public static String not(String predicate) {
            return "not(" + predicate + ")";
        }
    }
}