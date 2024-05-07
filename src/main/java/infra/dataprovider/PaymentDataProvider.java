package infra.dataprovider;

import domain.entity.EPayment;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;


@ApplicationScoped
public class PaymentDataProvider {

    @Inject
    EntityManager entityManager;

    @Transactional
    public void savePayment(EPayment payment) {
        entityManager.persist(payment);
    }

    public EPayment findPaymentByDevice(String device) {
        return entityManager.find(EPayment.class, device);
    }

    @Transactional
    public void updatePayment(EPayment payment) {
        entityManager.merge(payment);
    }

    @Transactional
    public void deletePayment(String device) {
        EPayment payment = findPaymentByDevice(device);
        if (payment != null) {
            entityManager.remove(payment);
        }
    }
}
