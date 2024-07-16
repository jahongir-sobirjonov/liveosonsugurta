package unique.project.liveosonsugurta.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import unique.project.liveosonsugurta.dto.request.HousingCreateRequest;
import unique.project.liveosonsugurta.dto.response.HousingResponse;
import unique.project.liveosonsugurta.entity.Company;
import unique.project.liveosonsugurta.entity.Housing;
import unique.project.liveosonsugurta.exception.DataNotFoundException;
import unique.project.liveosonsugurta.repository.CompanyRepository;
import unique.project.liveosonsugurta.repository.HousingRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HousingService {
    private final HousingRepository housingRepository;
    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;
    public HousingResponse create(HousingCreateRequest housingRequest) {
        housingRepository.save(modelMapper.map(housingRequest, Housing.class));
        List<Company> companies = companyRepository.findByServicesContainingIgnoreCase("Housing");
        List<String> companyListByName = new ArrayList<>();
        for (Company company : companies) {
            companyListByName.add(company.getName());
        }
        HousingResponse housingResponse = modelMapper.map(housingRequest, HousingResponse.class);
        housingResponse.setCompaniesName(companyListByName);
        return housingResponse;
    }

    public HousingResponse getHousing(UUID id) {
        Optional<Housing> byId = housingRepository.findById(id);

        if (!byId.isPresent()) {
            throw new DataNotFoundException("Housing entity not found for id: " + id);
        }

        Housing housing = byId.get();
        HousingResponse housingResponse = modelMapper.map(housing, HousingResponse.class);

        List<String> companies = new ArrayList<>();
        for (Company company : housing.getCompanies()) {
            companies.add(company.getName());
        }

        housingResponse.setCompaniesName(companies);
        return housingResponse;
    }




}
