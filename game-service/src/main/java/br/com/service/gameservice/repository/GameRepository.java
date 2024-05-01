package br.com.service.gameservice.repository;

import br.com.service.gameservice.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {}
