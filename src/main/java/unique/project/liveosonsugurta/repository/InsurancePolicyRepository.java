package unique.project.liveosonsugurta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unique.project.liveosonsugurta.entity.InsurancePolicy;
import unique.project.liveosonsugurta.entity.User;

import java.util.List;
import java.util.UUID;
@Repository
public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, UUID> {
    List<InsurancePolicy> findByUser(User user);

}
