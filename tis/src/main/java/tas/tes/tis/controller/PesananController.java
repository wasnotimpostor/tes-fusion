package tas.tes.tis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/pesanan/add",
            produces = "application/json",
            method=RequestMethod.POST)
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

    @PutMapping("/pesanan/{id}")
    public Pesanan replace(@RequestBody Pesanan newPesanan, @PathVariable Long id) {
        return pesananRepo.findById(id).map(pesanan -> {
            pesanan.setNama(newPesanan.getNama());
            pesanan.setKeranjang(newPesanan.getKeranjang());
            pesanan.setNoMeja(newPesanan.getNoMeja());
            return pesananRepo.save(pesanan);
        }).orElseGet(() ->{
            newPesanan.setId(id);
            return pesananRepo.save(newPesanan);
        });
    }
}
