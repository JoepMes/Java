package nl.inholland.Les1.Controller;

import nl.inholland.Les1.Model.Bier;
import nl.inholland.Les1.Model.Voorraad;
import nl.inholland.Les1.Service.BierService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.awt.*;

@RestController
@RequestMapping("/voorraad")
public class VoorraadController {
    private BierService service;

    public  VoorraadController(BierService service){
        this.service = service;
    }


    @RequestMapping(value = "value/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public int getVoorraadValueByBier(@PathVariable Long id) {
        return service.getVoorraadValueByBier(id);
    }

    @RequestMapping(value ="{id}", method = RequestMethod.DELETE)
    public void deleteVoorraadItem(@PathVariable Long id) {
        service.deleteVoorraadItem(id);
    }

    @RequestMapping(value ="", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Voorraad> getAllBiers() {
        return service.getAllVoorraad();
    }

}
