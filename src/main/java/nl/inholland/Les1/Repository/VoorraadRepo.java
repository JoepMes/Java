package nl.inholland.Les1.Repository;

import nl.inholland.Les1.Model.Bier;
import nl.inholland.Les1.Model.Voorraad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface VoorraadRepo extends CrudRepository <Voorraad, Long>{

}
