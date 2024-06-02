package cz.czechitas.java2webapps.ukol6.controller;

import cz.czechitas.java2webapps.ukol6.entity.Vizitka;
import cz.czechitas.java2webapps.ukol6.repository.VizitkaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/")
    public ModelAndView seznam() {
        ModelAndView result = new ModelAndView("seznam");
        result.addObject("vizitky", repository.findAll());
        return result;
    }

    @GetMapping("/{id}")
    public ModelAndView detail(@PathVariable int id) {
        ModelAndView result = new ModelAndView("vizitka");
        result.addObject("vizitka", repository.findById(id).orElse(null));
        return result;
    }

    @GetMapping("/nova")
    public ModelAndView nova() {
        ModelAndView result = new ModelAndView("formular");
        result.addObject("vizitka", new Vizitka());
        return result;
    }

    @PostMapping("/nova")
    public String nova(Vizitka form) {
        repository.save(form);
        if (form.getJmeno() == null || form.getFirma() == null || form.getUlice() == null || form.getPsc() == null) {
            throw new IllegalArgumentException("All fields must be filled");
        }
        return "redirect:/";
    }

    @PostMapping("/{id}")
    public String delete(@PathVariable int id) {
        repository.delete(Objects.requireNonNull(repository.findById(id).orElse(null)));
        return "redirect:/";
    }

}
