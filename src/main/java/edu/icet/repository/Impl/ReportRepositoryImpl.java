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

        String sql = "UPDATE reports SET totalRentals=?, totalRevenus=?, utilizationRate=? WHERE reportType=? ";
        return jdbcTemplate.update(sql,
                reportDTO.getReportType(),
                reportDTO.getTotalRentals(),
                reportDTO.getTotalRevenue(),
                reportDTO.getUtilizationRate()
        )>0;

    }

    @Override
    public boolean deleteById(String id) {
        String sql = "DELETE FROM reports WHERE reportType=?";
        return jdbcTemplate.update(sql,id)>0;
    }

    @Override
    public List<ReportDTO> getAll() {
        String sql = "SELECT * FROM reports";

        List<ReportDTO> reportDTOList = jdbcTemplate.query(sql, (rs, rowNum) -> {

            ReportDTO reportDTO = new ReportDTO();
            reportDTO.setReportType(rs.getString(1));
            reportDTO.setTotalRentals(Integer.parseInt(rs.getString(2)));
            reportDTO.setTotalRevenue(Double.parseDouble(rs.getString(3)));
            reportDTO.setUtilizationRate(Double.parseDouble(rs.getString(4)));
            return reportDTO;
        });
        return reportDTOList;
    }
}
