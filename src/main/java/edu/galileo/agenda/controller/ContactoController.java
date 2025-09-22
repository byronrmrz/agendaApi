package edu.galileo.agenda.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.galileo.agenda.model.Contacto;
import edu.galileo.agenda.service.ContactoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/contacto")
public class ContactoController{
    private ContactoService contactoService;

    ContactoController (ContactoService contactoService) {
        this.contactoService = contactoService;
    }

    @GetMapping
    public Map<String, Object> getAll(){
        List<Contacto> contactos = this.contactoService.list();
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("Estudiante", "Byron Ramírez");
        response.put("Carnét", "13005169");
        response.put("Contactos", contactos);
        return response;
    }

    @PostMapping
    public Contacto add(@RequestBody(required= true) Contacto contacto){
        return this.contactoService.add(contacto);
    }
    
}