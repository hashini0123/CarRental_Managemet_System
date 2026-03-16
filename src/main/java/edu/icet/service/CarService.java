package edu.icet.service;

import edu.icet.model.dto.CarDTO;

import java.util.List;

public interface CarService {
    
    boolean addCar(CarDTO carDTO);

    boolean updateCar(CarDTO carDTO);

    boolean deleteById(String id);

    List<CarDTO> getAll();
}
