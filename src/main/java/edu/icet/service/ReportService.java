package edu.icet.service;

import edu.icet.model.dto.ReportDTO;

import java.util.List;

public interface ReportService {
    boolean addReport(ReportDTO reportDTO);

    boolean updateReport(ReportDTO reportDTO);

    boolean deleteById(String id);

    List<ReportDTO> getAll();
}
