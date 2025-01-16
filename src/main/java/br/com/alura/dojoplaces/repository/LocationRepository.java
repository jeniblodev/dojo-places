package br.com.alura.dojoplaces.repository;

import br.com.alura.dojoplaces.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}
