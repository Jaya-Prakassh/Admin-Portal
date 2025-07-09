package com.sony.adminportal.Service;
import com.sony.adminportal.Model.Customer;
import com.sony.adminportal.Model.RequestModel;
import com.sony.adminportal.Model.ResponseModel;

import java.util.List;

public interface AdminPortalService {
    public Customer customerInfo(Customer customer);
    public Customer getCustomerById(String customerId);
    public Customer getCustomerByName(String customerName);
    public Customer getCustomerByAddress(String address);
    public List<Customer> getCustomerByProductName(String productName);
    public Customer getById(Integer id);
    public Object[] findCustNameAndProdNameByMobNo(String mobileNumber);
    public Customer getCustomerByEmailId(String emailId);
    public Customer getByMobNo(String mobileNumber);
    public Customer getCustNameAndAddByMobNo(String mobileNumber);
    public ResponseModel saveCustomerAndProduct(RequestModel requestModel);
}
