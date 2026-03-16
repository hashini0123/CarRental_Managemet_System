package edu.icet.service.Impl;

import edu.icet.model.dto.CarDTO;
import edu.icet.repository.CarRepository;
import edu.icet.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Override
    public boolean addCar(CarDTO carDTO) {
        return carRepository.addCar(carDTO);
    }

    @Override
    public boolean updateCar(CarDTO carDTO) {
        return carRepository.updateCar(carDTO);
    }

    @Override
    public boolean deleteById(String id) {
        return carRepository.deleteById(id);
    }

    @Override
    public List<CarDTO> getAll() {
        return carRepository.getAll();
    }
}
