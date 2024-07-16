package unique.project.liveosonsugurta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unique.project.liveosonsugurta.entity.Travel;

import java.util.UUID;

@Repository
public interface TravelRepository extends JpaRepository<Travel, UUID> {
}
