package tas.tes.tis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tas.tes.tis.model.BestProducts;
import tas.tes.tis.repository.BestProductsRepo;

@RestController
@RequestMapping("/tis")
public class BestProductsController {
    
    @Autowired
    BestProductsRepo bestProductsRepo;

    @GetMapping("/best")
    public List<BestProducts> getAllBest() {
        return bestProductsRepo.findAll();
    }

    @PostMapping("/best/add")
    public BestProducts addBest(@RequestBody BestProducts bestProducts) {
        return bestProductsRepo.save(bestProducts);
    }

    @GetMapping("/best/{id}")
    public Optional<BestProducts> getBest(@PathVariable Long id) {
        return bestProductsRepo.findById(id);
    }

    @DeleteMapping("/best/{id}")
    public void deleteBest(@PathVariable Long id) {
        bestProductsRepo.deleteById(id);
    }

    @PutMapping("/best/{id}")
    public BestProducts replace(@RequestBody BestProducts newBestProducts, @PathVariable Long id) {
        return bestProductsRepo.findById(id).map(best ->{
            best.setNama(newBestProducts.getNama());
            best.setKode(newBestProducts.getKode());
            best.setHarga(newBestProducts.getHarga());
            best.setIs_ready(newBestProducts.getIs_ready());
            best.setGambar(newBestProducts.getGambar());
            return bestProductsRepo.save(best);
        }).orElseGet(() ->{
            newBestProducts.setId(id);
            return bestProductsRepo.save(newBestProducts);
        });
    }
}
