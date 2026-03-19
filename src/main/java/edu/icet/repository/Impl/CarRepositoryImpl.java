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
        String sql = "INSERT INTO cars VALUE(?,?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,
                carDTO.getCarId(),
                carDTO.getModel(),
                carDTO.getBrand(),
                carDTO.getFuelType(),
                carDTO.getSeatingCapacity(),
                carDTO.getDailyRate(),
                carDTO.getStatus()
                )>0;
    }

    @Override
    public boolean updateCar(CarDTO carDTO) {
        String sql = "UPDATE customer SET model=?, brand=?, fuleType=?, seatingCapacity=?, dailyRate=?, sttus=? WHERE carId=?";
        return jdbcTemplate.update(sql,
                carDTO.getCarId(),
                carDTO.getModel(),
                carDTO.getBrand(),
                carDTO.getFuelType(),
                carDTO.getSeatingCapacity(),
                carDTO.getDailyRate(),
                carDTO.getStatus()
        )>0;
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
