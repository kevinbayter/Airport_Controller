package com.bibliotcary.airport.controller

import com.bibliotcary.airport.Vuelo
import com.bibliotcary.airport.Repository.VueloRepository
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/vuelos")
class VueloController(private val vueloRepository: VueloRepository) {

    @GetMapping("/getvuelos")
    fun obtenerVuelos(): List<Vuelo> {
        return vueloRepository.findAll()
    }

    @GetMapping("/{id}")
    fun obtenerVueloPorId(@PathVariable id: Long): Vuelo {
        return vueloRepository.findById(id).orElseThrow { NoSuchElementException() }
    }

    @PostMapping("/add")
    fun agregarVuelo(@RequestBody vuelo: Vuelo): Vuelo {
        return vueloRepository.save(vuelo)
    }

    @PutMapping("/{id}")
    fun actualizarVuelo(@PathVariable id: Long, @RequestBody vuelo: Vuelo): Vuelo {
        val vueloExistente = vueloRepository.findById(id).orElseThrow { NoSuchElementException() }
        vueloExistente.numeroVuelo = vuelo.numeroVuelo
        vueloExistente.fechaSalida = vuelo.fechaSalida
        vueloExistente.fechaLlegada = vuelo.fechaLlegada
        vueloExistente.aeropuertoOrigen = vuelo.aeropuertoOrigen
        vueloExistente.aeropuertoDestino = vuelo.aeropuertoDestino
        return vueloRepository.save(vueloExistente)
    }

    @DeleteMapping("/{id}")
    fun eliminarVuelo(@PathVariable id: Long) {
        vueloRepository.deleteById(id)
    }
}
