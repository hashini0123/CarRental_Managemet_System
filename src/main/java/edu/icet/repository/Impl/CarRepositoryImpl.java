package edu.icet.repository.Impl;

import edu.icet.model.dto.CarDTO;
import edu.icet.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CarRepositoryImpl implements CarRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public boolean addCar(CarDTO carDTO) {
        return false;
    }

    @Override
    public boolean updateCar(CarDTO carDTO) {
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    @Override
    public List<CarDTO> getAll() {
        return List.of();
    }
}
