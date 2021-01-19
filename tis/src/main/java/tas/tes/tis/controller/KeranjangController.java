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

import tas.tes.tis.model.Keranjang;
import tas.tes.tis.repository.KeranjangRepo;

@RestController
@RequestMapping("/tis")
public class KeranjangController {
    
    @Autowired
    KeranjangRepo keranjangRepo;

    @GetMapping("/keranjang")
    public List<Keranjang> getAllKeranjang() {
        return keranjangRepo.findAll();
    }

    @PostMapping("/keranjang/add")
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
}
