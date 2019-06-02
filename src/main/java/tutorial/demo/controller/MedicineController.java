package tutorial.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tutorial.demo.Service.MedicineService;
import tutorial.demo.entity.Medicine;

@Controller
//@RequestMapping("/api")
public class MedicineController {

    public MedicineService medicineService;

    @Autowired
    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    //ADDING NEW MEDICINE
    @GetMapping ("/medicines/showFormForAddMedicine")
    public String showFormForAddMedicine(Model theModel){
        Medicine newMedicine = new Medicine();
        theModel.addAttribute("medicine", newMedicine);
        return "medicines/medicine-form";
    }

    @PostMapping("/medicines/addNewMedicine")
    public String addNewMedicine(@ModelAttribute("medicine") Medicine theMedicine){
        theMedicine.setMedicineId(0);
        medicineService.save(theMedicine);
        return "redirect:/medicines";
    }

    @GetMapping ("/medicines")
    public String findAll(Model theModel){
        theModel.addAttribute("medicineList", medicineService.findAll());
        return "medicines/medicine-list";
    }

    @GetMapping ("/medicines/{id}")
    public Medicine findById(@PathVariable int id){
        Medicine theMedicine = medicineService.findById(id);
        if(theMedicine ==  null){
            throw  new RuntimeException("Medicine id not found: " + id);
        }
        return theMedicine;
    }

    @PostMapping("/medicines")
    public Medicine addMedicine(@RequestBody Medicine theMedicine){
        theMedicine.setMedicineId(0);
        medicineService.save(theMedicine);
        return theMedicine;
    }

    @PutMapping("/medicines")
    public Medicine updateMedicine(@RequestBody Medicine theMedicine){
        medicineService.save(theMedicine);
        return theMedicine;
    }

    @DeleteMapping("/medicines/{id}")
    public String deleteMedicineById(@PathVariable int id){
        Medicine theMedicine = medicineService.findById(id);
        if(theMedicine == null){
            throw new RuntimeException("Medicine id not found" + id);
        }
        medicineService.deleteById(id);
        return "Deleted medicine id: " + id;
    }



}
