
<%@ page contentType= "text/html;charset=UTF-8"%>

<%
System.out.println("-------------");
out.print("{"+
"left:[{id:'p1',title:'"+bundle.getString("GG000034640")+"',headtype:'WIDE_HEAD',url:'../portlets/sysmsg.jsp'}]"+
",top_d:[{id:'p2',title:'"+bundle.getString("GG000034641")+"',headtype:'COMM_HEAD',url:'../portlets/mytop.jsp'}]"+
",bottom_left_d:[{id:'p6',title:'"+bundle.getString("GG000034642")+"',headtype:'COMM_HEAD',url:'../portlets/left1.html'},{id:'p3',title:'"+bundle.getString("GG000034643")+"',headtype:'COMM_HEAD',url:'../portlets/yeji.html'}]"+
",bottom_right_d:[{id:'p4',title:'"+bundle.getString("GG000034644")+"',headtype:'COMM_HEAD',url:'../portlets/gonggao.jsp'},{id:'p5',title:'"+bundle.getString("GG000034645")+"',headtype:'COMM_HEAD',url:'../portlets/richeng.jsp'}]"+
"}");
%>