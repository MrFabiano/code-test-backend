package domain.gateway;

import app.dto.PaymentRequest;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface IPaymentGateway {

    // Método para processar pagamentos
    void processPayment(PaymentRequest request);
}
