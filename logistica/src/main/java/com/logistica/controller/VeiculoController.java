package com.logistica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.logistica.entity.Veiculo;
import com.logistica.service.VeiculoService;


@RestController
@RequestMapping(path = "veiculo")
public class VeiculoController {
	

	@Autowired
    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    @GetMapping("/getveiculo")
    public List<Veiculo> getVeiculo() {
        return veiculoService.getVeiculo();
    }

    @PostMapping
    public void registerVeiculo(@RequestBody Veiculo veiculo) {
        veiculoService.addNewVeiculo(veiculo);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteVeiculo(@PathVariable("studentId") Long studentId) {
        veiculoService.deleteVeiculo(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateVeiculo(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email){
        veiculoService.updateVeiculo(studentId, name, email);
    }
}
