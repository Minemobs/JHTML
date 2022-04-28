package fr.minemobs.htmlbuilder;

import fr.minemobs.htmlbuilder.element.HTMLElement;

public class BodyHtmlBuilder {

    private final StringBuilder builder;

    public BodyHtmlBuilder() {
        builder = new StringBuilder();
    }

    public BodyHtmlBuilder append(String str) {
        builder.append(str);
        return this;
    }

    public BodyHtmlBuilder append(HTMLElement element) {
        builder.append(element.toString());
        return this;
    }

    public String build() {
        return "<body>\n" + builder + "\n</body>\n";
    }
}
