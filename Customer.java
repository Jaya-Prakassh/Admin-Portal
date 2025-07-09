package com.sony.adminportal.Model;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Customer")
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private String customerId;
    private String customerName;
    private String emailId;
    private String mobileNumber;
    private String address;
    private String productName;

    public Customer(String customerName,String address){
        this.customerName=customerName;
        this.address=address;
    }

    public int getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getProductName() {
        return productName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(customerId, customer.customerId) && Objects.equals(customerName, customer.customerName) && Objects.equals(emailId, customer.emailId) && Objects.equals(mobileNumber, customer.mobileNumber) && Objects.equals(address, customer.address) && Objects.equals(productName, customer.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, customerName, emailId, mobileNumber, address, productName);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", address='" + address + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}


