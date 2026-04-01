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
        String sql = "UPDATE cars SET model=?, brand=?, fuleType=?, seatingCapacity=?, dailyRate=?, staus=? WHERE carId=?";
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
        String sql = "DELETE FROM cars WHERE carId=?";
        return jdbcTemplate.update(sql,id)>0;
    }

    @Override
    public List<CarDTO> getAll() {
        String sql = "SELECT * FROM cars";

        List<CarDTO> carDTOList = jdbcTemplate.query(sql, (rs, rowNum) -> {

            CarDTO carDTO = new CarDTO();
            carDTO.setCarId(rs.getString(1));
            carDTO.setModel(rs.getString(2));
            carDTO.setBrand(rs.getString(3));
            carDTO.setFuelType(rs.getString(4));
            carDTO.setSeatingCapacity(rs.getInt(5));
            carDTO.setDailyRate(rs.getDouble(6));
            carDTO.setStatus(rs.getString(7));
            return carDTO;
        });

        return carDTOList;
    }
}
