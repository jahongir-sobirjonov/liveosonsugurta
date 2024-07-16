package unique.project.liveosonsugurta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import unique.project.liveosonsugurta.entity.Company;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID> {
    List<Company> findByServicesContainingIgnoreCase(String service);

    Optional<Company> findByName(String companyName);

    boolean existsByName(String name);

    @Query("SELECT DISTINCT c FROM companies c JOIN c.services s WHERE LOWER(s) LIKE %:serviceName%")
    List<Company> findAllByServiceNameContainingIgnoreCase(@Param("serviceName") String serviceName);
}
