package edu.icet.service;

import edu.icet.model.dto.UserDTO;

import java.util.List;

public interface UserService {
    boolean addUser(UserDTO userDTO);
    boolean updateUser(UserDTO userDTO);

    boolean deleteByID(String id);

    List<UserDTO> getAll();
}
