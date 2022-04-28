package fr.minemobs.htmlbuilder.element;

public class HTMLCodeElement extends HTMLElement implements ITextElement {

    private String code;

    public HTMLCodeElement(String code) {
        super("code");
        this.code = code;
    }

    @Override
    public String getText() {
        return code;
    }

    @Override
    public void setText(String text) {
        this.code = text;
    }
}
