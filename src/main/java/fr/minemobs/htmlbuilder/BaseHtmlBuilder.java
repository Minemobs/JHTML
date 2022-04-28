package fr.minemobs.htmlbuilder;

import fr.minemobs.htmlbuilder.element.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class BaseHtmlBuilder {

    private final StringBuilder builder;
    private boolean prettyPrint;

    public BaseHtmlBuilder() {
        builder = new StringBuilder();
    }

    public BaseHtmlBuilder prettyPrint() {
        this.prettyPrint = !prettyPrint;
        return this;
    }

    public BaseHtmlBuilder lang(String lang) {
        builder.append("<html lang=\"").append(lang).append("\">");
        return this;
    }

    public BaseHtmlBuilder head(HeadHtmlBuilder head) {
        builder.append(head.build());
        return this;
    }

    public BaseHtmlBuilder body(BodyHtmlBuilder body) {
        builder.append(body.build());
        return this;
    }

    public String build() {
        return prettyPrint("<!DOCTYPE html>\n" +
                           (builder.toString().startsWith("<html lang") ? "" : "<html lang=\"en\">\n")
                           + builder.append("</html>"));
    }

    private String prettyPrint(String s) {
        if(!prettyPrint) return s;
        //TODO: Make my own PrettyPrinter
        return s;
    }

    public static void main(String[] args) {
        BaseHtmlBuilder html = new BaseHtmlBuilder().prettyPrint();
        String htmlString = html
                .head(new HeadHtmlBuilder()
                        .title("Hello World!")
                        .style("""
                            body {
                                background-color: floralwhite;
                            }
                            
                            .variable {
                                color: #c59326;
                            }
                            
                            .function {
                                color: blue;
                            }
                            
                            .string {
                                color: green;
                            }
                            
                            .parenthesis {
                                color: orange;
                            }
                            
                            span {
                                font-family: monospace;
                                font-size: 1.2em;
                                font-weight: bolder;
                            }
                            """)
                        .meta("charset", "utf-8")
                )
                .body(new BodyHtmlBuilder()
                        .append(new ElementBuilder<>(new HTMLHeadingElement("Welcome to my Website", 1))
                                .style("color: red; font-size: 50px; font-weight: bold; text-align: center; text-decoration: underline;")
                                .element())
                        .append(new ElementBuilder<>(new HTMLPreElement())
                                .child(new ElementBuilder<>(new HTMLCodeElement(""))
                                        .child(new ElementBuilder<>(new HTMLSpanElement("console"))
                                                .setClass("variable").element(), false)
                                        .child(new ElementBuilder<>(new HTMLSpanElement("."))
                                                .style("color: gray").element(), false)
                                        .child(new ElementBuilder<>(new HTMLSpanElement("log"))
                                                .setClass("function").element(), false)
                                        .child(new ElementBuilder<>(new HTMLSpanElement("("))
                                                .setClass("parenthesis").element(), false)
                                        .child(new ElementBuilder<>(new HTMLSpanElement("'Hello World!'"))
                                                .setClass("string").element(), false)
                                        .child(new ElementBuilder<>(new HTMLSpanElement(")"))
                                                .setClass("parenthesis").element(), false)
                                        .child(new ElementBuilder<>(new HTMLSpanElement(";"))
                                                .style("color: gray").element(), false)
                                        .child(new HTMLBRElement(), false)
                                        .element(), true)
                                .element())
                )
                .build();
        try(var writer = Files.newBufferedWriter(Paths.get("hello.html"),
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            writer.write(htmlString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
