package com.sony.adminportal.Model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseModel {
    private String customerId;
    private String productCode;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ResponseModel that = (ResponseModel) o;
        return Objects.equals(customerId, that.customerId) && Objects.equals(productCode, that.productCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, productCode);
    }

    @Override
    public String toString() {
        return "ResponseModel{" +
                "customerId='" + customerId + '\'' +
                ", productCode='" + productCode + '\'' +
                '}';
    }
}
