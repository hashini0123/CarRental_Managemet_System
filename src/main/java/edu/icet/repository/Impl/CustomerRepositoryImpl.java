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
                    customerDTO.getCustomerID(),
                    customerDTO.getCustomerName(),
                    customerDTO.getEmail(),
                    customerDTO.getPassword(),
                    customerDTO.getContactNumber()
            ) > 0;
    }


    @Override
    public boolean updateCustomer(CustomerDTO customerDTO) {

        String sql = "UPDATE customer SET custName=?, email=?, password=?, contactNumber=?,WHERE custID=?";

        return jdbcTemplate.update(sql,
                customerDTO.getCustomerID(),
                customerDTO.getCustomerName(),
                customerDTO.getEmail(),
                customerDTO.getPassword(),
                customerDTO.getContactNumber()
        )>0;
    }

    @Override
    public boolean deleteByID(String id) {

        String sql = "DELETE FROM customer  WHERE custID=? ";

        return jdbcTemplate.update(sql,id)>0;
    }

    @Override
    public List<CustomerDTO> getAll() {

        String sql = "SELECT * FROM customer";

        List<CustomerDTO> customerDTOList = jdbcTemplate.query(sql,((rs, rowNum) -> {

            CustomerDTO customerDTO = new CustomerDTO();

            customerDTO.setCustomerID(rs.getString(1));
            customerDTO.setCustomerName(rs.getString(2));
            customerDTO.setEmail(rs.getString(3));
            customerDTO.setPassword(rs.getInt(4));
            customerDTO.setContactNumber(rs.getString(5));
            return customerDTO;
        }));

        return customerDTOList;
    }
}
