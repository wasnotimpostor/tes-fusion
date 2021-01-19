package tas.tes.tis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tas.tes.tis.model.Pesanan;

@Repository
public interface PesananRepo extends JpaRepository<Pesanan, Long> {
    
}
