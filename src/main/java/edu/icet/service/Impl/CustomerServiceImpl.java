package edu.icet.service.Impl;

import edu.icet.model.dto.CustomerDTO;
import edu.icet.repository.CustomerRepository;
import edu.icet.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) {
        return customerRepository.addCustomer(customerDTO);
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) {
        return customerRepository.updateCustomer(customerDTO);
    }

    @Override
    public boolean deleteByID(String ID) {
        return customerRepository.deleteByID(ID);
    }

    @Override
    public List<CustomerDTO> getAll() {
        return customerRepository.getAll();
    }
}
