package br.com.service.gameservice.response;

import java.io.Serializable;
import java.util.Objects;

public class Cambio implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String from;
    private String to;
    private Double conversionFactor;
    private Double convertedValue;
    private String enviroment;

    public Cambio(String enviroment, Double convertedValue, String to, Double conversionFactor, String from, long id) {
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

    public Double getConvertedValue() {
        return convertedValue;
    }

    public void setConvertedValue(Double convertedValue) {
        this.convertedValue = convertedValue;
    }

    public Double getConversionFactor() {
        return conversionFactor;
    }

    public void setConversionFactor(Double conversionFactor) {
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
