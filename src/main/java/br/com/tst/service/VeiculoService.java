package br.com.tst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import br.com.tst.domain.Veiculo;
import br.com.tst.repository.VeiculoRepository;

@Service
@Validated
public class VeiculoService {

    @Autowired private VeiculoRepository repository;

    // TODO TINHA CAST NO RETURN (List<Veiculo>) 
    public List<Veiculo> findAll() {
        return repository.findAll();
    }

    public Veiculo save(Veiculo veiculo) {
    	
    	Integer ano = veiculo.getAno();
    	if (ano >= 2015) {
    		veiculo.setRisco("Risco Baixo");
    	} else if (ano >= 2010 && ano < 2015) {
    		veiculo.setRisco("Risco Medio");
    	} else if (ano > 2010) {
    		veiculo.setRisco("Risco Alto");
    	}
    	
        return repository.save(veiculo);
    }
    
    public List<Veiculo> findByRisco(String risco) {
    	return repository.findByRisco(risco);
    }

}
