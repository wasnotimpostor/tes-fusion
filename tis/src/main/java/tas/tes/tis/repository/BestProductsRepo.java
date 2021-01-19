package tas.tes.tis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tas.tes.tis.model.BestProducts;

@Repository
public interface BestProductsRepo extends JpaRepository<BestProducts, Long> {
    
}
