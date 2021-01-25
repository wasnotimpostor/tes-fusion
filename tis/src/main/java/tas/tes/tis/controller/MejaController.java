package tas.tes.tis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tas.tes.tis.model.Meja;
import tas.tes.tis.repository.MejaRepo;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tis")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MejaController {

    @Autowired
    MejaRepo mejaRepo;

    @GetMapping("/meja")
    public List<Meja> getAllMeja() {
        return mejaRepo.findAll();
    }

    @RequestMapping(value = "/meja/add",
            produces = "application/json",
            method= RequestMethod.POST)
    public  Meja addMeja(@RequestBody Meja meja) {
        return mejaRepo.save(meja);
    }

    @GetMapping("/meja/{id}")
    public Optional<Meja> getMeja(@PathVariable Long id) {
        return mejaRepo.findById(id);
    }

    @DeleteMapping("/meja/{id}")
    public void deleteMeja(@PathVariable Long id) {
        mejaRepo.deleteById(id);
    }

    @DeleteMapping("/meja")
    public void deleteAllMeja() {
        mejaRepo.deleteAll();
    }

    @PutMapping("/meja/{id}")
    public Meja replace(@RequestBody Meja newMeja, @PathVariable Long id) {
        return mejaRepo.findById(id).map(meja -> {
            meja.setId(newMeja.getId());
            meja.setLantai(newMeja.getLantai());
            return mejaRepo.save(meja);
        }).orElseGet(() -> {
            newMeja.setId(id);
            return mejaRepo.save(newMeja);
        });
    }
}
