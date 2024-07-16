package unique.project.liveosonsugurta.dto.request;
import lombok.*;


@NoArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class OsagoCreateRequest {
    private String carRegNumber;
    private String texPassportSeries;
    private String texPassportNumber;

}
