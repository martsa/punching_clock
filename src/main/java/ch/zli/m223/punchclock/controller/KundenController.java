package ch.zli.m223.punchclock.controller;

import ch.zli.m223.punchclock.domain.Kunden;
import ch.zli.m223.punchclock.service.KundenService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/kunden")
public class KundenController {

    private KundenService kundenService;

    public KundenController(KundenService kundenService){this.kundenService = kundenService;}

    /**
     * Get a list of all kunden data back
     * @return List<Category>
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Kunden> getAllCategories() {
        return kundenService.findAll();
    }

    /** create a new kunden data
     * @param
     * @return kunden
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Kunden createKunden(@Valid @RequestBody Kunden kunden) { return kundenService.createKunden(kunden);
    }

    /**
     * Delete current kunden data with reference to id
     * @param id
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCategory(@PathVariable("id") Long id){ kundenService.deleteCategory(id);}

    /**
     * Update current kunden data
     * @param
     * @return kunden
     */
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Kunden updateCategory(@Valid @RequestBody Kunden kunden){ return kundenService.updateCategory(kunden);}


}
