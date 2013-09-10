
/**
 * User: pedrofurla
 * Date: 09/09/13
 * Time: 05:18
 */
object Classes {

  /*wiki
    Isso representa uma classe com getters e setter para `nome` e `idade`.
    var neste caso indica que os campos são mutáveis, e portanto precisam de setters também
    val por outro lado indica que o campo é imutável então terá apenas getter.
   */
  class Pessoa(val nome:String, var idade: Int) {
    import java.util.Date
    def anoNascimento = new Date().getYear - idade
  }

  /*wiki
  Mais ou menos como essa classe simulando como se faz em POJO.
  Neste caso para mantermos a regra do nome imutável teriamos que fazer alguma cambi. Vou ignorar isso.
  Note, fora os campos, e os parametros dos setters fica tudo a cargo do compilador.
   */
  class PessoaJava {
    import java.util.Date

    private var nome:String = _
    private var idade:Int = _
    def getNome = nome
    def getIdade = idade
    def setNome(n:String) = nome = n
    def setIdade(i:Int) = idade = i
    def getAnoNascimento = new Date().getYear - idade
  }

  val joao = new Pessoa("João", 43)
  val joaoNasceuEm = joao.anoNascimento

  /*wiki ops errei a idade do joão */
  val joao2 = new Pessoa(joao.nome, 35)
  val joao2NasceuEm = joao.anoNascimento

  /*wiki agora sim*/

  /*wiki Compare isso com: */
  val pedro = new PessoaJava()
  pedro.setNome("Pedro")
  pedro.setIdade(35)

  val pedroNasceuEm = pedro.getAnoNascimento

  /*wiki Nesses dois exemplos eu deixei hashCode e equals de fora de proposito! Vamos ver o porquê no proximo seguimento*/


}
