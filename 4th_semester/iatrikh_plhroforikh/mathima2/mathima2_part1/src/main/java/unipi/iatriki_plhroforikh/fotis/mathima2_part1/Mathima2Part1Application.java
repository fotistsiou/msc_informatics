package unipi.iatriki_plhroforikh.fotis.mathima2_part1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@RestController
public class Mathima2Part1Application {

    public static void main(String[] args) {
        SpringApplication.run(Mathima2Part1Application.class, args);
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "NoName")String name) {
        return "Hello World from " + name + "!";
    }

    // Exercise with Drag Form
    @Autowired
    private DrugRepository drugRepository;
    @GetMapping("/findDrug")
    public Drug findDrugByTradeMark(@RequestParam(value = "tradeMark", defaultValue = "NoName") String tradeMark) {
        return drugRepository.findByTradeMark(tradeMark);
    }
}
