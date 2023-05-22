package com.bibliotcary.airport.controller

import com.bibliotcary.airport.Pasajero
import com.bibliotcary.airport.Repository.PasajeroRepository
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/pasajero")
class PasajeroController(private val pasajeroRepository: PasajeroRepository) {

    @GetMapping("/get")
    fun obtenerPasajeros(): List<Pasajero> {
        return pasajeroRepository.findAll()
    }

    @GetMapping("/{id}")
    fun obtenerPasajeroPorId(@PathVariable id: Long): Pasajero {
        return pasajeroRepository.findById(id).orElseThrow { NoSuchElementException() }
    }

    @PostMapping("/add")
    fun agregarPasajero(pasajero: Pasajero): Pasajero {
        return pasajeroRepository.save(pasajero)
    }

    @PutMapping("/{id}")
    fun actualizarPasajero(id: Long, pasajero: Pasajero): Pasajero {
        val pasajeroExistente = pasajeroRepository.findById(id).orElseThrow { NoSuchElementException() }
        pasajeroExistente.id = pasajero.id
        pasajeroExistente.nombre = pasajero.nombre
        pasajeroExistente.documento = pasajero.documento

        return pasajeroRepository.save(pasajeroExistente)
    }

    @DeleteMapping("/{id}")
    fun eliminarPasajero(@PathVariable id: Long) {
        pasajeroRepository.deleteById(id)
    }
}