package com.springcourse.course.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;
@Entity
@Table(name = "tb_payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant instant;
    @JsonIgnore
    @OneToOne
    @MapsId
    private Order order;

    public Payment() {
    }

    public Payment(Long id, Instant instant, Order order) {
        super();
        this.id = id;
        this.instant = instant;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getInstant() {
        return instant;
    }

    public void setInstant(Instant instant) {
        this.instant = instant;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", instant=" + instant +
                ", order=" + order +
                '}';
    }
}
