package fr.minemobs.htmlbuilder.element;

public class HTMLParagraphElement extends HTMLElement implements ITextElement {

    private String text;

    public HTMLParagraphElement(String text) {
        super("p");
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