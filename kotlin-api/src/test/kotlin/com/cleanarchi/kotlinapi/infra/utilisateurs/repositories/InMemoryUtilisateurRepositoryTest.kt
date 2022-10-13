package com.cleanarchi.kotlinapi.infra.utilisateurs.repositories

import com.cleanarchi.kotlinapi.domain.utilisateurs.enum.TypeUtilisateur
import com.cleanarchi.kotlinapi.domain.utilisateurs.models.Utilisateur
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InMemoryUtilisateurRepositoryTest {

    private val inMemoryUtilisateurRepository = InMemoryUtilisateurRepository()

    @Test
    fun `Doit retourner l'utilisteur créé`() {
        // Given
        val utilisateur = Utilisateur(1, "yahya", "youness", "yahyayounes@hotmail.fr", "Password123", TypeUtilisateur.FRONT_OFFICE)

        // When
        val result = inMemoryUtilisateurRepository.creerUnUtilisateur(utilisateur)

        // Then
        val utilisateurAttendu = Utilisateur(1, "yahya", "youness", "yahyayounes@hotmail.fr", "Password123", TypeUtilisateur.FRONT_OFFICE)
        assertThat(utilisateur).isEqualTo(utilisateurAttendu)
    }
}
