package com.br.shakalinux.controller;

import com.br.shakalinux.dao.PessoaDao;
import com.br.shakalinux.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class ControllerPessoa {
    private final PessoaDao pessoaDao;

    @Autowired
    public ControllerPessoa(PessoaDao pessoaDao) {
        this.pessoaDao = pessoaDao;
    }

    @GetMapping("/")
    @ResponseBody
    public ArrayList<Pessoa> getPessoas() {
        return pessoaDao.listarPessoa();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePessoa(@PathVariable int id) {
        String resposta = pessoaDao.excluirPessoa(id);
        if(resposta.contains("sucesso")){
            return ResponseEntity.ok(resposta);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
        }
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarPessoa(@RequestBody Pessoa pessoa) {
        String resposta = pessoaDao.cadastrarPessoa(pessoa);
        if (resposta.contains("sucesso")) {
            return ResponseEntity.ok(resposta);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resposta);
        }
    }
    
    @PutMapping("/editar")
    public ResponseEntity<String> editarPessoa(@RequestBody Pessoa pessoa) {
        String resultado = pessoaDao.editarPessoa(pessoa);
        if (resultado.contains("atualizada com sucesso")) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resultado);
        }
    }

}
