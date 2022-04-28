package fr.minemobs.htmlbuilder.element;

public class HTMLScriptElement extends HTMLElement implements ISourceElement, ITextElement {

    private String code;

    public HTMLScriptElement() {
        super("script");
    }

    public HTMLScriptElement(String code) {
        this();
        this.code = code;
    }

    @Override
    public String getSrc() {
        return this.getAttribute("src");
    }

    @Override
    public void setSrc(String src) {
        this.setAttribute("src", src);
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
