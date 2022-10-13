package com.cleanarchi.kotlinapi.api.utilisateurs

import com.cleanarchi.kotlinapi.domain.utilisateurs.models.Utilisateur
import com.cleanarchi.kotlinapi.domain.utilisateurs.usecases.CreerUnUtilisateur
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController(private val creerUnUtilisateur: CreerUnUtilisateur) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun creerUnUtilisateur(@RequestBody utilisateur: Utilisateur): Utilisateur = creerUnUtilisateur.execute(utilisateur)
}
