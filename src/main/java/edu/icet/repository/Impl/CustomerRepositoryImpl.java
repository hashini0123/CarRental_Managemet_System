package edu.icet.repository.Impl;

import edu.icet.model.dto.CustomerDTO;
import edu.icet.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public boolean addCustomer(CustomerDTO customerDTO) {

        //String sql = "INSERT INTO customer value"

        return false;
    }

    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) {
        return false;
    }

    @Override
    public boolean deleteByID(String id) {
        return false;
    }

    @Override
    public List<CustomerDTO> getAll() {
        return List.of();
    }
}
