package fr.minemobs.htmlbuilder.element;

import java.util.Map;

public record ElementBuilder<T extends HTMLElement>(T element) {

    public ElementBuilder<T> id(String id) {
        element.setId(id);
        return this;
    }

    public ElementBuilder<T> setClass(String className) {
        element.setClass(className);
        return this;
    }

    public ElementBuilder<T> style(String style) {
        element.setStyle(style);
        return this;
    }

    public ElementBuilder<T> innerText(String content) {
        if (this.element instanceof ITextElement te) {
            te.setText(content);
        }
        return this;
    }

    public ElementBuilder<T> child(HTMLElement child, boolean before) {
        element.addChild(child, before);
        return this;
    }

    public ElementBuilder<T> child(HTMLElement child) {
        return this.child(child, false);
    }

    public ElementBuilder<T> attribute(String key, String value) {
        element.setAttribute(key, value);
        return this;
    }

    public ElementBuilder<T> attribute(Map<String, String> attributes) {
        attributes.forEach(element::setAttribute);
        return this;
    }

    public ElementBuilder<T> src(String src) {
        if(this.element instanceof ISourceElement se) {
            se.setSrc(src);
        }
        return this;
    }
}
