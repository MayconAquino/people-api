package peopleapi.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persons")
public class PersonController {


    @GetMapping
    public ResponseEntity<String> testeRetorno() {
        return ResponseEntity.ok("Retorno feito");
    }
}
