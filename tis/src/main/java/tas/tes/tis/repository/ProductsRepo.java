package tas.tes.tis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tas.tes.tis.model.Products;

import java.util.Optional;

@Repository
public interface ProductsRepo extends JpaRepository<Products, Long> {
    Optional<Products> findByNama(String nama);
}
