package infra.db.repository;

import domain.entity.EPayment;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Default;
import jakarta.inject.Singleton;


@Singleton
public interface IPaymentRepository {

    void save(EPayment payment);
    EPayment findByDevice(String device);
    void update(EPayment payment);
    void delete(String device);
}
