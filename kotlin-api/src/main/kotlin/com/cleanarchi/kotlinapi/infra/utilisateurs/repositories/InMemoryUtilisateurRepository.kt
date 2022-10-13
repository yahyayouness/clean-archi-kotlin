package com.cleanarchi.kotlinapi.infra.utilisateurs.repositories

import com.cleanarchi.kotlinapi.domain.utilisateurs.models.Utilisateur
import com.cleanarchi.kotlinapi.domain.utilisateurs.repositories.IUtilisateurRepository
import org.springframework.stereotype.Repository

@Repository
class InMemoryUtilisateurRepository() : IUtilisateurRepository {
    override fun creerUnUtilisateur(utilisateur: Utilisateur): Utilisateur = utilisateur
}
