package com.example.Luz.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Luz.dto.UsuarioDTO;


@RestController
@RequestMapping ("/usuarios")
public class UsuarioController {
	//http://Localhost:8080/usuarios
	Map<String,String> mapUsers =new HashMap<>();
	
	
  //object-El ? responde a cualquier cosa si no se-Responder al usuario true registro, una lista

    
@PostMapping ("/create")
	public ResponseEntity<Object> createUser(@RequestBody UsuarioDTO usuarioDTO){
		mapUsers.put("1",usuarioDTO.getNombre());
		mapUsers.put("2",usuarioDTO.getApellido());
		return ResponseEntity.status(HttpStatus.OK).body(mapUsers);
}
@GetMapping ("read/{id}")
public ResponseEntity<Object> readUser(@PathVariable String id){
	return ResponseEntity.status(mapUsers.containsKey(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND).body(mapUsers.containsKey(id) ? mapUsers.get(id) : "No existe");

}
	  
@PutMapping ("update/{id}")
    public ResponseEntity <Object> User (@RequestBody UsuarioDTO usuarioDTO, @PathVariable String id) {
    	
    	mapUsers.put(id, usuarioDTO.getNombre());
        
        return ResponseEntity.status(HttpStatus.OK).body(mapUsers);
    }

    

@DeleteMapping ("delete/{id}")
    public ResponseEntity <Object> deleteUser (@PathVariable String id) {
    	
    	mapUsers.remove(id);
    	return ResponseEntity.status(HttpStatus.OK).body("Eliminado");

    }

    
}

