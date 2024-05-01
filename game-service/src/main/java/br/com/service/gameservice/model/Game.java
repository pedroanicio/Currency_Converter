package br.com.service.gameservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity(name = "game") //mapear a entidade para corresponder a tabela
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Game implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "publisher", nullable = false, length = 180)
    private String publisher;

    @Column(name = "launch_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date launchDate;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "title", nullable = false,  length = 250)
    private String title;

    @Transient
    private String currency;

    @Transient
    private String environment;

    public Game() {}

    public Game(Long id, String publisher,
                Date launchDate, double price,
                String title, String currency,
                String environment) {
        this.id = id;
        this.publisher = publisher;
        this.launchDate = launchDate;
        this.price = price;
        this.title = title;
        this.currency = currency;
        this.environment = environment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game game)) return false;

        return Double.compare(price, game.price) == 0 && Objects.equals(id, game.id) && Objects.equals(publisher, game.publisher) && Objects.equals(launchDate, game.launchDate) && Objects.equals(title, game.title) && Objects.equals(currency, game.currency) && Objects.equals(environment, game.environment);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(publisher);
        result = 31 * result + Objects.hashCode(launchDate);
        result = 31 * result + Double.hashCode(price);
        result = 31 * result + Objects.hashCode(title);
        result = 31 * result + Objects.hashCode(currency);
        result = 31 * result + Objects.hashCode(environment);
        return result;
    }
}
