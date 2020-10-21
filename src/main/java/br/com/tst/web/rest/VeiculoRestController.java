package br.com.tst.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.tst.domain.Veiculo;
import br.com.tst.service.VeiculoService;

@RestController
@RequestMapping("/rest/veiculo")
public class VeiculoRestController {

    @Autowired private VeiculoService service;

    @GetMapping(value = "/findAll")
    public List<Veiculo> findAll() {
        return service.findAll();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo create(@RequestBody Veiculo veiculo) {
    	veiculo = service.save(veiculo);
        return veiculo;
    }
    
    @GetMapping
    public List<Veiculo> findByRisco(@RequestParam(name = "risco") String risco) {
    	return service.findByRisco(risco);
    }

}
