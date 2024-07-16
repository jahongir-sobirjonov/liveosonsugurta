package unique.project.liveosonsugurta.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unique.project.liveosonsugurta.dto.request.CascoCreateRequest;
import unique.project.liveosonsugurta.dto.response.CascoResponse;
import unique.project.liveosonsugurta.service.CascoService;

import java.util.UUID;

@RestController
@RequestMapping("casco")
@RequiredArgsConstructor
public class CascoController {
    private final CascoService cascoService;

    @PostMapping("/create")
    public ResponseEntity<CascoResponse> create(@RequestBody CascoCreateRequest createRequest) {
        return ResponseEntity.status(200).body(cascoService.create(createRequest));
    }

    @GetMapping("get/{id}")
    public ResponseEntity<CascoResponse> getCasco(@PathVariable UUID id){
        return ResponseEntity.status(200).body(cascoService.getCasco(id));
    }
}
