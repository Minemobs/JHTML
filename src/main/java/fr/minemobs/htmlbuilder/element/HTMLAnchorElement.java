package fr.minemobs.htmlbuilder.element;

public class HTMLAnchorElement extends HTMLElement implements ITextElement {

    private String text;

    public HTMLAnchorElement(String href, String text) {
        super("a");
        this.text = text;
        this.setAttribute("href", href);
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
