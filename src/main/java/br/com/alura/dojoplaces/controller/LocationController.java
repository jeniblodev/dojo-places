package br.com.alura.dojoplaces.controller;




import br.com.alura.dojoplaces.model.Location;
import br.com.alura.dojoplaces.model.LocationDTO;
import br.com.alura.dojoplaces.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LocationController {

    @Autowired
    private final LocationRepository locationRepository;

    public LocationController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @GetMapping("/form")
    public String showFormLocation(Model model) {
        model.addAttribute("LocationDTO", new LocationDTO());
        return "/locationForm";
    }

    @PostMapping("/form")
    public String createLocation(LocationDTO newLocation) {
        Location location = new Location();
        locationRepository.save(location);
        return "/locationForm";
    }


}
