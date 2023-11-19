package controller;

import com.example.spring092023.entities.Etudiant;
import com.example.spring092023.services.EtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiants")
public class EtudiantController {
    private final EtudiantService etudiantService;
    @GetMapping("/")
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.retrieveAllEtudiants();
    }

    @GetMapping("/{id}")
    public Etudiant getEtudiantById(@PathVariable Long id) {
        return etudiantService.retrieveEtudiant(id);
    }

    @PostMapping("/")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.addEtudiant(etudiant);
    }

    @PutMapping("/")
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.updateEtudiant(etudiant);
    }

    @DeleteMapping("/{id}")
    public void deleteEtudiant(@PathVariable Long id) {
        etudiantService.removeEtudiant(id);
    }

    @PostMapping("/addetudiants")
    public void addEtudiants(@RequestBody List<Etudiant> etudiants) {
        etudiantService.addEtudiants(etudiants);
    }

    @PostMapping("/affecterreservation/{nom}/{prenom}/{id}")
    public void affecterreservation(@PathVariable String nom,@PathVariable String prenom,@PathVariable String id) {
        etudiantService.affecterEtudiantAReservation(nom,prenom,id);
    }

}
