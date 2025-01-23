package br.com.alura.dojoplaces.controller;




import br.com.alura.dojoplaces.model.Location;
import br.com.alura.dojoplaces.model.LocationDTO;
import br.com.alura.dojoplaces.repository.LocationRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/allLocations")
    public String showAllLocations(Model model) {
//        model.addAttribute("LocationListDTO", new LocationListDTO());
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



}
