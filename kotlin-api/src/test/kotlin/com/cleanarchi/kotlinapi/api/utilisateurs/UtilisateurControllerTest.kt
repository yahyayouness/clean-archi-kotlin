package com.cleanarchi.kotlinapi.api.utilisateurs

import com.cleanarchi.kotlinapi.domain.utilisateurs.enum.TypeUtilisateur
import com.cleanarchi.kotlinapi.domain.utilisateurs.models.Utilisateur
import com.cleanarchi.kotlinapi.domain.utilisateurs.usecases.CreerUnUtilisateur
import com.fasterxml.jackson.databind.ObjectMapper
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post

@WebMvcTest(controllers = [UtilisateurController::class])
@AutoConfigureMockMvc(addFilters = false)
class UtilisateurControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var objectMapper: ObjectMapper

    val baseUrl = "/api/utilisateurs"

    @MockkBean
    lateinit var creerUtilisateur: CreerUnUtilisateur

    @Nested
    @DisplayName("POST /api/Utilisateurs")
    @TestInstance(Lifecycle.PER_CLASS)
    inner class CreerUtilisateur {

        @Test
        fun `Quand un utilisateur s'inscrit, un compte est crée`() {
            // given
            val newUtilisateur =
                Utilisateur(1, "yahya", "youness", "yahyayounes@hotmail.fr", "Password123", TypeUtilisateur.FRONT_OFFICE)
            every { creerUtilisateur.execute(newUtilisateur) } returns newUtilisateur

            // when
            val performPost = mockMvc.post(baseUrl) {
                contentType = MediaType.APPLICATION_JSON
                content = """
                    {
                      "id": 1,
                      "nom": "yahya",
                      "prenom": "youness",
                      "email": "yahyayounes@hotmail.fr",
                      "password": "Password123",
                      "type": "FRONT_OFFICE"
                    }
                    """
                characterEncoding = "utf-8"
            }

            // then
            performPost
                .andDo { print() }
                .andExpect {
                    status { isCreated() }
                    content {
                        contentType(MediaType.APPLICATION_JSON)
                        json(objectMapper.writeValueAsString(newUtilisateur))
                    }
                }
        }
    }
}
