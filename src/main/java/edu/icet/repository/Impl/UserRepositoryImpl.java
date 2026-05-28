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
        String sql = "INSERT INTO users VALUE (?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,
                userDTO.getId(),
                userDTO.getName(),
                userDTO.getEmail(),
                userDTO.getRole(),
                userDTO.getCreated_at()
                )>0;
    }

    @Override
    public boolean updateUser(UserDTO userDTO) {
        return false;
    }

    @Override
    public boolean deleteByID(String id) {
        return false;
    }

    @Override
    public List<UserDTO> getAll() {
        return List.of();
    }
}
