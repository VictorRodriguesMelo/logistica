package com.logistica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.logistica.entity.Frete;
import com.logistica.service.FreteService;


@RestController
@RequestMapping(path = "frete")
public class FreteController {

	@Autowired
    private final FreteService freteService;

    public FreteController(FreteService freteService) {
        this.freteService = freteService;
    }

	 @GetMapping("/getfrete")
	 public List<Frete> getFreteEntregadores() { 
		 return freteService.getFrete(); 
	}

    @PostMapping
    @Transactional
    public ResponseEntity<Frete> registerFrete(@RequestBody Frete frete) {
        freteService.addNewFrete(frete);
		return ResponseEntity.ok(frete);
    }

    @DeleteMapping("{freteid}")
    @ResponseBody
    public void deleteFrete(@PathVariable("freteid") Long freteid) {
        freteService.deleteFrete(freteid);
    }

    @PutMapping("{freteid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void updateFrete(@PathVariable("freteid") Long freteid, @RequestBody Frete frete){
        freteService.updateFrete(freteid, frete);
    }
}
