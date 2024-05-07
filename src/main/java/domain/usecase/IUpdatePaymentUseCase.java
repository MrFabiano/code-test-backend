package domain.usecase;

import domain.entity.EPayment;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface IUpdatePaymentUseCase {

    void update(EPayment payment);
}
