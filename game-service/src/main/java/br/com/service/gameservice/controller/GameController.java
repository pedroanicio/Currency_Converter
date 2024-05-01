package br.com.service.gameservice.controller;

import br.com.service.gameservice.model.Game;
import br.com.service.gameservice.proxy.CambioProxy;
import br.com.service.gameservice.repository.GameRepository;
import br.com.service.gameservice.response.Cambio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

@RestController
@RequestMapping("game-service")
public class GameController {

    @Autowired
    private Environment environment;

    @Autowired
    private GameRepository repository;

    @Autowired
    private CambioProxy proxy;


    //http://localhost:8100/game-service/14/BRL
    @GetMapping(value="/{id}/{currency}")
    public Game findGame(
        @PathVariable("id") Long id,
        @PathVariable("currency") String currency
        ){
        var game = repository.getById(id);
        if (game == null ) throw  new RuntimeException("Not found");


        var cambio = proxy.getCambio(game.getPrice(), "USD", currency);

        var port = environment.getProperty("local.server.port");
        game.setEnvironment(port + " FEIGN");
        game.setPrice(cambio.getConvertedValue());
        return game;
        //mock
        //return new Game(1L, "Activision", new Date(), 30.5, "Call of Duty", currency, port);
    }

    /**@GetMapping(value="/{id}/{currency}")
    public Game findGame(
            @PathVariable("id") Long id,
            @PathVariable("currency") String currency
    ){
        var game = repository.getById(id);
        if (game == null ) throw  new RuntimeException("Not found");

        HashMap<String, String> params = new HashMap<>();
        params.put("amount", String.valueOf(game.getPrice()));
        params.put("from", "USD");
        params.put("to", currency);

        var response = new RestTemplate().getForEntity("http://localhost:8000/cambio-service/{amount}/{from}/{to}",
                Cambio.class,
                params);

        var cambio = response.getBody();
        var port = environment.getProperty("local.server.port");
        game.setEnvironment(port);
        game.setPrice(cambio.getConvertedValue());
        return game;
        //mock
        //return new Game(1L, "Activision", new Date(), 30.5, "Call of Duty", currency, port);
    }*/

}
