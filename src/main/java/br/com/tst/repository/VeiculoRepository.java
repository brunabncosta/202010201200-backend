package br.com.tst.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import br.com.tst.domain.Veiculo;

@Repository
@CrossOrigin("http://localhost:4200")
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{
	
	List<Veiculo> findByRisco(String risco);
	
}
