package com.logistica.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistica.entity.Frete;
import com.logistica.repository.FreteRepository;

import jakarta.transaction.Transactional;

@Service
public class FreteService {

	@Autowired
    private final FreteRepository freteRepository;

    public FreteService(FreteRepository freteRepository) {
        this.freteRepository = freteRepository;
    }

    public List<Frete> getFrete() {
        return freteRepository.findAll();
    }

	 public void addNewFrete(Frete frete) { 
		Optional<Frete> FreteOptional =freteRepository.findFreteByEmail(frete.getCodigoFrete());
		if(FreteOptional.isPresent()) {
			throw new IllegalStateException("email exist");
		} 
		freteRepository.save(frete); 
	 }

    public void deleteFrete(Long FreteId) {
        boolean exist = freteRepository.existsById(FreteId);
        if (!exist) {
            throw new IllegalStateException("Frete with ID " + FreteId + " does not exist");
        }
        freteRepository.deleteById(FreteId);
    }

    @Transactional
    public void updateFrete(Long FreteId, String name, Integer cod) {
        Frete frete = freteRepository.findById(FreteId)
                .orElseThrow(() -> new IllegalStateException("Frete with ID " + FreteId + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(name, frete.getCodigoFrete())) {
            frete.setCodigoFrete(null);
        }

        if (cod != null && !Objects.equals(cod, frete.getCodigoFrete())) {
            Optional<Frete> FreteOptional = freteRepository.findFreteByEmail(cod);
            if (FreteOptional.isPresent()) {
                throw new IllegalStateException("email exist");
            }
            frete.setCodigoFrete(null);
        }

        freteRepository.save(frete);

    }

}
