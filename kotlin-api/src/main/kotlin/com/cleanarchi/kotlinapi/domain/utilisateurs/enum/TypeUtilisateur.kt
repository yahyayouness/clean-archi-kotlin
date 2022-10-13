package com.cleanarchi.kotlinapi.domain.utilisateurs.enum

enum class TypeUtilisateur(val code: String) {
    BACK_OFFICE("BO"),
    FRONT_OFFICE("FO");

    companion object {
        fun getByCode(code: String) = TypeUtilisateur.values().filter { it.code == code }
    }
}
