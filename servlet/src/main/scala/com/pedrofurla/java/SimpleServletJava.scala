package com.pedrofurla.java

import scala.xml.NodeSeq
import javax.servlet.http.HttpServlet


class SimpleServletJava extends HttpServlet {

  import javax.servlet.http.HttpServletRequest
  import javax.servlet.http.HttpServletResponse

  override def doGet(req: HttpServletRequest, resp: HttpServletResponse) {

    resp.setContentType("text/html")
    resp.setCharacterEncoding("UTF-8")

    // TROUBLE // TROUBLE // TROUBLE
    var a:Int = req.getParameter("a").toInt
    var b:Int = req.getParameter("b").toInt
    var c:Int = req.getParameter("c").toInt

    val responseBody: NodeSeq =
      <html>
        <body>
          <h1>Hello, world!</h1>
          A some de {a} + {b} + {c} = {a+b+c}
        </body>
      </html>
    resp.getWriter.write(responseBody.toString)

  }



}
