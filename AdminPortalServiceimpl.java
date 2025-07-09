package com.sony.adminportal.Service;

import com.sony.adminportal.Exception.InvalidProductException;
import com.sony.adminportal.Model.Customer;
import com.sony.adminportal.Model.Product;
import com.sony.adminportal.Model.RequestModel;
import com.sony.adminportal.Model.ResponseModel;
import com.sony.adminportal.Repository.CustomerRepository;
import com.sony.adminportal.Repository.ProductRepository;
import com.sony.adminportal.Validator.ProductValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminPortalServiceimpl implements AdminPortalService{
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductValidate productValidate;
    @Override
    public Customer customerInfo(Customer customer) {
        String customerId=generateCustomerId();
        customer.setCustomerId(customerId);
        return customerRepository.save(customer);
    }
    private String generateCustomerId(){
        Double randomvalue = Math.random();
        String customerId=randomvalue.toString().substring(2).substring(0,6);
        return customerId;
    }
    @Override
    public Customer getCustomerById(String customerId) {
        return customerRepository.findByCustomerId(customerId);
    }
    @Override
    public Customer getCustomerByName(String customerName) {
        return customerRepository.findByCustomerName(customerName);
    }
    @Override
    public Customer getCustomerByAddress(String address) {
        return customerRepository.findByAddress(address);
    }
    @Override
    public List<Customer> getCustomerByProductName(String productName) {
        return customerRepository.findByProductName(productName);
    }
    @Override
    public Customer getById(Integer id) {
        return customerRepository.findById(id).get();
    }
    @Override
    public Object[] findCustNameAndProdNameByMobNo(String mobileNumber) {
        return customerRepository.findByMobileNumber(mobileNumber);
    }
    @Override
    public Customer getCustomerByEmailId(String emailId) {
        return customerRepository.findByEmailId(emailId);
    }
    @Override
    public Customer getByMobNo(String mobileNumber) {
        return customerRepository.findByMobNum(mobileNumber);
    }
    @Override
    public Customer getCustNameAndAddByMobNo(String mobileNumber) {
        return customerRepository.findByMobNo(mobileNumber);
    }

    @Override
    public ResponseModel saveCustomerAndProduct(RequestModel requestModel){
        Customer customer = requestModel.getCustomer();
        customer.setCustomerId(generateCustomerId());
        Customer customerResponse = customerRepository.save(customer);

        Product product = requestModel.getProduct();
        product.setProductCode(generateCustomerId());
        Product productResponse=null;
        if (productValidate.isProductValidate(product)){
            productResponse=productRepository.save(product);
        }
        else {
            throw new InvalidProductException("This is not a valid brand name");
        }
        return ResponseModel.builder()
                .customerId(customer.getCustomerId())
                .productCode(product.getProductCode())
                .build();

//        String customerId = generateCustomerId();
//        requestModel.getCustomer().setCustomerId(customerId);
//        String productCode = generateCustomerId();
//        requestModel.getProduct().setProductCode(productCode);
//        Customer customer = customerRepository.save(requestModel.getCustomer());
//        Product product = productRepository.save(requestModel.getProduct());
//        Boolean b = productValidate.isProductValidate(product.getBrandName());
//        if (b == true){
//            return ResponseModel.builder().
//                    customerId(customer.getCustomerId()).
//                    productCode(product.getProductCode()).build();
//        } else {
//            throw new invalidBrandNameException("Service are not provided for above brand");
//        }

    }
}
