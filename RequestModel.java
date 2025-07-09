package com.sony.adminportal.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestModel {
    private Customer customer;
    private  Product product;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RequestModel that = (RequestModel) o;
        return Objects.equals(customer, that.customer) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customer, product);
    }

    @Override
    public String toString() {
        return "RequestModel{" +
                "customer=" + customer +
                ", product=" + product +
                '}';
    }
}
