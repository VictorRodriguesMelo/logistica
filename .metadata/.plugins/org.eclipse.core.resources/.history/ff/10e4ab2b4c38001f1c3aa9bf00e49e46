package com.logistica.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistica.entity.Veiculo;
import com.logistica.repository.VeiculoRepository;

import jakarta.transaction.Transactional;

@Service
public class VeiculoService {

	@Autowired
    private final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public List<Veiculo> getVeiculo() {
    	List<Veiculo> veiculo = veiculoRepository.findAll();
        return veiculo;
    }

    public void addNewVeiculo(Veiculo veiculo) {
        Optional<Veiculo> VeiculoOptional = veiculoRepository.findVeiculoByEmail(veiculo.getName());
        if (VeiculoOptional.isPresent()) {
            throw new IllegalStateException("email exist");
        }
        veiculoRepository.save(veiculo);
    }

    public void deleteVeiculo(Long VeiculoId) {
        boolean exist = veiculoRepository.existsById(VeiculoId);
        if (!exist) {
            throw new IllegalStateException("Veiculo with ID " + VeiculoId + " does not exist");
        }
        veiculoRepository.deleteById(VeiculoId);
    }

    @Transactional
    public void updateVeiculo(Long VeiculoId, String name, String email) {
        Veiculo veiculo = veiculoRepository.findById(VeiculoId)
                .orElseThrow(() -> new IllegalStateException("Veiculo with ID " + VeiculoId + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(name, veiculo.getName())) {
            veiculo.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(email, veiculo.getName())) {
            Optional<Veiculo> VeiculoOptional = veiculoRepository.findVeiculoByEmail(email);
            if (VeiculoOptional.isPresent()) {
                throw new IllegalStateException("email exist");
            }
            veiculo.setName(name);
        }

        veiculoRepository.save(veiculo);

    }

}
