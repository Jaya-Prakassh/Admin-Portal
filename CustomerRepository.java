package com.sony.adminportal.Repository;

import com.sony.adminportal.Model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CustomerRepository extends CrudRepository<Customer,Integer> {
    Customer findByCustomerId(String customerId);
    Customer findByCustomerName(String customerName);
    Customer findByAddress(String address);
    List<Customer> findByProductName(String productName);
    @Query(value = "SELECT * FROM Customer WHERE mobile_Number=:mobileNumber",nativeQuery = true)
    Customer findByMobNum(@Param("mobileNumber")String mobileNumber);
    @Query(value = "SELECT customer_name,product_name FROM Customer WHERE mobile_number=:mobileNumber",nativeQuery = true)
    Object[] findByMobileNumber(@Param("mobileNumber")String mobileNumber);
    @Query("SELECT customer FROM Customer customer where customer.emailId=:emailId")
    Customer findByEmailId(@Param("emailId")String emailId);
    @Query("SELECT new Customer(customerName,address) FROM Customer c WHERE c.mobileNumber=:mobileNumber")
    Customer findByMobNo(@Param("mobileNumber")String mobileNumber);
}
