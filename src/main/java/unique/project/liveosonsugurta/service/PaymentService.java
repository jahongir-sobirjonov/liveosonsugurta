package unique.project.liveosonsugurta.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unique.project.liveosonsugurta.entity.Payment;
import unique.project.liveosonsugurta.repository.PaymentRepository;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public Payment makePayment(Payment payment) {
        return paymentRepository.save(payment);
    }
}
