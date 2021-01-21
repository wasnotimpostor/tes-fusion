package tas.tes.tis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tas.tes.tis.model.Keranjang;
import tas.tes.tis.repository.KeranjangRepo;

@RestController
@RequestMapping("/tis")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class KeranjangController {
    
    @Autowired
    KeranjangRepo keranjangRepo;

    @GetMapping("/keranjang")
    public List<Keranjang> getAllKeranjang() {
        return keranjangRepo.findAll();
    }

    @RequestMapping(value = "/keranjang/add",
            produces = "application/json",
            method=RequestMethod.POST)
    public Keranjang addKeranjang(@RequestBody Keranjang keranjang) {
        return keranjangRepo.save(keranjang);
    }

    @GetMapping("/keranjang/{id}")
    public Optional<Keranjang> getKeranjang(@PathVariable Long id) {
        return keranjangRepo.findById(id);
    }

    @DeleteMapping("/keranjang/{id}")
    public void deleteKeranjang(@PathVariable Long id) {
        keranjangRepo.deleteById(id);
    }

    @DeleteMapping("/keranjang")
    public void deleteAllKeranjang() {
        keranjangRepo.deleteAll();
    }

    @PutMapping("/keranjang/{id}")
    public Keranjang replace(@RequestBody Keranjang newKeranjang, @PathVariable Long id) {
        return keranjangRepo.findById(id).map(keranjang -> {
            keranjang.setJumlahPesanan(newKeranjang.getJumlahPesanan());
            keranjang.setKeterangan(newKeranjang.getKeterangan());
            return keranjangRepo.save(keranjang);
        }).orElseGet(() -> {
            newKeranjang.setId(id);
            return keranjangRepo.save(newKeranjang);
        });
    }
}
