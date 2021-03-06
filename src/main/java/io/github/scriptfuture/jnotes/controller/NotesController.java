package io.github.scriptfuture.jnotes.controller;

import io.github.scriptfuture.jnotes.NotesDB;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/notes")
public class NotesController {

    private NotesDB db = null;

    public NotesController() {
        db = new NotesDB();
    }

    // Получить первую страницу списка заметок
    @RequestMapping(produces = "application/json; charset=UTF-8", value = "", method = RequestMethod.GET)
    @ResponseBody
    public String getNotes(ModelMap model){
        return db.getNotes();
    }


    // Получить страницу списка заметок по номеру станицы
    @RequestMapping(produces = "application/json; charset=UTF-8", value = "", method = RequestMethod.GET, params = {"page"})
    @ResponseBody
    public String getNotesPage(@RequestParam("page") int page, ModelMap model){
        return db.getPageNotes(page);
    }


    // Получить первую страницу по id тега
    @RequestMapping(produces = "application/json; charset=UTF-8", value = "/tag", method = RequestMethod.GET, params = {"id"})
    @ResponseBody
    public String getTag(@RequestParam("id") int id, ModelMap model){
        return db.getTag(id);
    }

    // Получить выборку по id тега и номуру страницы
    @RequestMapping(produces = "application/json; charset=UTF-8", value = "/tag", method = RequestMethod.GET, params = {"page", "id"})
    @ResponseBody
    public String getTagPage(@RequestParam("id") int id, @RequestParam("page") int page, ModelMap model){
        return db.getPageTag(id, page);
    }

    // Получить заметку по id
    @RequestMapping(produces = "application/json; charset=UTF-8", value = "/one", method = RequestMethod.GET, params = {"id"})
    @ResponseBody
    public String getNote(@RequestParam("id") int id, ModelMap model){
        return db.getNote(id);
    }

    // Создать заметку
    @RequestMapping(produces = "application/json; charset=UTF-8", value = "/new", method = RequestMethod.POST, params = {"title", "text", "tags"})
    @ResponseBody
    public String newNote(@RequestParam("title") String title, @RequestParam("text") String text, @RequestParam("tags") String tags, ModelMap model){
        return db.newNote(title, text, tags);
    }


    // Редактировать заметку
    @RequestMapping(produces = "application/json; charset=UTF-8", value = "/update", method = RequestMethod.POST, params = {"id", "title", "text", "tags"})
    @ResponseBody
    public String updateNote(@RequestParam("id") int id, @RequestParam("title") String title, @RequestParam("text") String text, @RequestParam("tags") String tags, ModelMap model){
        return db.updateNote(id, title, text, tags);
    }

    // Удалить заметку
    @RequestMapping(produces = "application/json; charset=UTF-8", value = "/delete", method = RequestMethod.GET, params = {"id"})
    @ResponseBody
    public String deleteNote(@RequestParam("id") int id, ModelMap model){
        return db.removeNote(id);
    }

}
