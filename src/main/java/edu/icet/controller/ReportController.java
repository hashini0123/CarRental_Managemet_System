package edu.icet.controller;

import edu.icet.model.dto.ReportDTO;
import edu.icet.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @PostMapping("/add")
    public boolean addReport(@RequestBody ReportDTO reportDTO){
        return reportService.addReport(reportDTO);
    }

    @PutMapping("/update")
    public boolean updateReport(@RequestBody ReportDTO reportDTO){
        return reportService.updateReport(reportDTO);
    }

    @DeleteMapping("delete-by-id/{id}")
    public boolean deleteById (@PathVariable String id){
        return reportService.deleteById(id);
    }

    @GetMapping("/get")
    public List<ReportDTO> getAll(){
        return reportService.getAll();
    }
}
