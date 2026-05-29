package edu.icet.repository.Impl;

import edu.icet.model.dto.UserDTO;
import edu.icet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public boolean addUser(UserDTO userDTO) {
        String sql = "INSERT INTO users(name,email,password,role) VALUE (?,?,?,?)";
        return jdbcTemplate.update(sql,
                userDTO.getName(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.getRole()
                )>0;
    }

    @Override
    public boolean updateUser(UserDTO userDTO) {
        String sql = "UPDATE users SET name=?, email=?, password=?, role=? WHERE id=?";
        return jdbcTemplate.update(sql,
                userDTO.getName(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.getRole(),
                userDTO.getId()
                )>0;
    }

    @Override
    public boolean deleteByID(String id) {
        String sql = "DELETE FROM users WHERE id=?";
        return jdbcTemplate.update(sql,id)>0;
    }

    @Override
    public List<UserDTO> getAll() {
        String sql = "SELECT *FROM users";
        List<UserDTO> userDTOList = jdbcTemplate.query(sql,(rs, rowNum) -> {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(rs.getLong(1));
            userDTO.setName(rs.getString(2));
            userDTO.setEmail(rs.getString(3));
            userDTO.setPassword(rs.getInt(4));
            userDTO.setRole(rs.getString(5));
            userDTO.setCreated_at(rs.getString(6));
            return userDTO;
        });
        return userDTOList;
    }
}
