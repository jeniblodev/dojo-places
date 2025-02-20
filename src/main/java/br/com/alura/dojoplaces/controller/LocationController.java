package br.com.alura.dojoplaces.controller;




import br.com.alura.dojoplaces.model.*;
import br.com.alura.dojoplaces.repository.LocationRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class LocationController {

    @Autowired
    private final LocationRepository locationRepository;

    public LocationController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @GetMapping("/form")
    public String showFormLocation(LocationDTO locationDTO, Model model) {
        model.addAttribute("locationDTO", locationDTO);
        return "/locationForm";
    }

    @GetMapping("/list")
    public String showAllLocations( Model model) {
        List<LocationListDTO> locationListDTO = locationRepository.findAll().stream().map(LocationListDTO::new).toList();
        model.addAttribute("locationListDTO", locationListDTO);

        return "/locationList";
    }

    @PostMapping("/form")
    public String createLocation(@Valid LocationDTO locationDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return showFormLocation(locationDTO, model);
        }

        Location location = locationDTO.toModel();

        locationRepository.save(location);
        return "redirect:/form";
    }

    @GetMapping("/form/update/{id}")
    public String showLocationUpdateForm(@PathVariable Long id, Model model) {
        var location = locationRepository.findById(id).orElseThrow();
        model.addAttribute("locationUpdate", location);

        return "/locationEditForm";
    }

    @PostMapping("/form/update/{id}")
    public String updateLocation(@Valid LocationEditDTO locationEditDTO, @PathVariable Long id) {
        var location = locationRepository.findById(id).orElseThrow();
        if (!locationRepository.existsByCode(locationEditDTO.getCode()) || location.getCode().equals(locationEditDTO.getCode())) {
            locationRepository.save(location.update(locationEditDTO));
        }

        return "/locationEditFormConfirm";
    }



}
