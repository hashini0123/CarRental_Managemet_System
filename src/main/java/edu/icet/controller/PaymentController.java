package edu.icet.controller;

import edu.icet.model.dto.PaymentDTO;
import edu.icet.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/add")
    public boolean addPayment(@RequestBody PaymentDTO paymentDTO){
        return paymentService.addPayment(paymentDTO);
    }

    @PostMapping("/update")
    public boolean updatePayment(@RequestBody PaymentDTO paymentDTO){
        return paymentService.updatePayment(paymentDTO);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public boolean deleteById(@PathVariable String id){
        return paymentService.deleteById(id);
    }

    @GetMapping("/get")
    public List<PaymentDTO> getAll(){
        return paymentService.getAll();
    }


}
