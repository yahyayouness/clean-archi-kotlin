package com.cleanarchi.kotlinapi.domain.utilisateurs.models

import com.cleanarchi.kotlinapi.domain.utilisateurs.enum.TypeUtilisateur

data class Utilisateur(
    private val id: Int,
    private val nom: String,
    private val prenom: String,
    private val email: String,
    private val password: String,
    private val type: TypeUtilisateur
)
