package com.simplet.biodata.api;

import com.simplet.biodata.model.Biodata;
import com.simplet.biodata.repository.BioDataRepository;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/v1/persons")
public class BiodataController {

    private final BioDataRepository bioDataRepository;

    @Autowired
    public BiodataController(BioDataRepository bioDataRepository){
        this.bioDataRepository = bioDataRepository;
    }

    @PostMapping
    public Biodata addPerson(@RequestBody Biodata biodata){
        bioDataRepository.save(biodata);
        return biodata;
    }

    @GetMapping(path = "{id}")
    public Optional<Biodata> getPerson(@PathVariable @NotNull Long id){
        return bioDataRepository.findById(id);
    }

    @GetMapping()
    public List<Biodata> getPersons(){
        return bioDataRepository.findAll();
    }

    @PutMapping(path = "{id}")
    public Optional<Biodata> editPerson(@PathVariable @NotNull Long id, @RequestBody @NotNull Biodata biodata){
        Optional<Biodata> personToEdit = bioDataRepository.findById(id);
        if (personToEdit.isPresent()){
            biodata.setId(personToEdit.get().getId());
            bioDataRepository.save(biodata);
            return Optional.of(biodata);
        }
        return Optional.empty();
    }

    @DeleteMapping(path = "{id}")
    public Optional<Optional<Biodata>> deletePerson(@PathVariable @NotNull Long id){
        Optional<Biodata> personToDelete = bioDataRepository.findById(id);
        if (personToDelete.isPresent()){
            bioDataRepository.delete(personToDelete.get());
            return Optional.of(personToDelete);
        }
        return Optional.empty();
    }

}
