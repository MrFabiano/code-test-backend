package domain.usecase.impl;

import domain.entity.EPayment;
import domain.usecase.IUpdatePaymentUseCase;
import infra.db.repository.IPaymentRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;

@ApplicationScoped
public class UpdatePaymentUseCase implements IUpdatePaymentUseCase {


   IPaymentRepository paymentRepository;

    @Inject
    public UpdatePaymentUseCase(IPaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public void update(EPayment payment) {
        paymentRepository.update(payment);
    }
}

