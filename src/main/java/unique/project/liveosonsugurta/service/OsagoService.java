package unique.project.liveosonsugurta.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import unique.project.liveosonsugurta.dto.request.OsagoCreateRequest;
import unique.project.liveosonsugurta.dto.response.OsagoResponse;
import unique.project.liveosonsugurta.entity.Company;
import unique.project.liveosonsugurta.entity.Osago;
import unique.project.liveosonsugurta.exception.DataNotFoundException;
import unique.project.liveosonsugurta.repository.CompanyRepository;
import unique.project.liveosonsugurta.repository.OsagoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OsagoService {
    private final OsagoRepository osagoRepository;
    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;
    public OsagoResponse create(OsagoCreateRequest osagoRequest) {
        osagoRepository.save(modelMapper.map(osagoRequest, Osago.class));
        List<Company> companies = companyRepository.findByServicesContainingIgnoreCase("Osago");
        List<String> companyListByName = new ArrayList<>();
        for (Company company : companies) {
            companyListByName.add(company.getName());
        }
        OsagoResponse osagoResponse = modelMapper.map(osagoRequest, OsagoResponse.class);
        osagoResponse.setCompaniesName(companyListByName);
        return osagoResponse;
    }

    public OsagoResponse getOsago(UUID id) {
        Optional<Osago> byId = osagoRepository.findById(id);

        if (!byId.isPresent()) {
            throw new DataNotFoundException("Osago entity not found for id: " + id);
        }

        Osago osago = byId.get();
        OsagoResponse osagoResponse = modelMapper.map(osago, OsagoResponse.class);

        List<String> companies = new ArrayList<>();
        for (Company company : osago.getCompany()) {
            companies.add(company.getName());
        }

        osagoResponse.setCompaniesName(companies);
        return osagoResponse;
    }

}
