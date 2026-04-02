package edu.icet.service.Impl;

import edu.icet.model.dto.ReportDTO;
import edu.icet.repository.ReportRepository;
import edu.icet.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    @Override
    public boolean addReport(ReportDTO reportDTO) {
        return reportRepository.addReport(reportDTO);
    }

    @Override
    public boolean updateReport(ReportDTO reportDTO) {
        return reportRepository.updateReport(reportDTO);
    }

    @Override
    public boolean deleteById(String id) {
        return reportRepository.deleteById(id);
    }

    @Override
    public List<ReportDTO> getAll() {
        return reportRepository.getAll();
    }
}
