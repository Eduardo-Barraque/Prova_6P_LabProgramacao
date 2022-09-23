package br.edu.universidadedevassouras.prova.controller;

import br.edu.universidadedevassouras.prova.model.Endereco;
import br.edu.universidadedevassouras.prova.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/endereco")
public class EnderecoController {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Endereco> Get() {
        return enderecoRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Endereco> GetById(@PathVariable(value = "id") long id) {
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        if (endereco.isPresent())
            return new ResponseEntity<>(endereco.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Endereco Post(@Valid @RequestBody Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Endereco> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Endereco newEndereco) {
        Optional<Endereco> oldEndereco = enderecoRepository.findById(id);
        if (oldEndereco.isPresent()) {
            Endereco endereco = oldEndereco.get();
            endereco.setIdendereco(newEndereco.getIdendereco());
            enderecoRepository.save(endereco);
            return new ResponseEntity<>(endereco, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        if (endereco.isPresent()) {
            enderecoRepository.delete(endereco.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
