package unique.project.liveosonsugurta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unique.project.liveosonsugurta.entity.Claim;

import java.util.UUID;
@Repository
public interface ClaimRepository extends JpaRepository<Claim, UUID> {
}
