package com.xicheng.es.controller;

import com.xicheng.es.dao.CustomerRepository;
import com.xicheng.es.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author xichengxml
 * @date 2019/2/26 16:46
 * 完成一次数据的添加及查询操作
 */
@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/")
    @ResponseBody
    public void run() {
        this.customerRepository.deleteAll();
        saveCustomers();
        fetchAllCustomers();
        fetchOneCustomer();
    }

    public void saveCustomers() {
        this.customerRepository.save(new Customer(1, "Alice", "Smith"));
        this.customerRepository.save(new Customer(2, "Bob", "Smith"));
    }

    public void fetchAllCustomers() {
        System.out.println("CustomerController.fetchAllCustomers");
        Iterable<Customer> customers = this.customerRepository.findAll();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    public void fetchOneCustomer() {
        System.out.println("CustomerController.fetchOneCustomer");
        Customer customer = this.customerRepository.findByFirstName("Alice");
        System.out.println(customer);

        List<Customer> customerList = this.customerRepository.findByLastName("Smith");
        customerList.forEach(System.out::println);
    }
}
