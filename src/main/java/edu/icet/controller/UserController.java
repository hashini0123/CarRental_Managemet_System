package edu.icet.controller;

import edu.icet.model.dto.UserDTO;
import edu.icet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public boolean addUser(@RequestBody UserDTO userDTO){
        return userService.addUser(userDTO);
    }

    @PutMapping("/update")
    public boolean updateUser(@RequestBody UserDTO customerDTO){
        return userService.updateUser(customerDTO);
    }

    @DeleteMapping("delete-by-id/{id}")
    public boolean deleteByID(@PathVariable String ID){
        return userService.deleteByID(ID);
    }

    @GetMapping("/get")
    public List<UserDTO> getAll(){
        return userService.getAll();
    }






}
