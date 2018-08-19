package io.github.scriptfuture.jnotes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/tags")
public class TagsController {

    // Получить список тегов
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public String getTags(ModelMap model){
        return "get tags";
    }

}
