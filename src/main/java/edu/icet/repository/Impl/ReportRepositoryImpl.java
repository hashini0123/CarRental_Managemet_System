package edu.icet.repository.Impl;

import edu.icet.model.dto.ReportDTO;
import edu.icet.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReportRepositoryImpl implements ReportRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public boolean addReport(ReportDTO reportDTO) {
        String sql = "INSERT INTO reports VALUES (?,?,?,?)";
        return jdbcTemplate.update(sql,
                reportDTO.getReportType(),
                reportDTO.getTotalRentals(),
                reportDTO.getTotalRevenue(),
                reportDTO.getUtilizationRate()
                )>0;

    }

    @Override
    public boolean updateReport(ReportDTO reportDTO) {
        return false;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    @Override
    public List<ReportDTO> getAll() {
        return List.of();
    }
}
