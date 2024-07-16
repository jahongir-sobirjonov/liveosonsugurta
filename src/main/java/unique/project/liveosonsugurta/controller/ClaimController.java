package unique.project.liveosonsugurta.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unique.project.liveosonsugurta.service.ClaimService;

@RestController
@RequestMapping("insurancePolicy")
@RequiredArgsConstructor
public class ClaimController {
    private final ClaimService claimService;
}
