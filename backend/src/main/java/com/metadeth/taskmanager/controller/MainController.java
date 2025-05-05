package com.metadeth.taskmanager.model;

import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

    @GetMapping("/")
    public String welcome() {
      return "Bienvenido a la aplicación de gestión de tareas 🤘";
    }
}