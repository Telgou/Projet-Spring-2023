package controller;

import com.example.spring092023.entities.Universite;
import com.example.spring092023.services.UniversiteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/universites")
@Tag(name = "Universite Controller", description = " managing universities")
public class UniversiteContoller {
    private final UniversiteService universiteService;

    @GetMapping("/")
    @Operation(summary = "Get all universities", description = "Retrieve list of all universities")
    public List<Universite> getAllUniversites() {
        return universiteService.retrieveAllUniversites();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get university by ID", description = "Retrieve a university by its ID by sending the requested uni id as pathvariable")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "University found"),
            @ApiResponse(responseCode = "404", description = "University not found")
    })
    public Universite getUniversiteById( @Parameter(description = "University ID") @PathVariable Long id) {
        return universiteService.retrieveUniversites(id);
    }

    @PostMapping("/")
    @Operation(summary = "Add a university", description = "Create a new university by sending it as an object in requestbody")
    @ApiResponse(responseCode = "201", description = "University created")
    public Universite addUniversite(@RequestBody Universite universite) {
        return universiteService.addUniversites(universite);
    }
    @PostMapping("/setfoyer/{idfoyer}/{nomuni}")
    @Operation(summary = "Set Foyer for University", description = "Assign foyer to a university by sending its id and uni name as path variable")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Foyer assigned successfully"),
            @ApiResponse(responseCode = "404", description = "Foyer or university not found")
    })
    public Universite setFoyer(@Parameter(description = "Foyer ID") @PathVariable("idfoyer") long idfoyer,
                               @Parameter(description = "University name") @PathVariable("nomuni") String nomuni) {
        return universiteService.affecterFoyerAUniversite(idfoyer,nomuni);
    }
    @PostMapping("/unsetfoyer/{idfoyer}/{iduni}")
    @Operation(summary = "Unset Foyer for University", description = "Remove foyer from a university by sending both ids as pathvariables")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Foyer removed successfully"),
            @ApiResponse(responseCode = "404", description = "Foyer or university not found")
    })
    public Universite unsetFoyer(@Parameter(description = "Foyer ID") @PathVariable("idfoyer") long idfoyer,
                                 @Parameter(description = "University ID") @PathVariable("iduni") Long iduni) {
        return universiteService.desaffecterFoyerAUniversite(idfoyer,iduni);
    }

    @PutMapping("/")
    @Operation(summary = "Update university", description = "Update an existing university by sending it in the requestbody")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "University updated"),
            @ApiResponse(responseCode = "404", description = "University not found")
    })
    public Universite updateUniversite( @RequestBody Universite universite) {
        return universiteService.updateUniversites(universite);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete university", description = "Delete a university using its ID as path variable")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "University deleted"),
            @ApiResponse(responseCode = "404", description = "University not found")
    })
    public void deleteUniversite( @Parameter(description = "University ID") @PathVariable Long id) {
        universiteService.removeUniversites(id);
    }
}
