package edu.icet.repository;

import edu.icet.model.dto.UserDTO;

import java.util.List;

public interface UserRepository {

    boolean addUser(UserDTO userDTO) ;

    boolean updateUser(UserDTO userDTO);

    boolean deleteByID(String id);

    List<UserDTO> getAll();

}
