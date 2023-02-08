package com.uniovi.notaneitor.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarksController {

    @RequestMapping("/mark/list")
    public String getList() {
        return "Getting List";
    }
    @RequestMapping("/mark/add")
    public String setMark() {
        return "Adding Mark";
    }
    @RequestMapping("/mark/details")
    public String getDetail(@RequestParam Long id) {
        return "Getting Details =>" + id;
    }


}
