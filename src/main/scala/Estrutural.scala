/**
 * User: pedrofurla
 * Date: 09/09/13
 * Time: 05:20
 */

/*wiki

 Juquinha: Olha só, tem um tal de `object` abaixo!

 Pois é, é um objeto singleton. Alem de ser um "módulo de primeira classe" também
 funciona como namespace. Mais sobre isso à frente.

 */
object Estrutural {

  /*wiki
  Métodos são definidos com `def` e o tipo é declarado com após `:`.

  Também, Scala é uma linguagem completamente baseada em expressões, portanto não se usa `return`,
  pois quase sempre estamos interessados no retorno da expressão ou de um bloco de código! Imagina só
  "return" em todo lugar! (Javascript, alguém?)
   */
  def queHorasSão:String = new java.util.Date().toString

  def começaComP(str:String) = if(str.startsWith(str)) "SIM" else "NÃO"

  /*wiki
  Variáveis são definidas com `var`
   */
  var agora = queHorasSão

  /*wiki
  Note que acima, não declarei o tipo, em muitas situações o compilador infere o tipo.

  Mas abusar de variáveis é desencorajado em Scala. Vai que alguém decide alterar "agora", vamos perder a hora!
   */
  val agoraMesmo = queHorasSão

  /*wiki
  O tipo `Unit` é mais ou menos como o `void` do Java, só que faz parte do sistema de tipos, e tem vários usos.
   */
  def zoarAgora:Unit = {
    /*wiki
      Olha que legal, podemos usar import em qualquer nível de escopo, e o escopo atual e os abaixo terão a visibilidade
      do que foi importado.
    */
    import java.util.Date

    /*wiki
      Também podemos definir funções/metodos aninhados!
     */
    def horaZero = new Date(0,0,0,0,0,0).toString

    agora = horaZero
  }

  /*wiki
  Juquinha: Mas e essa estória de "funcional" ? Cadê as funções? Ou é funcional porque funciona?

  Funções anônimas são declaradas usando-se o `=>` para separar argumentos formais do corpo da função.
   */
  val adicionar = (a:Int, b:Int) => a + b

  /*wiki
  Note que não declarei o tipo na definição de `adicionar` e nem no resultado. Neste caso, declarei os tipos que a função
  recebe diretamente nos argumentos. Poderemos ter feito de outra forma:
   */
  val adicionarDeNovo: (Int, Int) => Int = (a,b) => a + b
  /*wiki
  Desta vez foi ao contrário. Declarei os tipos em `adicionar2`, sendo `(Int,Int) => Int` um indicador de uma função que
  recebe dois inteiros e devolve um inteiro. Ou pra quem gosta de matemática f: Int x Int -> Int
   */

  /*wiki
  Agora que sabemos como criar funções podemos criar funções que recebem funções!
  Eis o cálculo da derivada em um determinado ponto:
   */
  def derivada(f: Double => Double, x:Double, fi:Double) = ( f(x + fi) - f(x) ) / fi

  /*wiki Agora um simples quadrado */
  val quadrado: Double => Double = x => x*x

  /*wiki Uma derivada bem pouco precisa... Meio chumbrela. */
  val derivadaChumbrela: ( (Double => Double), Double ) => Double =
    derivada(_, _, 0.1)

  /*wiki
    Juquinha: Peraí, você já ta querendo que eu entenda matemática! O que matemática tem haver com programação funcional?
    Alem do mais eu estudei informática! Não matemática! O que são esses sublinhados em todo lugar! Ta confuso!

    Bom, primeiro, de onde você acha que vem o nome função? Não é da linguagem C nem Pascal! Mas não vamos entrar neste mérito agora. Podemos ver mais a
    respeito depois.

    Sobre os sublinhados. Bom, eles são uma espécie de "placeholders", indicado que queremos transformar essa expressão em uma função
    que recebe o valor no "_" como parâmetro. O nome técnico disso é aplicação parcial e quer dizer que apenas alguns
    dos argumentos são aplicados.
   */
  val derivadaDoQuadrado = derivadaChumbrela(quadrado, (_:Double))

  /*wiki
    Bom, os exemplos acima são apenas ilustrativos. Não se preocupe com a parte de "derivada".

    Agora vamos brincar um pouco com funções e listas. No REPL, digite
      import Estructural._
      :t numeros

    Imports em Scala usam "_" para indicar tudo de um determinado espaco de nomes.

    ":t algumaCoisa" irá nos dizer o tipo dessa alguma coisa. Tente
       :t adicionar
       :t adicionar5
   */
  val numeros = List(1,2,3,4,5,6,7,8,9,10)

  val adicionar5 = adicionar(5, (_: Int))

  val numerosMais5 = numeros.map(adicionar5)

  val par: Int => Boolean = i => (i % 2) == 0

  val pares = numeros.filter(par)

  val paresGrandes = numeros.filter(x => par(x) && x > 5)

  val somaNumeros = numeros.fold(0)(adicionar)
}
