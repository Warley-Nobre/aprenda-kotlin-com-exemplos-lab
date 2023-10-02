enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun listarInscritos() {
        println("Inscritos na formação '$nome':")
        for (usuario in inscritos) {
            println("- ${usuario.nome}")
        }
    }
}

fun main() {
    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin")
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos")
    val conteudo3 = ConteudoEducacional("Tópicos Avançados em Kotlin")

    val formacaoKotlin = Formacao("Formação Kotlin", listOf(conteudo1, conteudo2, conteudo3))

    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)

    formacaoKotlin.listarInscritos()
}
