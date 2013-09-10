/**
 * User: pedrofurla
 * Date: 09/09/13
 * Time: 05:18
 */
object Cases {

  /*wiki Vamos voltar ao nosso exemplo de pessoa mas mudar uma pouquinho.

    Neste caso algumas pessoas são tímida e preferem não revelar a idade.
  */
  case class Pessoa(nome:String, idade:Option[Int])
  /*wiki Omiti de proposito o metodo ano de nascimento. Veremos por que no proximo seguimento */

  /*wiki
    Uma case class é uma classe comum, só que seus atributos são por default `vals`. Isso quer dizer
    que temos apenas getters para ele.

    Também ela nos da de graça implementações the toString, equals e hashCode! E também um method construtor,
    não precisamos escrever o `new`.

    Joao por exemplo preferiu omitir sua idade:
   */
   val joao = Pessoa("João", None)
   val pedro = Pessoa("Pedro", Some(35))

  /*wiki
    Juquinha: mas que coisa de Option[Int] é essa?

    No mundo java usa-se null para indicar uma série de coisas, uma delas é a ausencia de algum dados.
    Um dos seus problemas é que null não pode ser composto (em termos the composição de funções) e precisam ser
    constantemente tratados. Vamos ver que usando Option não só estamos indicando no código que um algum dado pode
    estar ausente como pode compor funções que nos ajudarão com muita conveniencia a indicar computações que não são
    completadas por essa ausencias de dados.

    Option é uma classe com um parametro de tipo declarada +- ou menos assim
      abstract class Option[I]
      class Some[I](v: I] extends Options[I]
      class None extends Option[Nothing]

    Apropósito! Esse este é o primeiro Tipo Algebraico de Dados (ADT do ingles) apresentado. Ele representa uma peça
    importante no mode FP de resolver problemss.

    Veremos mais a frente que ela quase equivale a uma lista que pode ter apenas 1 ou 0 elementos.

    Na prática NUNCA NUNCA NUNCA NUNCA NUNCA USE *NULL*! NUNCA!
   */

}
