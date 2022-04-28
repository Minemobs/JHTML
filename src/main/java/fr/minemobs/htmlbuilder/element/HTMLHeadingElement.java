package fr.minemobs.htmlbuilder.element;

public class HTMLHeadingElement extends HTMLElement implements ITextElement {

    private String text;

    public HTMLHeadingElement(String text, int level) {
        super("h" + (level < 1 ? 1 : Math.min(level, 6)));
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
