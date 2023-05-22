package com.bibliotcary.airport

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Aeropuerto(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "nombre")
    val nombre: String,

    val ubicacion: String,

    @Column(name = "codigo")
    val codigo: String,

    // Otras propiedades y relaciones relevantes
) {
    constructor() : this(0,"","","")
}

