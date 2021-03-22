package com.simplet.biodata.api;

import com.simplet.biodata.model.Biodata;
import com.simplet.biodata.model.ResponseModel;
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
    public ResponseModel<Biodata> addPerson(@RequestBody Biodata biodata){
        bioDataRepository.save(biodata);
        ResponseModel<Biodata> response = new ResponseModel<>("Saved Successfully", biodata);
        return response;
    }

    @GetMapping(path = "{id}")
    public ResponseModel<Optional<Biodata>> getPerson(@PathVariable @NotNull Long id){
        Optional<Biodata> biodata = bioDataRepository.findById(id);
        ResponseModel<Optional<Biodata>> response = new ResponseModel<>();
        if (biodata.isPresent()) {
            response.setMessage("Fetched successfully");
            response.setData(biodata);
        } else {
            response.setMessage("No data found with the specified id");
            response.setData(null);
        }
        return response;
    }

    @GetMapping()
    public ResponseModel<List<Biodata>> getPersons(){
        List<Biodata> biodataList =  bioDataRepository.findAll();
        return new ResponseModel<List<Biodata>>("Success", biodataList);
    }

    @PutMapping(path = "{id}")
    public ResponseModel<Optional<Biodata>> editPerson(@PathVariable @NotNull Long id, @RequestBody @NotNull Biodata biodata){
        Optional<Biodata> personToEdit = bioDataRepository.findById(id);
        if (personToEdit.isPresent()){
            biodata.setId(personToEdit.get().getId());
            bioDataRepository.save(biodata);
            return new ResponseModel<Optional<Biodata>>("Edited Successfully", personToEdit);
        }
        return new ResponseModel<>("No record found for the specified ID", null);
    }

    @DeleteMapping(path = "{id}")
    public ResponseModel<Optional<Biodata>> deletePerson(@PathVariable @NotNull Long id){
        Optional<Biodata> personToDelete = bioDataRepository.findById(id);
        if (personToDelete.isPresent()){
            bioDataRepository.delete(personToDelete.get());
            return new ResponseModel<Optional<Biodata>>("Record Deleted Successfully", personToDelete);
        }
        return new ResponseModel<Optional<Biodata>>("No record found for the specified ID", null);
    }

}
