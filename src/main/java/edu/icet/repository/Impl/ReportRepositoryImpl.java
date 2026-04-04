package edu.icet.repository.Impl;

import edu.icet.model.dto.ReportDTO;
import edu.icet.repository.ReportRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReportRepositoryImpl implements ReportRepository {
    @Override
    public boolean addReport(ReportDTO reportDTO) {
        return false;
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
