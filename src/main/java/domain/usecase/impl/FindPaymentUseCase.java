package domain.usecase.impl;

import domain.entity.EPayment;
import domain.usecase.IFindPaymentUseCase;
import infra.db.repository.IPaymentRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@ApplicationScoped
public class FindPaymentUseCase implements IFindPaymentUseCase {

    IPaymentRepository paymentRepository;

    @Inject
    public FindPaymentUseCase(IPaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public EPayment findByDevice(String device) {
        // Aqui você implementa a lógica para encontrar um pagamento pelo dispositivo
        return paymentRepository.findByDevice(device);
    }
}
