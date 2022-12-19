// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    var nivel: Nivel = Nivel.BASICO
    var valor: Float = 0.0f
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    
    fun getDuracaoTotal(): Int {
        var duracaoTotal = 0
        for (conteudo in conteudos) {
            duracaoTotal += conteudo.duracao
        }
        return duracaoTotal
    }
    
    fun estaMatriculado(usuario: Usuario): Boolean {
        return usuario in inscritos
    }
}


fun main() {
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 45)
    val conteudo2 = ConteudoEducacional("Estruturas de Dados", 75)
    val conteudo3 = ConteudoEducacional("Algoritmos Avançados")
    val conteudos = listOf(conteudo1, conteudo2, conteudo3)
    val formacao = Formacao("Curso de Desenvolvimento de Software", conteudos)
    val usuario1 = Usuario()
    val usuario2 = Usuario()
    
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)
    
    println("Número de inscritos: ${formacao.inscritos.size}") // deve imprimir "Número de inscritos: 2"
    
    println("Duração total da formação: ${formacao.getDuracaoTotal()} minutos") // deve imprimir "Duração total da formação: 180 minutos"
    
    println("Usuário 1 está matriculado? ${formacao.estaMatriculado(usuario1)}") // deve imprimir "Usuário 1 está matriculado? true"
    println("Usuário 3 está matriculado? ${formacao.estaMatriculado(Usuario())}") // deve imprimir "Usuário 3 está matriculado? false"
}

