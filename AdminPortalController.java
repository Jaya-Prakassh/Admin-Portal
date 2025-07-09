package com.sony.adminportal.Controller;

import com.sony.adminportal.Model.Customer;
import com.sony.adminportal.Model.Product;
import com.sony.adminportal.Model.RequestModel;
import com.sony.adminportal.Model.ResponseModel;
import com.sony.adminportal.Service.AdminPortalService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminPortalController {
    @Autowired
    private AdminPortalService adminPortalService;
    @PostMapping("/customer/save")
    public ResponseEntity<Customer> customerId(@RequestBody Customer customer) {
        Customer customerResponse = adminPortalService.customerInfo(customer);
        return new ResponseEntity<>(customerResponse, HttpStatus.CREATED);
    }
    @GetMapping("/getCustomerById/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String customerId){
        Customer customerResponse = adminPortalService.getCustomerById(customerId);
        return new ResponseEntity<>(customerResponse,HttpStatus.OK);
    }
    @GetMapping("/getCustomerByName/{customerName}")
    public ResponseEntity<Customer> getCustomerByName(@PathVariable String customerName){
        Customer customerResponse = adminPortalService.getCustomerByName(customerName);
        return new ResponseEntity<>(customerResponse,HttpStatus.OK);
    }
    @GetMapping("/getCustomerByAddress/{address}")
    public ResponseEntity<Customer> getCustomerByAddress(@PathVariable String address){
        Customer customerResponse = adminPortalService.getCustomerByAddress(address);
        return new ResponseEntity<>(customerResponse,HttpStatus.OK);
    }
    @GetMapping("/getCustomerByProductName/{productName}")
    public ResponseEntity<List<Customer>> getCustomerByProductName(@PathVariable String productName){
        List<Customer> customerResponse = adminPortalService.getCustomerByProductName(productName);
        return new ResponseEntity<>(customerResponse,HttpStatus.OK);
    }
    @GetMapping("/getCustomerbyId/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Integer id){
        Customer customerResponse = adminPortalService.getById(id);
        return new ResponseEntity<>(customerResponse,HttpStatus.OK);
    }
    @GetMapping("/findCustNameAndProdNameByMobNo/{mobileNumber}")
    public ResponseEntity<?>findCustNameAndProdNameByMobNo(@PathVariable String mobileNumber){
        Object[] customerResponse = adminPortalService.findCustNameAndProdNameByMobNo(mobileNumber);
        return new ResponseEntity<>(customerResponse,HttpStatus.OK);
    }
    @GetMapping("/getCustomerByEmailId/{emailId}")
    public ResponseEntity<Customer> getCustomerByEmailId(@PathVariable String emailId){
        Customer customerResponse = adminPortalService.getCustomerByEmailId(emailId);
        return new ResponseEntity<>(customerResponse,HttpStatus.OK);
    }
    @GetMapping("/getByMobNo/{mobileNumber}")
    public ResponseEntity<Customer> getByMobNo(@PathVariable String mobileNumber){
        Customer customerResponse = adminPortalService.getByMobNo(mobileNumber);
        return new ResponseEntity<>(customerResponse,HttpStatus.OK);
    }
    @GetMapping("/getCustNameAndAddByMobNo/{mobileNumber}")
    public ResponseEntity<Customer> getCustNameAndAddByMobNo(@PathVariable String mobileNumber){
        Customer customerResponse = adminPortalService.getCustNameAndAddByMobNo(mobileNumber);
        return new ResponseEntity<>(customerResponse,HttpStatus.OK);
    }
    @PostMapping("/saveCustomerAndProduct")
    public ResponseEntity<ResponseModel> saveCustomerAndProduct(@RequestBody RequestModel requestModel){
        ResponseModel  responseModel = adminPortalService.saveCustomerAndProduct(requestModel);
        return new ResponseEntity<>(responseModel,HttpStatus.OK);
    }
    @GetMapping("/test")
    public ResponseEntity<RequestModel>getCustAndProd(){
        Customer c = Customer.builder()
                .customerName("Jai")
                .build();
        Product p = Product.builder()
                .productName("phone")
                .build();
        RequestModel i = RequestModel.builder()
                .customer(c)
                .product(p)
                .build();
        return new ResponseEntity<>(i,HttpStatus.OK);
    }

}
