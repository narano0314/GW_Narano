package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ThirdServlet extends HttpServlet {

	//doget
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//送信されてくるパラメーターのエンコーディング
		req.setCharacterEncoding("UTF-8");
		//送信したパラメーターの取得
		String name =req.getParameter("name");
		String age =req.getParameter("age");
		String gen =req.getParameter("gen");
		String kyoumi[] =req.getParameterValues("kyoumi");
		String what =req.getParameter("what");
		//以下、HTML形式で出力されるためのコード
		resp.setContentType("text/html;charset=UTF-8");
		//ServletでHTMLを書くための準備をしている。
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<body>");
		out.print("<h1>名前：</h1>");
		out.println("<p>"+name+"</p>");
		out.print("<h1>年齢：</h1>");
		out.println("<p>"+age+"</p>");
		out.print("<h1>性別：</h1>");
		out.println("<p>"+gen+"</p>");
		out.print("<h1>興味がある言語：</h1>");
		//チェックなしなら何も返さない
		if (kyoumi==null) {
			out.print("<p>"+""+"</p>");
		//チェックあり複数選択可能にする
		}else {
		for (int i = 0; i < kyoumi.length; i++) {
			out.print("<p>"+kyoumi[i]+""+"</p>");
		}
		}
		out.print("<h1>何か一言：</h1>");
		out.println("<p>"+what+"</p>");
		out.println("</head>");
		out.println("</body>");
		out.println("</html>");
		//HTMLに満足したらcloseしてね
		out.close();

	}
}