package com.bibliotcary.airport.Repository

import com.bibliotcary.airport.Aeropuerto
import org.springframework.data.jpa.repository.JpaRepository

interface AeropuertoRepository : JpaRepository<Aeropuerto, Long>