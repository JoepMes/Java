package nl.inholland.Les1.Repository;

import nl.inholland.Les1.Model.Bier;
import org.springframework.data.repository.CrudRepository;

public interface BierRepo extends CrudRepository <Bier, Long>{
}
