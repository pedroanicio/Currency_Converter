package br.com.service.cambioservice.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity(name = "cambio")
public class Cambio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //avoid to use in prod
    private long id;


    @Column(name = "from_currency", nullable = false, length = 3)
    private String from;
    @Column(name = "to_currency", nullable = false, length = 3)
    private String to;

    @Column(nullable = false)
    private BigDecimal conversionFactor;

    @Transient // it will not be persisted in the db
    private BigDecimal convertedValue;
    @Transient
    private String enviroment;

    public Cambio(String enviroment, BigDecimal convertedValue, String to, BigDecimal conversionFactor, String from, long id) {
        this.enviroment = enviroment;
        this.convertedValue = convertedValue;
        this.to = to;
        this.conversionFactor = conversionFactor;
        this.from = from;
        this.id = id;
    }

    public Cambio() {
    }

    public String getEnviroment() {
        return enviroment;
    }

    public void setEnviroment(String enviroment) {
        this.enviroment = enviroment;
    }

    public BigDecimal getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(BigDecimal convertedValue) {
        this.convertedValue = convertedValue;
    }

    public BigDecimal getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(BigDecimal conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cambio cambio = (Cambio) o;
        return id == cambio.id && Objects.equals(from, cambio.from) && Objects.equals(to, cambio.to) && Objects.equals(conversionFactor, cambio.conversionFactor) && Objects.equals(convertedValue, cambio.convertedValue) && Objects.equals(enviroment, cambio.enviroment);
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
        result = 31 * result + Objects.hashCode(from);
        result = 31 * result + Objects.hashCode(to);
        result = 31 * result + Objects.hashCode(conversionFactor);
        result = 31 * result + Objects.hashCode(convertedValue);
        result = 31 * result + Objects.hashCode(enviroment);
        return result;
    }
}
