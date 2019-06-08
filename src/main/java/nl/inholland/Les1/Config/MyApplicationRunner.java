package nl.inholland.Les1.Config;

import nl.inholland.Les1.Model.Bier;
import nl.inholland.Les1.Model.Voorraad;
import nl.inholland.Les1.Repository.BierRepo;
import nl.inholland.Les1.Repository.VoorraadRepo;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    private BierRepo bierRepo;
    private VoorraadRepo voorraadRepo;

    public MyApplicationRunner(BierRepo bierRepo, VoorraadRepo voorraadRepo) {
        this.bierRepo = bierRepo;
        this.voorraadRepo = voorraadRepo;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Files.lines(Paths.get("src/main/resources/biers.csv"))
                .forEach(
                        line -> bierRepo.save(
                                new Bier(line.split(",")[1],
                                        Double.parseDouble(line.split(",")[0]),
                                        Double.parseDouble(line.split(",")[2]))
                        ));

        bierRepo.findAll()
                .forEach(System.out::println);

        List<Bier> biers = (List<Bier>) bierRepo.findAll();
        biers.stream()
                .forEach(a -> voorraadRepo.save(new Voorraad(a, new Random().nextInt(10))));

        voorraadRepo.findAll()
                .forEach(System.out::println);
    }


}
