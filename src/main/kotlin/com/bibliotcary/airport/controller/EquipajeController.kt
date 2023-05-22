package com.bibliotcary.airport.controller

import com.bibliotcary.airport.Equipaje
import com.bibliotcary.airport.Repository.EquipajeRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/equipaje")
class EquipajeController(private val equipajeRepository: EquipajeRepository) {

    @GetMapping("/get")
    fun obtenerEquipajes(): List<Equipaje> {
        return equipajeRepository.findAll()
    }

    @GetMapping("/{id}")
    fun obtenerEquipajePorId(@PathVariable id: Long): Equipaje {
        return equipajeRepository.findById(id).orElseThrow { NoSuchElementException() }
    }

    @PostMapping("/add")
    fun agregarEquipaje(@RequestBody equipaje: Equipaje): Equipaje {
        return equipajeRepository.save(equipaje)
    }

    @PutMapping("/{id}")
    fun actualizarEquipaje(@PathVariable id: Long, @RequestBody equipaje: Equipaje): Equipaje {
        val equipajeExistente = equipajeRepository.findById(id).orElseThrow { NoSuchElementException() }
        equipajeExistente.id = equipaje.id
        equipajeExistente.peso = equipaje.peso
        equipajeExistente.numeroRastreo = equipaje.numeroRastreo
        equipajeExistente.pasajero = equipaje.pasajero

        return equipajeRepository.save(equipajeExistente)
    }

    @DeleteMapping("/{id}")
    fun eliminarEquipaje(@PathVariable id: Long) {
        equipajeRepository.deleteById(id)
    }
}
