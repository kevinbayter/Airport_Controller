package com.bibliotcary.airport.controller

import com.bibliotcary.airport.Aeropuerto
import com.bibliotcary.airport.Repository.AeropuertoRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/aeropuerto")
class AeropuertoController(private val aeropuertoRepository: AeropuertoRepository) {

    @GetMapping
    fun obtenerTodosLosAeropuertos(): List<Aeropuerto> {
        return aeropuertoRepository.findAll()
    }

    @GetMapping("/{id}")
    fun obtenerAeropuertoPorId(@PathVariable id: Long): ResponseEntity<Any> {
        val aeropuerto = aeropuertoRepository.findById(id)
        return if (aeropuerto.isPresent) {
            ResponseEntity.ok(aeropuerto.get())
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    fun crearAeropuerto(@RequestBody aeropuerto: Aeropuerto): ResponseEntity<Aeropuerto> {
        val nuevoAeropuerto = aeropuertoRepository.save(aeropuerto)
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoAeropuerto)
    }

    @PutMapping("/{id}")
    fun actualizarAeropuerto(@PathVariable id: Long, @RequestBody nuevoAeropuerto: Aeropuerto): ResponseEntity<Aeropuerto> {
        return aeropuertoRepository.findById(id).map { aeropuerto ->
            val aeropuertoActualizado: Aeropuerto = aeropuerto
                    .copy(nombre = nuevoAeropuerto.nombre, ubicacion = nuevoAeropuerto.ubicacion, codigo = nuevoAeropuerto.codigo)
            ResponseEntity.ok().body(aeropuertoRepository.save(aeropuertoActualizado))
        }.orElse(ResponseEntity.notFound().build())
    }

    @DeleteMapping("/{id}")
    fun eliminarAeropuerto(@PathVariable id: Long): ResponseEntity<Any> {
        return aeropuertoRepository.findById(id).map { aeropuerto ->
            aeropuertoRepository.delete(aeropuerto)
            ResponseEntity.ok().build<Any>()
        }.orElse(ResponseEntity.notFound().build())
    }
}
