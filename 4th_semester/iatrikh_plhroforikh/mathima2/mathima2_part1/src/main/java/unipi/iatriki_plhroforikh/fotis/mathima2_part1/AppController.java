package unipi.iatriki_plhroforikh.fotis.mathima2_part1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
public class AppController {
    @Autowired
    private DrugRepository drugRepository;

    @GetMapping("/drugList")
    public Iterable<Drug> getAllDrugs() {
        return drugRepository.findAll();
    }

    @PostMapping("/newDrug")
    public Drug addDrug(@RequestBody Map<String,String> body) {
        Drug drug = new Drug();
        drug.setTradeMark(body.get("tradeMark"));
        drug.setActiveIngredients(body.get("activeIngredients"));
        drug.setMarketingManager(body.get("marketingManager"));
        return drugRepository.save(drug);
    }

    @GetMapping("/findDrugById/{id}")
    public Drug findDrugById(@PathVariable Integer id) {
        Optional<Drug> drugOptional = drugRepository.findById(id);
        if (drugOptional.isPresent()) {
            return drugOptional.get();
        } else {
            return null;
        }
    }

    @GetMapping("/findDrugByTradeMark/{tradeMark}")
    public Drug findDrugByTradeMark(@PathVariable String tradeMark) {
        return drugRepository.findByTradeMark(tradeMark);
    }

    @PutMapping("updateDrag")
    public String updateDrug(@RequestBody Map<String,String> body) {
        Optional<Drug> drugOptional = drugRepository.findById(Integer.parseInt(body.get("id")));
        if (drugOptional.isPresent()) {
            Drug drug = drugOptional.get();
            drug.setTradeMark(body.get("tradeMark"));
            drug.setActiveIngredients(body.get("activeIngredients"));
            drug.setMarketingManager(body.get("marketingManager"));
            drugRepository.save(drug);
            return "Ok";
        } else  {
            return "Error";
        }
    }
}
