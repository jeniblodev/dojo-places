package br.com.alura.dojoplaces.controller;




import br.com.alura.dojoplaces.model.LocationDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LocationController {

    @GetMapping("/form")
    public String createFormLocation(Model model) {
        model.addAttribute("LocationDTO", new LocationDTO());
        return "/locationForm";
    }

//    @PostMapping("/createForm")
//    public String createFormLocation(@ModelAttribute("LocationDTO") LocationDTO locationDTO, Model model) {
//
//    }


}
