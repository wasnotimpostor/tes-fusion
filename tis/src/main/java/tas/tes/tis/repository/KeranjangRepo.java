package tas.tes.tis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tas.tes.tis.model.Keranjang;

@Repository
public interface KeranjangRepo extends JpaRepository<Keranjang, Long> {
    
}
