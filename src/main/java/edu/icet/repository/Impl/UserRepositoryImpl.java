package edu.icet.repository.Impl;

import edu.icet.model.dto.UserDTO;
import edu.icet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public boolean addUser(UserDTO userDTO) {
        String sql = "INSERT INTO users VALUES(?,?,?,?,?,?)";
           return jdbcTemplate.update(sql,
                   userDTO.getUserID(),
                   userDTO.getUserName(),
                   userDTO.getEmail(),
                   userDTO.getPassword(),
                   userDTO.getRole(),
                   userDTO.getCreated_at()
            ) > 0;
    }


    @Override
    public boolean updateUser(UserDTO userDTO) {

        String sql = "UPDATE user SET userName=?, email=?, password=?, role=? created_at=? WHERE user_id=?";

        return jdbcTemplate.update(sql,
                userDTO.getUserID(),
                userDTO.getUserName(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.getRole(),
                userDTO.getCreated_at()
        )>0;
    }

    @Override
    public boolean deleteByID(String id) {

        String sql = "DELETE FROM users  WHERE user_id=? ";

        return jdbcTemplate.update(sql,id)>0;
    }

    @Override
    public List<UserDTO> getAll() {

        String sql = "SELECT * FROM users";

        List<UserDTO> userDTOList = jdbcTemplate.query(sql,(rs, rowNum) -> {

            UserDTO userDTO = new UserDTO();

            userDTO.setUserID(rs.getLong(1));
            userDTO.setUserName(rs.getString(2));
            userDTO.setEmail(rs.getString(3));
            userDTO.setPassword(rs.getInt(4));
            userDTO.setRole(rs.getString(5));
            userDTO.setCreated_at(rs.getString(6));
            return userDTO;
        });

        return userDTOList;
    }
}
