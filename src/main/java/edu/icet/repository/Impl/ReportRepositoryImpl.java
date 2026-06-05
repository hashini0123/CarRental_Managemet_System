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
    public boolean addReport (ReportDTO reportDTO) {
        String sql = "INSERT INTO reports (report_type,generated_by,start_date,end_date, total_bookings,total_revenue) VALUES (?,?,?,?,?,?)";
        return jdbcTemplate.update(sql,
                reportDTO.getReportType(),
                reportDTO.getGeneratedBy(),
                reportDTO.getStartDate(),
                reportDTO.getEndDate(),
                reportDTO.getTotalBookings(),
                reportDTO.getTotalRevenue()
                )>0;

    }

    @Override
    public boolean updateReport(ReportDTO reportDTO) {

        String sql = "UPDATE reports SET report_type=?, generated_by=?, start_date=?, end_date=?, total_bookings=?, total_revenue=? WHERE id=? ";
        return jdbcTemplate.update(sql,
                reportDTO.getReportType(),
                reportDTO.getGeneratedBy(),
                reportDTO.getStartDate(),
                reportDTO.getEndDate(),
                reportDTO.getTotalBookings(),
                reportDTO.getTotalRevenue(),
                reportDTO.getId()
        )>0;

    }

    @Override
    public boolean deleteById(String id) {
        String sql = "DELETE FROM reports WHERE id=?";
        return jdbcTemplate.update(sql,id)>0;
    }

    @Override
    public List<ReportDTO> getAll() {
        String sql = "SELECT * FROM reports";

        List<ReportDTO> reportDTOList = jdbcTemplate.query(sql, (rs, rowNum) -> {

            ReportDTO reportDTO = new ReportDTO();
            reportDTO.setReportType(rs.getString("report_type"));
            reportDTO.setGeneratedBy(rs.getInt("generated_by"));
            reportDTO.setStartDate(rs.getDate("start_date").toLocalDate());
            reportDTO.setEndDate(rs.getDate("end_date").toLocalDate());
            reportDTO.setTotalBookings(rs.getInt("total_bookings"));
            reportDTO.setTotalRevenue(rs.getDouble("total_revenue"));
            return reportDTO;
        });
        return reportDTOList;
    }
}
