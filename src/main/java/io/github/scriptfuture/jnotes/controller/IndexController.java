package io.github.scriptfuture.jnotes.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class IndexController {

    // Получить список тегов
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public String getTags(ModelMap model){

        return "<h1>Test forms</h1> <h2>New note</h2>" +
                "<form action=\"/api/notes/new\" method=\"post\">\n" +
                "\t\t\t\t<p>\n" +
                "\t\t\t\t\t<label for=\"name\">Title</label><br />\n" +
                "\t\t\t\t\t<input type=\"text\" id=\"title\" name=\"title\"  ref='title'/>\n" +
                "\t\t\t\t</p>\n" +
                "\t\t\t\t<p>\n" +
                "\t\t\t\t\t<label for=\"name\">Text</label><br />\n" +
                "\t\t\t\t    <textarea rows=\"10\" name=\"text\"  ref='text'></textarea>\n" +
                "\t\t\t\t</p>\n" +
                "\t\t\t\t<p>\n" +
                "\t\t\t\t\t<label for=\"name\">Tags</label><br />\n" +
                "\t\t\t\t\t<input type=\"text\" id=\"tags\" name=\"tags\"  ref='tags'/>\n" +
                "\t\t\t\t</p>\n" +
                "\t\t\t\t\n" +
                "\t\t\t    <p><button type=\"submit\">send</button></p>\n" +
                "\t\t\t</form><h2>Update note</h2><form action=\"/api/notes/update\" method=\"post\">\n" +
                "\t\t\t\t<p>\n" +
                "\t\t\t\t\t<label for=\"name\">ID</label><br />\n" +
                "\t\t\t\t\t<input type=\"text\" id=\"id\" name=\"id\"  ref='id'/>\n" +
                "\t\t\t\t</p>\n" +
                "\t\t\t\t<p>\n" +
                "\t\t\t\t\t<label for=\"name\">Title</label><br />\n" +
                "\t\t\t\t\t<input type=\"text\" id=\"title\" name=\"title\"  ref='title'/>\n" +
                "\t\t\t\t</p>\n" +
                "\t\t\t\t<p>\n" +
                "\t\t\t\t\t<label for=\"name\">Text</label><br />\n" +
                "\t\t\t\t    <textarea rows=\"10\" name=\"text\"  ref='text'></textarea>\n" +
                "\t\t\t\t</p>\n" +
                "\t\t\t\t<p>\n" +
                "\t\t\t\t\t<label for=\"name\">Tags</label><br />\n" +
                "\t\t\t\t\t<input type=\"text\" id=\"tags\" name=\"tags\"  ref='tags'/>\n" +
                "\t\t\t\t</p>\n" +
                "\t\t\t\t\n" +
                "\t\t\t    <p><button type=\"submit\">send</button></p>\n" +
                "\t\t\t</form>";
    }
}
