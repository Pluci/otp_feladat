package DTOs;

import java.util.Date;
import java.util.Objects;

public class Payment {
    private int Id;

    private Identification identification;

    private PaymentTypes paymentType;

    private double total;

    private Date date;

    private String paymentTypeDetailsNumber;

    public Payment(Identification identification, PaymentTypes paymentType, double total, String paymentTypeDetailsNumber, Date date){
        this.setIdentification(identification);
        this.setPaymentType(paymentType);
        this.setTotal(total);
        this.setPaymentTypeDetailsNumber(paymentTypeDetailsNumber);
        this.setDate(date);
    }

    public Identification getIdentification() {
        return identification;
    }

    public void setIdentification(Identification identification) {
        this.identification = identification;
    }

    public PaymentTypes getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentTypes paymentType) {
        this.paymentType = paymentType;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPaymentTypeDetailsNumber() {
        return paymentTypeDetailsNumber;
    }

    public void setPaymentTypeDetailsNumber(String paymentTypeDetailsNumber) {
        this.paymentTypeDetailsNumber = paymentTypeDetailsNumber;
    }

    public int getId() {
        return Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Double.compare(payment.total, total) == 0 && identification.equals(payment.identification) && paymentType == payment.paymentType && date.equals(payment.date) && paymentTypeDetailsNumber.equals(payment.paymentTypeDetailsNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identification, paymentType, total, date, paymentTypeDetailsNumber);
    }
}
