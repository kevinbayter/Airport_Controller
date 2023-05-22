package com.bibliotcary.airport

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class Pasajero (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    @Column(name = "nombre")
    var nombre: String,

    @Column(name = "documento")
    var documento: String,
) {
    constructor() : this(0, "", "")
}
