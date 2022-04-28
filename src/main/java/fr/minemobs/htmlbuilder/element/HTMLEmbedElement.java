package fr.minemobs.htmlbuilder.element;

public class HTMLEmbedElement extends HTMLElement implements IHasNoChildren, ISourceElement {

    private String type, src, width, height, title;

    public HTMLEmbedElement() {
        super("embed");
    }

    @Override
    public String getSrc() {
        return src;
    }

    @Override
    public void setSrc(String source) {
        this.src = source;
    }
}
