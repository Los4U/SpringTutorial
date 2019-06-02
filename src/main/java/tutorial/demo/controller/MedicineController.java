package tutorial.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tutorial.demo.Service.MedicineService;
import tutorial.demo.entity.Medicine;

@Controller
@RequestMapping("/api")
public class MedicineController {

    public MedicineService medicineService;

    @Autowired
    public MedicineController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    //ADDING NEW MEDICINE
    @GetMapping ("/showFormForAddMedicine")
    public String showFormForAddMedicine(Model theModel){
        Medicine newMedicine = new Medicine();
        theModel.addAttribute("medicineList", newMedicine);
        return "medicines/medicine-form";
    }

    @GetMapping ("/drugs")
    public String findAll(Model theModel){
        theModel.addAttribute("medicineList", medicineService.findAll());
        return "medicines/medicine-list";
    }

    @GetMapping ("/drugs/{id}")
    public Medicine findById(@PathVariable int id){
        Medicine theMedicine = medicineService.findById(id);
        if(theMedicine ==  null){
            throw  new RuntimeException("Medicine id not found: " + id);
        }
        return theMedicine;
    }

    @PostMapping("/drugs")
    public Medicine addMedicine(@RequestBody Medicine theMedicine){
        theMedicine.setMedicineId(0);
        medicineService.save(theMedicine);
        return theMedicine;
    }

    @PutMapping("/drugs")
    public Medicine updateMedicine(@RequestBody Medicine theMedicine){
        medicineService.save(theMedicine);
        return theMedicine;
    }

    @DeleteMapping("/drugs/{id}")
    public String deleteMedicineById(@PathVariable int id){
        Medicine theMedicine = medicineService.findById(id);
        if(theMedicine == null){
            throw new RuntimeException("Medicine id not found" + id);
        }
        medicineService.deleteById(id);
        return "Deleted medicine id: " + id;
    }



}
