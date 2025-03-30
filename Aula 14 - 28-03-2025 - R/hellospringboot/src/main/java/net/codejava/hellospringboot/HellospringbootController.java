/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.codejava.hellospringboot;

/**
 *
 * @author MSWagner
 */

import org.springframework.web.bind.annotation.*;

@RestController
public class HellospringbootController {

    // Conexão tipo GET HTTP
    @GetMapping("/hello")
    public String index() {
        return "<h1>Olá Mundo!</h1>";
    }

    // Conexão tipo GET HTTP
    @RequestMapping("/cadastro/{nome}")
    public String dizernome(@PathVariable String nome) {
        return "Olá, meu nome é " + nome;
    }

    // Conexão tipo GET HTTP
    // Exemplo: http://localhost:8080/info?nome=Marcel&idade=30
    @RequestMapping("/info")
    public String apresentar(@RequestParam("nome") String nome, @RequestParam("idade") int idade) {
        return "<h1>Olá pessoal, meu nome é " + nome + " e eu tenho " + idade + " anos</h1>";
    }
    
    // Conexão tipo POST HTTP
    @PostMapping("/postar")
    public String postar() {
        return "Objeto postado com sucesso.";
    }
}
