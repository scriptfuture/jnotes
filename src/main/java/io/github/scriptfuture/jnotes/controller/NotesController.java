package io.github.scriptfuture.jnotes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/notes")
public class NotesController {

    // Получить первую страницу списка заметок
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public String getNotes(ModelMap model){
        return "get notes";
    }


    // Получить страницу списка заметок по номеру станицы
    @RequestMapping(value = "", method = RequestMethod.GET, params = {"page"})
    @ResponseBody
    public String getNotesPage(@RequestParam("page") int page, ModelMap model){
        return "get notes page: " + page;
    }


    // Получить первую страницу по id тега
    @RequestMapping(value = "/tag", method = RequestMethod.GET, params = {"id"})
    @ResponseBody
    public String getTag(@RequestParam("id") int id, ModelMap model){

        return "get tag id: "+id+" page 1";
    }

    // Получить выборку по id тега и номуру страницы
    @RequestMapping(value = "/tag", method = RequestMethod.GET, params = {"page", "id"})
    @ResponseBody
    public String getTagPage(@RequestParam("id") int id, @RequestParam("page") int page, ModelMap model){

        return "get tag id: "+id+" page: "+page;
    }

    // Получить заметку по id
    @RequestMapping(value = "/one", method = RequestMethod.GET, params = {"id"})
    @ResponseBody
    public String getNote(@RequestParam("id") int id, ModelMap model){

        return "get note id: "+id;
    }

    // Создать заметку
    @RequestMapping(value = "/new", method = RequestMethod.POST, params = {"title", "text", "tags"})
    @ResponseBody
    public String newNote(@RequestParam("title") String title, @RequestParam("text") String text, @RequestParam("tags") String tags, ModelMap model){

        return "new title: "+title+" text: "+text+" tags:"+tags;
    }


    // Создать заметку
    @RequestMapping(value = "/update", method = RequestMethod.POST, params = {"title", "text", "tags"})
    @ResponseBody
    public String updateNote(@RequestParam("title") String title, @RequestParam("text") String text, @RequestParam("tags") String tags, ModelMap model){

        return "update title: "+title+" text: "+text+" tags:"+tags;
    }

    // Удалить заметку
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, params = {"id"})
    @ResponseBody
    public String deleteNote(@RequestParam("id") int id, ModelMap model){

        return "delete note id: "+id;
    }

}
