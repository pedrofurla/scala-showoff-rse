/**
 * User: pedrofurla
 * Date: 09/09/13
 * Time: 18:39
 */
object Implicits {

  /*wiki
    Scala Implicits tem três funções distintas em Scala.
    A primeira é prover valores de terminados tipo automaticamente.
    Vamos ver um exemplo similando conexões de banco de dados ficticios
   */

  object PrecismosUsarBDAqui  {

    class DbConnection(val dbName: String)

    val oracleConnection = new DbConnection("Oracle")
    val mysqlConnection = new DbConnection("MySql")

    implicit val currConnection = oracleConnection

    def usaDB(implicit db:DbConnection) = "Estou usando db: "+db.dbName

    /*wiki
    Já que o parâmetro para usaDB é declarado como implicito não precisamos preenche-lo.
    O compilador faz isso pra a gente.
     */
    println(usaDB)

    /*wiki
    Mas podemos usa-los explicitamente também
     */
    println(usaDB(mysqlConnection))

  }

  /*wiki
  O segundo uso de implicitos é converter dados.

  Vamos supor que os usuários do banco de dados acima perceberam que conexões diretas não estavam escalando!
   Eles então decidiram usar Pools de conexão.
   */
  object SoccoroPrecisamosdePools {
    import PrecismosUsarBDAqui.{DbConnection, oracleConnection, mysqlConnection}

    class Pool(db:DbConnection) {
      override def toString = "Eu sou Pool do banco "+db.dbName
    }

    /*wiki
      Mas imagine se houvesse 3405 conexões diferente!

      Bom, converções implicitas poderiam fazer o trabalho pra a gente
    */

    implicit def conn2Pool(db : DbConnection) = new Pool(db)


    def usaPool(pool:Pool) = "Estou usando : " +pool

    /*wiki et voilá, la magick est fait!*/

    println(usaPool(oracleConnection))
    println(usaPool(mysqlConnection))

    /*wiki
      Mas como isso funciona?
      Pode parecer complicado, mas é bem simples.

      o metodo declarado implicit `conn2poll` recebe o tipo DbConnection e retorna um Pool, podemos escrever
      `DbConnection => Pool` para visualizar mais facilmente.
      O método usaPool recebe Pool. Quando usamos um tipo diferente em usaPool, no caso oracleConnection (que é
      um DbConnection), o compilador procura por uma conversão implicita de DbConnection para Pool. E essa conversão
      for achada ela é aplicada.

      No fim das contas o que acontece é `usaPool(conn2Pool(oracleConnection))`.
    */

  }

  /*wiki
  O terceiro uso, que de certa forma é bem parecido com o anterior, chamava-se originalmente "Pimp my Library", uma especia
  de trocadinho ao programa de TV "Pimp my Ride". Mas alguém, provavelmente um americano republicano, considerou o uso
  da palavra "pimp" (cafetão em inglês) ofensivo. Então rebatizaram esse uso de implicitos para "Class Enrichment" ou
  "Class enhancement". Eu continuo chamando de pimping!
   */
  object Pimping {

    /*wiki
    No nosso exemplo da `case class` Pessoa não tinha um método para indicar o ano de nascimento. Podemos resolver isso
    usando conversões implicitas:
     */

    import Cases._

    implicit def pimpPessoa(p:Pessoa) = new Object {
      import java.util.Date
      /*wiki Poderiamos fazer como abaixo, só que a idade da nossa pessoa é um Option! */
      // def anoNascimento = new Date().getYear - p.idade
      def anoNascimento = p.idade.map { i => new Date().getYear - i }
    }

    /*wiki
    Note, estamos fazendo uma conversão implicita de Pessoa para um objeto com um método chamado anoNascimento. OU
    em outras palavras: Pessoa => { def anoNascimento }

    Vamos ver o que acontece:
     */

    def idades:Unit = {
      println("Ano nascimento Pedro: "+pedro.anoNascimento)
      println("Ano nascimento João: "+joao.anoNascimento)
    }

    /*wiki Basicamente o compilador sabe que Pessoa não tem um método anoNascimento e procura por alguma conversão que
    possa prover essa método, no nosso caso ele encontra Pessoa => { def anoNascimento }, o nosso `pimpPessoa`. Por fim,
    `pedro.anoNascimento` é transformado em `pimpPessoa(pedro).anoNascimento`!

    Et voilà! Estamos prontos para "colocar" métodos em classes existentes!!! Yay!!!
     */

  }

  /*wiki
  Na verdade existe mais um uso para implicitos, ele se chama typeclasses! É a base das coisas mais interessantes que se pode
  fazer com Scala. Se você já trabalhou com Haskell já conhece alguns type classes
   */
}

