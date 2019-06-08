package nl.inholland.Les1.Model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
@Entity
public class Voorraad {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "voorraad_seq")
    private Long id;

    public Voorraad(Bier bier, int quantity){
        this.bier = bier;
        this.quantity = quantity;
    }

    private int quantity;

    @OneToOne(cascade = CascadeType.REMOVE)
    private Bier bier;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Bier getBier() {
        return bier;
    }

    public void setBier(Bier bier) {
        this.bier = bier;
    }

    @Override
    public String toString() {
        return "Voorraad{" +
                "id=" + id +
                ", bier=" + bier +
                ", quantity=" + quantity +
                '}';
    }
}
