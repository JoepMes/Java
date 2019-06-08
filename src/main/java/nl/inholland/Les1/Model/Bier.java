package nl.inholland.Les1.Model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"naam"})})
public class Bier {
    @OneToOne
    private Voorraad voorraad;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bier_seq")
    private Long id;

    private String naam;
    private Double alcohol;
    private Double prijs;
    public Bier(String naam, Double alcohol, Double prijs){
        this.naam = naam;
        this.alcohol = alcohol;
        this.prijs = prijs;
    }
    public  Bier(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Double getPrijs() {
        return prijs;
    }

    public void setPrijs(Double prijs) {
        this.prijs = prijs;
    }

    public Double getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(Double alcohol) {
        this.alcohol = alcohol;
    }

    @Override
    public String toString() {
        return "Bier{" +
                "id='" + id + '\'' +
                ", naam='" + naam + '\'' +
                ", alcohol='" + alcohol + '\'' +
                '}';
    }
}
