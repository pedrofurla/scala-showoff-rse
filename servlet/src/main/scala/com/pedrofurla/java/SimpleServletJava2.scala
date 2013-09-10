package com.pedrofurla.java

import scala.xml.NodeSeq
import javax.servlet.http.HttpServlet

class SimpleServletJava2 extends HttpServlet {

  import javax.servlet.http.HttpServletRequest
  import javax.servlet.http.HttpServletResponse

  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) {

    resp.setContentType("text/html")
    resp.setCharacterEncoding("UTF-8")

    def getParam(p:String):Integer=Integer.parseInt(req.getParameter(p))

    // LESS TROUBLE // LESS TROUBLE // LESS  TROUBLE
    // but very awkward! Gambis de primeira rolando solta!

    var a:Integer = null
    var b:Integer = null
    var c:Integer = null

    try {
      a = getParam("a")
    } catch {
      case ex : NumberFormatException =>
    }
    try {
      b = getParam("b")
    } catch {
      case ex: NumberFormatException =>
    }
    try {
      c = getParam("c")
    } // LOOK NO CATCH!

    val responseBody: NodeSeq =
      <html>
        <body>
          <h1>Hello, world!</h1>
          {
            if (a != null && b != null & c != null) s"A some de {a} + {b} + {c} = {a+b+c}"
            else s"Algum dos números não é valido: a: `{a}` ou b: `{b}` ou c: `{c}` "
          }
        </body>
      </html>
    resp.getWriter.write(responseBody.toString)
  }

}
