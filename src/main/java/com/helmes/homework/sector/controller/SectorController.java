package com.helmes.homework.sector.controller;

import com.helmes.homework.sector.entity.Sector;
import com.helmes.homework.sector.service.SectorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SectorController {
    private final SectorService sectorService;

    public SectorController(SectorService sectorService) {
        this.sectorService = sectorService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/sectors")
    public List<Sector> getAllSectors() {
        return sectorService.getAllSectors();
    }
}
