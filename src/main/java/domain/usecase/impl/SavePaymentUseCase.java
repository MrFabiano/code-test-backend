package domain.usecase.impl;

import domain.entity.EPayment;
import domain.usecase.ISavePaymentUseCase;
import infra.db.repository.IPaymentRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@ApplicationScoped
public class SavePaymentUseCase implements ISavePaymentUseCase {

    IPaymentRepository paymentRepository;

    @Inject
    public SavePaymentUseCase(IPaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void save(EPayment payment) {
        // Aqui você implementa a lógica para salvar o pagamento utilizando o repository
        paymentRepository.save(payment);
    }
}

