package io.github.scriptfuture.jnotes.controller;

import io.github.scriptfuture.jnotes.NotesDB;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/tags")
public class TagsController {

    private NotesDB db = null;

    public TagsController() {
        db = new NotesDB();
    }

    // Получить список тегов
    @RequestMapping(produces = "application/json; charset=UTF-8", value = "", method = RequestMethod.GET)
    @ResponseBody
    public String getTags(ModelMap model){
        return db.getTags();
    }

}
