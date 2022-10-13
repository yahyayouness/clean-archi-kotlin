package com.cleanarchi.kotlinapi.domain.utilisateurs.usecases

import com.cleanarchi.kotlinapi.domain.utilisateurs.enum.TypeUtilisateur
import com.cleanarchi.kotlinapi.domain.utilisateurs.models.Utilisateur
import com.cleanarchi.kotlinapi.domain.utilisateurs.repositories.IUtilisateurRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class CreerUnUtilisateurUseCaseTest {

    private val utilisateurRepository: IUtilisateurRepository = mockk()
    private val creerUtilisateur = CreerUnUtilisateur(utilisateurRepository)

    @Nested
    @DisplayName("Utilisateur")
    inner class UserLoggedIn {

        @Test
        fun `Lors de l'inscription, un utilisateur doit être créé`() {
            // Given
            val utilisateur =
                Utilisateur(1, "yahya", "youness", "yahyayounes@hotmail.fr", "Password123", TypeUtilisateur.BACK_OFFICE)
            every { utilisateurRepository.creerUnUtilisateur(utilisateur) } returns utilisateur
            // When
            val result = creerUtilisateur.execute(utilisateur)
            // Then
            verify(exactly = 1) { utilisateurRepository.creerUnUtilisateur(utilisateur) }
            assertThat(result).isEqualTo(utilisateur)
        }
    }
}
