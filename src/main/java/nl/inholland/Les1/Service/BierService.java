        package nl.inholland.Les1.Service;

        import nl.inholland.Les1.Model.Bier;
        import nl.inholland.Les1.Model.Voorraad;
        import nl.inholland.Les1.Repository.BierRepo;
        import nl.inholland.Les1.Repository.VoorraadRepo;
        import org.springframework.stereotype.Service;

        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.Comparator;
        import java.util.List;
        import java.util.stream.Collectors;
        import java.util.stream.Stream;

@Service
public class BierService {

   private BierRepo bierRepo;
   private VoorraadRepo voorraadRepo;


   public  Iterable<Bier> getAllBiers(){
       return  bierRepo.findAll();
   }

   public void  addBier(Bier bier){
       bierRepo.save(bier);
   }

   public void deleteBier(Long id){
       bierRepo.delete(bierRepo.findById(id).orElseThrow(IllegalArgumentException::new));
   }


    public int getVoorraadValueByBier(Long id) {
        return 1;
    }

    public void deleteVoorraadItem(long id) {
        voorraadRepo.delete(voorraadRepo.findById(id).orElseThrow(IllegalArgumentException::new));
    }

    public Iterable<Voorraad> getAllVoorraad() {
        return voorraadRepo.findAll();
    }

    public Bier getBierById(Long id) {
        return bierRepo.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}
