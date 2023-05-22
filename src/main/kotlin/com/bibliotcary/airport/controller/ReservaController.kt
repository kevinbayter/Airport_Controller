package com.bibliotcary.airport.controller

import com.bibliotcary.airport.Reserva
import com.bibliotcary.airport.Repository.ReservaRepository
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/reserva")
class ReservaController(private val reservaRepository: ReservaRepository) {

    @GetMapping("/get")
    fun obtenerReservas(): List<Reserva> {
        return reservaRepository.findAll()
    }

    @GetMapping("/{id}")
    fun obtenerReservaPorId(@PathVariable id: Long): Reserva {
        return reservaRepository.findById(id).orElseThrow { NoSuchElementException() }
    }

    @PostMapping("/add")
    fun agregarReserva(@RequestBody reserva: Reserva): Reserva {
        return reservaRepository.save(reserva)
    }

    @PostMapping("/addresrvas")
    fun agregarReservas(@RequestBody reservas: List<Reserva>): List<Reserva> {
        return reservaRepository.saveAll(reservas)
    }

    @PutMapping("/{id}")
    fun actualizarReserva(@PathVariable id: Long, @RequestBody reserva: Reserva): Reserva {
        val reservaExistente = reservaRepository.findById(id).orElseThrow { NoSuchElementException() }
        reservaExistente.id = reserva.id
        reservaExistente.fecha = reserva.fecha
        reservaExistente.vuelo = reserva.vuelo
        reservaExistente.pasajero = reserva.pasajero
        return reservaRepository.save(reservaExistente)
    }

    @DeleteMapping("/{id}")
    fun eliminarReserva(@PathVariable id: Long) {
        reservaRepository.deleteById(id)
    }
}
