package fr.minemobs.htmlbuilder;

import java.util.Properties;

public class HeadHtmlBuilder {

    private final StringBuilder builder;

    public HeadHtmlBuilder() {
        builder = new StringBuilder();
    }

    public HeadHtmlBuilder base(String url) {
        builder.append("<base href=\"").append(url).append("\" />");
        return this;
    }

    public HeadHtmlBuilder meta(String name, String content) {
        builder.append("<meta name=\"").append(name).append("\" content=\"").append(content).append("\" />");
        return this;
    }

    public HeadHtmlBuilder title(String title) {
        builder.append("<title>").append(title).append("</title>");
        return this;
    }

    public HeadHtmlBuilder style(String style) {
        builder.append("<style>").append(style).append("</style>");
        return this;
    }

    public HeadHtmlBuilder script(String script) {
        builder.append("<script>").append(script).append("</script>");
        return this;
    }

    public HeadHtmlBuilder link(String rel, String href, Properties otherProperties) {
        builder.append("<link rel=\"").append(rel).append("\" href=\"").append(href).append("\" ");
        otherProperties.forEach((key, value) -> builder.append(key).append("=\"").append(value).append("\" "));
        builder.append("/>");
        return this;
    }

    public HeadHtmlBuilder link(String rel, String href) {
        return link(rel, href, new Properties());
    }

    public HeadHtmlBuilder src(String src) {
        builder.append("<script src=\"").append(src).append("\"></script>");
        return this;
    }

    public String build() {
        return "<head>\n" + builder + "\n</head>\n";
    }
}
