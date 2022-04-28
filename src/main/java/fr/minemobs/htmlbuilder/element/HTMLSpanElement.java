package fr.minemobs.htmlbuilder.element;

public class HTMLSpanElement extends HTMLElement implements ITextElement {

    private String text;

    public HTMLSpanElement(String text) {
        super("span");
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }
}
