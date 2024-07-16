package unique.project.liveosonsugurta.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unique.project.liveosonsugurta.entity.InsurancePolicy;
import unique.project.liveosonsugurta.entity.User;
import unique.project.liveosonsugurta.repository.InsurancePolicyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InsurancePolicyService {
    private final InsurancePolicyRepository insurancePolicyRepository;
    public InsurancePolicy createPolicy(InsurancePolicy policy) {
        return insurancePolicyRepository.save(policy);
    }

    public List<InsurancePolicy> findPoliciesByUser(User user) {
        return insurancePolicyRepository.findByUser(user);
    }
}
