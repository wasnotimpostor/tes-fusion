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

import tas.tes.tis.model.Products;
import tas.tes.tis.repository.ProductsRepo;

@RestController
@RequestMapping("/tis")
public class ProductsController {

    @Autowired
    ProductsRepo productsRepo;

    @GetMapping("/products")
    public List<Products> getAll() {
        return productsRepo.findAll();
    }

    @PostMapping("/products/add")
    public Products addProducts(@RequestBody Products products) {
        return productsRepo.save(products);
    }

    @GetMapping("/products/{id}")
    public Optional<Products> getProducts(@PathVariable Long id) {
        return productsRepo.findById(id);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProducts(@PathVariable Long id) {
        productsRepo.deleteById(id);
    }

    @PutMapping("/products/{id}")
    public Products replace(@RequestBody Products newProducts, @PathVariable Long id) {
        return productsRepo.findById(id).map(products -> {
            products.setNama(newProducts.getNama());
            products.setKode(newProducts.getKode());
            products.setHarga(newProducts.getHarga());
            products.setIs_ready(newProducts.getIs_ready());
            products.setGambar(newProducts.getGambar());
            return productsRepo.save(products);
        }).orElseGet(() -> {
            newProducts.setId(id);
            return productsRepo.save(newProducts);
        });
    }
}
