package fr.minemobs.htmlbuilder.element;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class HTMLElement {

    private final Map<HTMLElement, Boolean> childrens = new LinkedHashMap<>();
    private final Map<String, String> attributes = new HashMap<>();
    private final String tag;
    private String id;


    protected HTMLElement(String tag) {
        this.tag = tag;
    }

    public String getHTML() {
        String html = "<" + tag + (id != null ? " id=\"" + id + "\"" : "") + "%s" + ">" + getInnerHTML() + "</" + tag + ">";
        return String.format(html, getAttributes());
    }

    public void setStyle(String style) {
        attributes.put("style", style);
    }

    public void setAttribute(String key, String value) {
        attributes.put(key, value);
    }

    public String getAttribute(String key) {
        return attributes.get(key);
    }

    public String getAttributes() {
        StringBuilder b = new StringBuilder();
        attributes.forEach((key, value) -> b.append(" ").append(key).append("=\"").append(value).append("\""));
        return b.toString();
    }

    public String getInnerHTML() {
        StringBuilder b = new StringBuilder();
        for (HTMLElement children : getChildrens(true)) {
            b.append(children.getHTML());
        }
        b.append(getInnerText());
        for (HTMLElement children : getChildrens(false)) {
            b.append(children.getHTML());
        }
        return b.toString();
    }

    public String getInnerText() {
        if(this instanceof ITextElement textElement && textElement.getText() != null) {
            return textElement.getText();
        }
        return "";
    }

    public void addChild(HTMLElement child, boolean before) {
        childrens.put(child, before);
    }

    public Map<HTMLElement, Boolean> getChildrens() {
        return childrens;
    }

    public HTMLElement[] getChildrens(boolean before) {
        return childrens.entrySet().stream().filter(e -> e.getValue() == before).map(Map.Entry::getKey).toArray(HTMLElement[]::new);
    }

    @Override
    public String toString() {
        return getHTML();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getTag() {
        return tag;
    }

    public void setClass(String className) {
        attributes.put("class", className);
    }
}