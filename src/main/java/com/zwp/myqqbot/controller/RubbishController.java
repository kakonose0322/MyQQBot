package com.zwp.myqqbot.controller;

import com.zwp.myqqbot.entity.Rubbish;
import com.zwp.myqqbot.service.RubbishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rubbish")
public class RubbishController {
    @Autowired
    RubbishService rubbishService;

    @RequestMapping("/getType")
    public Rubbish getType(String name) {
        return rubbishService.getRubbishByName(name);
    }
}
