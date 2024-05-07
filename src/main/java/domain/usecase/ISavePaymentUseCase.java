package domain.usecase;

import domain.entity.EPayment;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface ISavePaymentUseCase {

    void save(EPayment payment);
}
