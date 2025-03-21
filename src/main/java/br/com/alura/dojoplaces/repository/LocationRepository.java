package br.com.alura.dojoplaces.repository;

import br.com.alura.dojoplaces.model.Location;
import br.com.alura.dojoplaces.model.LocationListDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    Location findByid(Long id);
    boolean existsByCode(String code);
    boolean existsByCodeAndIdNot(String code, Long id);
}
