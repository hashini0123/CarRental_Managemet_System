package edu.icet.controller;

import edu.icet.model.dto.CarDTO;
import edu.icet.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    @PostMapping("/add")
    public boolean addCar(@RequestBody CarDTO carDTO){
        return carService.addCar(carDTO);
    }

    @PutMapping("/update")
    public boolean updateCar(@RequestBody CarDTO carDTO){
        return carService.updateCar(carDTO);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public boolean deleteCar(@PathVariable String id){
        return carService.deleteById(id);
    }

    @GetMapping("/get")
    public List<CarDTO> getAll(){
        return carService.getAll();
    }
}
