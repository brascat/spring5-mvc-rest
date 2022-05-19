package com.catarina.spring5mvcrest.api.v1.model;

import java.util.List;

public class CustomerListDTO {
    List<CustomerDTO> customers;

    public CustomerListDTO(List<CustomerDTO> allCustomers) {
        this.customers = allCustomers;
    }

    public List<CustomerDTO> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerDTO> customers) {
        this.customers = customers;
    }
}
