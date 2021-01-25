package tas.tes.tis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tas.tes.tis.model.Meja;

@Repository
public interface MejaRepo extends JpaRepository<Meja, Long> {
}
