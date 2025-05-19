package com.pokemonmovethailand.pokemonmovebackend.controller;

import com.pokemonmovethailand.pokemonmovebackend.entity.Pokemonmove;
import com.pokemonmovethailand.pokemonmovebackend.service.PokemonmoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.EntityModel;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class PokemonmoveController {
    private PokemonmoveService pokemonmoveService;
    //  Page<Pokemonmove> (ข้อมูลพร้อม pagination) ให้ออกมาเป็น PagedModel<EntityModel<Pokemonmove>> ทำให้ JSON ดูเรียบร้อยใช้งานง่ายขึ้น
    private PagedResourcesAssembler<Pokemonmove> assembler;
    @Autowired
    public  PokemonmoveController(PokemonmoveService pokemonmoveService , PagedResourcesAssembler pagedResourcesAssembler){
        this.pokemonmoveService = pokemonmoveService;
        this.assembler = pagedResourcesAssembler;
    }

    @GetMapping("/pokemonmoves")
    public PagedModel<EntityModel<Pokemonmove>> FindPokemonMoves(@RequestParam(defaultValue = "0") int page , @RequestParam(defaultValue = "100") int size){
        // RequestParam รับค่าจาก Query String
        // PagedModel<EntityModel<Pokemonmove>>  Type return ให้ดูหน้าตา Json อ่านง่ายขึ้น
        // สร้างตัวแปร Pageable จาก page กับ size เพื่อส่งไปให้ service ดึงข้อมูลแบบแบ่งหน้า
        Pageable pageable = PageRequest.of(page , size);
        Page<Pokemonmove> movesPage = pokemonmoveService.findAll(pageable);
        //ใช้ assembler แปลงข้อมูล Page<Pokemonmove> ที่ได้เป็น PagedModel<EntityModel<Pokemonmove>>
        //เพื่อให้ JSON ที่ส่งกลับมีโครงสร้างที่พร้อมสำหรับการทำ pagination ทำให้ FontEnd ทำงานง่ายขึ้น
        return assembler.toModel(movesPage);
    }

    @GetMapping("/pokemonmoves/search")
    public ResponseEntity<Pokemonmove> FindPokemonName(@RequestParam String name){
        Optional<Pokemonmove> move = pokemonmoveService.findByName(name);
        if(move.isPresent()){
            return ResponseEntity.ok(move.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/pokemonmoves/autocomplete")
    public  ResponseEntity<List<String>> AutoCompletePokemonName(@RequestParam String keyword){
        List<String> moves = pokemonmoveService.findByNameAutoComplete(keyword);
        return ResponseEntity.ok(moves);
    }
}
