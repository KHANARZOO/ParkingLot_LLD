package com.parking_lot_lld.models;

import java.util.Date;
import java.util.List;

public class Bill extends BaseModel{
    private Ticket ticket;
    private Gate gate;
    private Operator operator;
    private BillStatus status;
    private Date exitTime;
    private int amount;
    //one bill can have one payment or one bill have multiple payments?
    // -> It will have List<Payment> objects as user/client can do partial payment for the bill
    private List<Payment> payments;
    //Fees calculationType might vary for weekdays and for weekends
    private FeesCalculationType feesCalculationType;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public BillStatus getStatus() {
        return status;
    }

    public void setStatus(BillStatus status) {
        this.status = status;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public FeesCalculationType getFeesCalculationType() {
        return feesCalculationType;
    }

    public void setFeesCalculationType(FeesCalculationType feesCalculationType) {
        this.feesCalculationType = feesCalculationType;
    }
}
