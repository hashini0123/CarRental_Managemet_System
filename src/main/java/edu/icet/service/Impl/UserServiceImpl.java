package edu.icet.service.Impl;

import edu.icet.model.dto.UserDTO;
import edu.icet.repository.UserRepository;
import edu.icet.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public boolean addUser(UserDTO userDTO) {
        return userRepository.addUser(userDTO);
    }

    @Override
    public boolean updateUser(UserDTO userDTO) {
        return userRepository.updateUser(userDTO);
    }

    @Override
    public boolean deleteByID(String ID) {
        return userRepository.deleteByID(ID);
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.getAll();
    }
}
