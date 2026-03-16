package edu.icet.repository;

import edu.icet.model.dto.CarDTO;

import java.util.List;

public interface CarRepository {
    boolean addCar(CarDTO carDTO);

    boolean updateCar(CarDTO carDTO);

    boolean deleteById(String id);

    List<CarDTO> getAll();
}
