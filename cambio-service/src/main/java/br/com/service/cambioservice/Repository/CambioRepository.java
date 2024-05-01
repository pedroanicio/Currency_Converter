package br.com.service.cambioservice.Repository;

import br.com.service.cambioservice.model.Cambio;
import org.springframework.data.jpa.repository.JpaRepository;
                                                                //id
public interface CambioRepository extends JpaRepository <Cambio, Long>{

    Cambio findByFromAndTo(String from, String to);

}
