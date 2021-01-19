package tas.tes.tis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tas.tes.tis.model.Pesanan;
import tas.tes.tis.repository.PesananRepo;

@RestController
@RequestMapping("/tis")
public class PesananController {
    
    @Autowired
    PesananRepo pesananRepo;

    @GetMapping("/pesanan")
    public List<Pesanan> getAllPesanan() {
        return pesananRepo.findAll();
    }

    @PostMapping("/pesanan/add")
    public Pesanan addPesanan(@RequestBody Pesanan pesanan) {
        return pesananRepo.save(pesanan);
    }

    @GetMapping("/pesanan/{id}")
    public Optional<Pesanan> getKeranjang(@PathVariable Long id) {
        return pesananRepo.findById(id);
    }

    @DeleteMapping("/pesanan/{id}")
    public void deleteKeranjang(@PathVariable Long id) {
        pesananRepo.deleteById(id);
    }
}
