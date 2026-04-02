package edu.icet.repository;

import edu.icet.model.dto.ReportDTO;

import java.util.List;

public interface ReportRepository {
    boolean addReport(ReportDTO reportDTO);

    boolean updateReport(ReportDTO reportDTO);

    boolean deleteById(String id);

    List<ReportDTO> getAll();
}
