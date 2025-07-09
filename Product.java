package com.sony.adminportal.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@Entity
@Table(name="Product")
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    private int id;
    private String productCode;
    private String productName;
    private String brandName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Objects.equals(productCode, product.productCode) && Objects.equals(productName, product.productName) && Objects.equals(brandName, product.brandName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productCode, productName, brandName);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}

