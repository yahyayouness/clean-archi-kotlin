package com.cleanarchi.kotlinapi.domain.utilisateurs.usecases

import com.cleanarchi.kotlinapi.domain.utilisateurs.models.Utilisateur
import com.cleanarchi.kotlinapi.domain.utilisateurs.repositories.IUtilisateurRepository
import org.springframework.stereotype.Service

@Service
class CreerUnUtilisateur(private val utilisateurRepository: IUtilisateurRepository) {

    fun execute(utilisateur: Utilisateur): Utilisateur = utilisateurRepository.creerUnUtilisateur(utilisateur)
}
