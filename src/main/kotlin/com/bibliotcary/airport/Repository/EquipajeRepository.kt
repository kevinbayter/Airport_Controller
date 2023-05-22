package com.bibliotcary.airport.Repository

import com.bibliotcary.airport.Equipaje
import org.springframework.data.jpa.repository.JpaRepository

interface EquipajeRepository : JpaRepository<Equipaje, Long>
