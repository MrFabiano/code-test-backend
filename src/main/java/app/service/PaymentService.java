package app.service;

import app.dto.PaymentRequest;
import domain.entity.EPayment;
import infra.db.repository.PaymentRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;


@ApplicationScoped
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Inject
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    // Método para processar um pagamento
    public void processPayment(PaymentRequest paymentRequest) {
        // processar o pagamento
        EPayment payment = transformToEPayment(paymentRequest);
        payment.persist();
    }
    // Método para atualizar um pagamento
    public void updatePayment(PaymentRequest paymentRequest) {
        //atualizar o pagamento
        EPayment payment = transformToEPayment(paymentRequest);
        paymentRepository.update(payment);
    }

    // Método para excluir um pagamento
    public void deletePayment(String paymentId) {
        //excluir o pagamento
        paymentRepository.delete(paymentId);
    }

    // Método privado para converter PaymentRequest em EPayment
    private EPayment transformToEPayment(PaymentRequest paymentRequest) {
        EPayment payment = new EPayment();
        payment.setDevice(paymentRequest.getDevice());
        // Define outros atributos conforme necessário
        return payment;
    }
}
