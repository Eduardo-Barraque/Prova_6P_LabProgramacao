package br.edu.universidadedevassouras.prova.controller;

import br.edu.universidadedevassouras.prova.model.Telefone;
import br.edu.universidadedevassouras.prova.repository.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/telefone")
public class TelefoneController {
    @Autowired
    private TelefoneRepository telefoneRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Telefone> Get() {
        return telefoneRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Telefone> GetById(@PathVariable(value = "id") long id) {
        Optional<Telefone> telefone = telefoneRepository.findById(id);
        if (telefone.isPresent())
            return new ResponseEntity<>(telefone.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Telefone Post(@Valid @RequestBody Telefone telefone) {
        return telefoneRepository.save(telefone);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Telefone> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Telefone newTelefone) {
        Optional<Telefone> oldTelefone = telefoneRepository.findById(id);
        if (oldTelefone.isPresent()) {
            Telefone telefone = oldTelefone.get();
            telefone.setIdtelefone(newTelefone.getIdtelefone());
            telefoneRepository.save(telefone);
            return new ResponseEntity<>(telefone, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
        Optional<Telefone> telefone = telefoneRepository.findById(id);
        if (telefone.isPresent()) {
            telefoneRepository.delete(telefone.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
