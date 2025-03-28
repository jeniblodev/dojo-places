package br.com.alura.dojoplaces.controller;




import br.com.alura.dojoplaces.model.*;
import br.com.alura.dojoplaces.repository.LocationRepository;
import br.com.alura.dojoplaces.validator.CreateLocationFormValidator;
import br.com.alura.dojoplaces.validator.UpdateLocationFormValidator;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class LocationController {

    @Autowired
    private final LocationRepository locationRepository;

    private final CreateLocationFormValidator createLocationFormValidator;
    private final UpdateLocationFormValidator updateLocationFormValidator;

    public LocationController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
        this.createLocationFormValidator = new CreateLocationFormValidator(locationRepository);
        this.updateLocationFormValidator = new UpdateLocationFormValidator(locationRepository);
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

    @Transactional
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
    public String showLocationUpdateForm(@PathVariable Long id, Model model, LocationEditDTO locationEditDTO) {
        var location = locationRepository.findById(id).orElseThrow();
        model.addAttribute("locationUpdate", new LocationEditDTO(location));

        return "locationEditForm";
    }

    @Transactional
    @PostMapping("/form/update/{id}")
    public String updateLocation(@ModelAttribute("locationUpdate") @Valid LocationEditDTO locationEditDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("locationUpdate", locationEditDTO);
            return "locationEditForm";
        }

        var location = locationRepository.findById(locationEditDTO.getId()).orElseThrow();
        locationRepository.save(location.update(locationEditDTO));

        return "/locationEditFormConfirm";
    }

    @Transactional
    @PostMapping("/delete/{id}")
    public String deleteLocation(@PathVariable Long id) {
        Location location = locationRepository.findById(id).orElseThrow();
        locationRepository.delete(location);

        return "redirect:/list";
    }

    @InitBinder("locationDTO")
    public void initBinderCreateLocation(WebDataBinder binder) {
        binder.setValidator(createLocationFormValidator);
    }

    @InitBinder("locationUpdate")
    public void initBinderUpdateLocation(WebDataBinder binder) {
        binder.addValidators(updateLocationFormValidator);
    }


}
