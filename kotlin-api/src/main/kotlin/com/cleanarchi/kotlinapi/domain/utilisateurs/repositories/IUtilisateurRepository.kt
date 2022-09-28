package com.cleanarchi.kotlinapi.domain.utilisateurs.repositories

import com.cleanarchi.kotlinapi.domain.utilisateurs.models.Utilisateur

interface IUtilisateurRepository {

    fun creerUnUtilisateur(utilisateur: Utilisateur): Utilisateur
}
