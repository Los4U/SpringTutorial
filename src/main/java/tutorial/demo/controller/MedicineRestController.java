package tutorial.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tutorial.demo.Service.MedicineService;
import tutorial.demo.dao.MedicineDAO;
import tutorial.demo.entity.Medicine;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MedicineRestController {

    public MedicineService medicineService;

    @Autowired
    public MedicineRestController(MedicineService medicineService) {
        this.medicineService = medicineService;
    }

    @GetMapping ("/medicines")
    public List<Medicine> findAll(){
        return medicineService.findAll();
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
