package io.github.scriptfuture.jnotes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;

// http://localhost:8080/api/notes/get

@Controller
@RequestMapping("/notes")
public class NotesController {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public String getNotes(ModelMap model){
        return "get notes";
    }


    @RequestMapping(value = "/get", method = RequestMethod.GET, params = {"page"})
    @ResponseBody
    public String getNotesPage(@RequestParam("page") String page, ModelMap model){
        return "get notes page: " + page;
    }

}
