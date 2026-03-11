package edu.icet.service;

import edu.icet.model.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    boolean addCustomer(CustomerDTO customerDTO);

    boolean updateCustomer(CustomerDTO customerDTO);

    boolean deleteByID(String id);

    List<CustomerDTO> getAll();
}
