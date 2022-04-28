package fr.minemobs.htmlbuilder.element;

public class HTMLPreElement extends HTMLElement implements ITextElement {

    private String content;

    public HTMLPreElement() {
        super("pre");
        this.content = null;
    }

    public HTMLPreElement(String content) {
        super("pre");
        this.content = content;
    }

    @Override
    public String getText() {
        return this.content;
    }

    @Override
    public void setText(String text) {
        this.content = text;
    }
}
