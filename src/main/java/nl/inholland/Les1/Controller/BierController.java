package nl.inholland.Les1.Controller;

import nl.inholland.Les1.Model.Bier;
import nl.inholland.Les1.Service.BierService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.awt.*;

@RestController
@RequestMapping("/bier")
public class BierController {
    private BierService service;

    public  BierController(BierService service){
        this.service = service;
    }


    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Bier> getAllGuitars() {
        return service.getAllBiers();
    }

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addGuitar(@RequestBody Bier guitar) {
        service.addBier(guitar);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Bier getGuitarById(@PathVariable Long id) {

        return service.getBierById(id);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteGuitar(@PathVariable Long id) {
        service.deleteBier(id);
    }



}

