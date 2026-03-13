package edu.icet.repository.Impl;

import edu.icet.model.dto.CustomerDTO;
import edu.icet.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) {
        String sql = "INSERT INTO customer VALUES(?,?,?,?,?)";
           return jdbcTemplate.update(sql,
                    customerDTO.getCustID(),
                    customerDTO.getCustName(),
                    customerDTO.getEmail(),
                    customerDTO.getPassword(),
                    customerDTO.getContactNumber()
            ) > 0;
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
