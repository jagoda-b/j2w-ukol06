package cz.czechitas.java2webapps.ukol6.controller;

import cz.czechitas.java2webapps.ukol6.entity.Vizitka;
import cz.czechitas.java2webapps.ukol6.exception.VizitkaNotFoundException;
import cz.czechitas.java2webapps.ukol6.repository.VizitkaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
public class VizitkaController {
    private final VizitkaRepository repository;

    public VizitkaController(VizitkaRepository repository) {
        this.repository = repository;
    }

    @InitBinder
    public void nullStringBinding(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping("/")
    public ModelAndView seznam() {
        ModelAndView result = new ModelAndView("seznam");
        result.addObject("vizitky", repository.findAll());
        return result;
    }

    @GetMapping("/{id}")
    public ModelAndView detail(@PathVariable int id) {
        Vizitka vizitka = repository.findById(id)
                .orElseThrow(() -> new VizitkaNotFoundException("Vizitka not found with id " + id));
        ModelAndView result = new ModelAndView("vizitka");
        result.addObject("vizitka", vizitka);
        return result;
    }

    @GetMapping("/nova")
    public ModelAndView nova() {
        ModelAndView result = new ModelAndView("formular");
        result.addObject("vizitka", new Vizitka());
        return result;
    }

    @PostMapping("/nova")
    public String nova(@Valid Vizitka form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formular";
        }
        repository.save(form);
        return "redirect:/";
    }

    @PostMapping("/")
    public String delete(int id) {
        repository.delete(Objects.requireNonNull(repository.findById(id).orElse(null)));
        return "redirect:/";
    }

}
