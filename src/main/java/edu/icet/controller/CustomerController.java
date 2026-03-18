package edu.icet.controller;

import edu.icet.model.dto.CustomerDTO;
import edu.icet.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/add")
    public boolean addCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.addCustomer(customerDTO);
    }

    @PutMapping("/update")
    public boolean updateCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.updateCustomer(customerDTO);
    }

    @DeleteMapping("delete-by-id/{id}")
    public boolean deleteByID(@PathVariable String ID){
        return customerService.deleteByID(ID);
    }

    @GetMapping("/get")
    public List<CustomerDTO> getAll(){
        return customerService.getAll();
    }






}
