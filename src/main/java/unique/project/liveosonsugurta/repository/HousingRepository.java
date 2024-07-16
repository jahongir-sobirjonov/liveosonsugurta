package unique.project.liveosonsugurta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unique.project.liveosonsugurta.entity.Housing;

import java.util.UUID;

@Repository
public interface HousingRepository extends JpaRepository<Housing, UUID> {
}
