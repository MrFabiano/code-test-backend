package app.service;

import app.dto.PaymentRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class PaymentServiceFacade {

    @Inject
    private PaymentService paymentService;

    // Métodos da fachada para delegar chamadas ao serviço de pagamento
    public void processPayment(PaymentRequest paymentRequest) {
        paymentService.processPayment(paymentRequest);
    }

    public void updatePayment(PaymentRequest paymentRequest) {
        paymentService.updatePayment(paymentRequest);
    }

    public void deletePayment(String paymentId) {
        paymentService.deletePayment(paymentId);
    }
}
