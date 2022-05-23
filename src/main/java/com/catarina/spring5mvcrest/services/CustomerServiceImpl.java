package com.catarina.spring5mvcrest.services;

import com.catarina.spring5mvcrest.api.v1.mapper.CustomerMapper;
import com.catarina.spring5mvcrest.api.v1.model.CustomerDTO;
import com.catarina.spring5mvcrest.domain.Customer;
import com.catarina.spring5mvcrest.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream().map(customer -> {
            CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
            customerDTO.setUrl("/api/v1/customer/" + customer.getId());
            return customerDTO;
        }).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        return customerMapper.customerToCustomerDTO(customerRepository.findById(id).get());
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        CustomerDTO returnCust = customerMapper.customerToCustomerDTO(savedCustomer);
        returnCust.setUrl("/api/v1/customer/" + savedCustomer.getId());
        return returnCust;
    }
}
