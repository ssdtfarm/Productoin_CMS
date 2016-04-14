package com.sinosoft.utility;

import java.io.File;

import javax.mail.internet.MimeUtility;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;

import com.sinosoft.Resource.bundle;
import com.sinosoft.utility.ExeSQL;
import com.sinosoft.utility.SSRS;

public class MailSender {

	private String mailType; //邮件类型
	private String mailTitle; //邮件标题
	private String mailMsg; //邮件内容
	private String mailTo; //收件人
	private String mailCc; //抄送人
	private String mailFromUrl; //发件人
	private String mailFromUser; //发件人邮箱登录名
	private String mailFromPwd; //发件人邮箱密码
	private String smtpHost; //邮件发送服务器
	private String SmtpPort; //邮件发送服务器端口
	
	public boolean send() throws Exception {
		if(mailType==null || "".equals(mailType))
		{
			System.out.println("邮件类型参数缺失！");
			return false;
		}
		sendMail();
		return true;
	}
	
	public boolean send2(String MailTo, String MailCc) throws Exception {
//		if(mailType==null || "".equals(mailType))
//		{
//			System.out.println("邮件类型参数缺失！");
//			return false;
//		}
		sendMail2(MailTo, MailCc);
		return true;
	}
		
	private void sendMail() throws Exception {
		//邮件标题
//		mailTitle = "手工提数结果by邮件机器人";
		//邮件内容，支持HTML格式
//		mailMsg = "各位好：\n\n    附件是提取的数据结果，请查收。\n\n-------------------------\n来自邮件机器人^_^\n" + new java.util.Date();
		

		//发送文本格式，带附件邮件：
		getProperties();
		MultiPartEmail email = new MultiPartEmail();
		//smtp host 
		email.setHostName(smtpHost);
		email.setSmtpPort(Integer.parseInt(SmtpPort));
		//登陆邮件服务器的用户名和密码
		email.setAuthentication(mailFromUser, mailFromPwd);
		//接收人
		makeToAndCc(email);
		//发送人
		email.setFrom(mailFromUrl, mailFromUser);
		//标题
		email.setSubject(mailTitle);
		//邮件内容
		email.setMsg(mailMsg);
		
		//添加附件
		//附件，可以定义多个附件对象
//		File file = new File("E:\\需求总览\\test.xlsx");
//		File file2 = new File("E:\\需求总览\\testph.png");
//		File file3 = new File("E:\\需求总览\\test-07.xls");
//		if (file != null) {
//			EmailAttachment attachment = new EmailAttachment();
//			attachment.setPath(file.getAbsolutePath());
//			attachment.setDisposition(EmailAttachment.ATTACHMENT);
//			attachment.setDescription("附件1"); 
//			attachment.setName(MimeUtility.encodeText(file.getName())); //显示的文件名
//			//添加一个附件
//			email.attach(attachment);
//			
//			attachment = new EmailAttachment();
//			attachment.setPath(file2.getAbsolutePath());
//			attachment.setDisposition(EmailAttachment.ATTACHMENT);
//			attachment.setDescription("附件2");
//			attachment.setName(MimeUtility.encodeText(file2.getName())); //显示的文件名
//			//添加第二个附件
//			email.attach(attachment);
//			
//			
//			attachment = new EmailAttachment();
//			attachment.setPath(file2.getAbsolutePath());
//			attachment.setDisposition(EmailAttachment.ATTACHMENT);
//			attachment.setDescription("附件3");
//			attachment.setName(MimeUtility.encodeText(file3.getName())); //显示的文件名
//			//添加第二个附件
//			email.attach(attachment);
			//……
			
//		}
		
		//发送
		email.send();
	}
	
	public void sendMail2(String MailTo, String MailCc) throws Exception {
		//邮件标题
//		mailTitle = "手工提数结果by邮件机器人";
		//邮件内容，支持HTML格式
//		mailMsg = "各位好：\n\n    附件是提取的数据结果，请查收。\n\n-------------------------\n来自邮件机器人^_^\n" + new java.util.Date();
		
//		if(mailType==null || "".equals(mailType))
//		{
//			System.out.println("邮件类型参数缺失！");
//		}else{
//		
//		}
		
		//发送文本格式，带附件邮件：
		getProperties();
		this.mailTo = MailTo;
		this.mailCc = MailCc; 
		MultiPartEmail email = new MultiPartEmail();
		//smtp host 
		email.setHostName(smtpHost);
//		email.setSslSmtpPort(SmtpPort);
		email.setSmtpPort(Integer.parseInt(SmtpPort));
//		System.out.println(email.getSslSmtpPort()+"=111");
//		System.out.println(email.getSmtpPort());
		//登陆邮件服务器的用户名和密码
		email.setAuthentication(mailFromUser, mailFromPwd);
		//接收人
		makeToAndCc(email);
		//发送人
		email.setFrom(mailFromUrl, mailFromUser);
		//标题
		email.setSubject(mailTitle);
		//邮件内容
		email.setMsg(mailMsg);
				
		//发送
		email.send();		
	}
	
//	private void getProperties() {
//		File file = new File(getClass().getResource("").getPath(), "mail.properties");
//		if (!file.exists()) {
//			System.out.println("在当前目录下找不到" + file.getName() + "文件");
//		}
//		Properties p = new Properties();
//		FileInputStream in = null;
//		try {
//			in = new FileInputStream(file);
//			p.load(in);
//			mailTo = p.getProperty("mail_to");
//			mailCc = p.getProperty("mail_cc");
//			mailFromUrl = p.getProperty("from_url");
//			mailFromUser = p.getProperty("from_user");
//			mailFromPwd = p.getProperty("user_pwd");
//			smtpHost = p.getProperty("smtp_host");
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			if (in != null)
//				try {
//					in.close();
//				} catch (Exception ee) {
//					ee.printStackTrace();
//				}
//		} 
//	}
	//从mail.properties文件配置改为数据库配置
	private void getProperties() {
		//初始化基本信息
		String sql = "select MailPara,MailValue from LDMailSender where MailType='MailBase'";
		ExeSQL tExeSQL = new ExeSQL();
		SSRS ssrs = tExeSQL.execSQL(sql);
		for(int i=1; i<=ssrs.MaxRow; i++)
		{
			if("smtp_host".equals(ssrs.GetText(i, 1)))
			{
				this.smtpHost = ssrs.GetText(i, 2);
			}
			else if("url".equals(ssrs.GetText(i, 1)))
			{
				this.mailFromUrl = ssrs.GetText(i, 2);
			}
			else if("use".equals(ssrs.GetText(i, 1)))
			{
				this.mailFromUser = ssrs.GetText(i, 2);
			}
			else if("pwd".equals(ssrs.GetText(i, 1)))
			{
				this.mailFromPwd = ssrs.GetText(i, 2);
			}
			else if("port".equals(ssrs.GetText(i, 1)))
			{
				this.SmtpPort = ssrs.GetText(i, 2);
			}
		}
		//发送人
		
//		this.mailTo = MailTo;
//		this.mailCc = MailCc;
		if(this.mailType != null && mailType.length() > 0){
			sql = "select MailPara,MailValue from LDMailSender where MailType='"+this.mailType+"'";
			ssrs = tExeSQL.execSQL(sql);
			for(int i=1; i<=ssrs.MaxRow; i++)
			{
				if("to".equals(ssrs.GetText(i, 1)))
				{
					this.mailTo = ssrs.GetText(i, 2);
				}
				else if("cc".equals(ssrs.GetText(i, 1)))
				{
					this.mailCc = ssrs.GetText(i, 2);
				}
			}
		}else{
			this.mailTo = "";
			this.mailCc = "";
		}
	}
	
	private void makeToAndCc(MultiPartEmail email) throws Exception {
		String[] to = mailTo.split(",");
		for (int i=0; i<to.length; i++) {
			email.addTo(to[i].trim(), to[i]);
		}
		if (mailCc != null && mailCc.trim().length() > 0) {
			String[] cc = mailCc.split(",");
			for (int i=0; i<cc.length; i++) {
				email.addCc(cc[i].trim(), cc[i]);
			}
		}
	}


	public void setMailType(String mailType) {
		this.mailType = mailType;
	}
	
	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}
	
	public void setMailCc(String mailCc) {
		this.mailCc = mailCc;
	}

	public void setMailTitle(String mailTitle) {
		this.mailTitle = mailTitle;
	}

	public void setMailMsg(String mailMsg) {
		this.mailMsg = mailMsg;
	}

	public static void main(String[] args) 
	{
		MailSender sender = new MailSender();
//		try {
//			sender.setMailType("MailTest");
//			sender.setMailTitle("测试邮件---by database--one");
//			sender.setMailMsg("各位好：\n\n    测试邮件。\n\n-------------------------\n来自邮件机器人\n" + new java.util.Date());
//			sender.send();
//			System.out.println("send 完成！");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		try {
			sender.setMailType("");
			sender.setMailTitle("测试邮件---by hand--second");
			sender.setMailMsg("123");
			sender.send2("gepeng@sinosoft.com.cn,weiruning@sinosoft.com.cn","pengliyuan@sinosoft.com.cn,zhangdongyang@sinosoft.com.cn");
			System.out.println("send2 完成！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
