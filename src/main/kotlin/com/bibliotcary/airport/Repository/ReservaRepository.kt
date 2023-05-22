package com.bibliotcary.airport.Repository

import com.bibliotcary.airport.Reserva
import org.springframework.data.jpa.repository.JpaRepository

interface ReservaRepository : JpaRepository<Reserva, Long>
