package edu.icet.repository;

import edu.icet.model.dto.CustomerDTO;

import java.sql.SQLException;
import java.util.List;

public interface CustomerRepository {
    boolean addCustomer(CustomerDTO customerDTO) throws SQLException;

    boolean updateCustomer(CustomerDTO customerDTO);

    boolean deleteByID(String id);

    List<CustomerDTO> getAll();

}
