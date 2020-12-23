package controllers;

import model.entities.Smartphone;
import model.service.SmartPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/smartphones")
public class SmartphoneController {
    @Autowired
    private SmartPhoneService smartPhoneService;

    //create

    @GetMapping("/create")
    public ModelAndView createSmartphonePage(){
        ModelAndView mav = new ModelAndView("phones/new-phone");
        mav.addObject("sPhone", new Smartphone());
        return mav;
    }

    @PostMapping(value = "/createnewPhone")
    @ResponseBody
    public Smartphone createSmartphone(@RequestBody Smartphone smartphone) {
        return smartPhoneService.save(smartphone);
    }



    //getAll


    @GetMapping(value = "",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Iterable<Smartphone> allPhones(){
        return smartPhoneService.findAll();
    }

    @GetMapping("")
    public ModelAndView allPhonesPage() {
        ModelAndView modelAndView = new ModelAndView("phones/all-phones");

        modelAndView.addObject("allphones", allPhones());
        return modelAndView;
    }

    //delete

    @PostMapping(value = "/delete/{id}")
    @ResponseBody
    public Smartphone deleteSmartphone(@PathVariable Integer id){
        return smartPhoneService.remove(id);
    }

    //update

    @GetMapping("/edit/{id}")
    public ModelAndView editSmartphonePage(@PathVariable int id) {
        ModelAndView mav = new ModelAndView("phones/edit-phone");
        Smartphone smartphone = smartPhoneService.findById(id);
        mav.addObject("sPhone", smartphone);
        return mav;
    }

    @PostMapping("/edit/{id}")
    @ResponseBody
    public Smartphone editSmartphone(@PathVariable int id, @RequestBody Smartphone smartphone) {
        smartphone.setId(id);
        return smartPhoneService.save(smartphone);
    }
}
