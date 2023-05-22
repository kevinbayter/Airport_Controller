package com.bibliotcary.airport.Repository

import com.bibliotcary.airport.Pasajero
import org.springframework.data.jpa.repository.JpaRepository

interface PasajeroRepository : JpaRepository<Pasajero, Long>