package com.sine95.tweetsrv.service;

import io.github.jhipster.config.JHipsterProperties;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.sine95.tweetsrv.domain.J314User;

import com.sine95.tweetsrv.enums.ContingenciaCorreo;
import com.sine95.tweetsrv.errores.ErrorEnvioCorreo;
import com.sine95.tweetsrv.warnings.WarningCorreoNoEnviado;
import com.sine95.tweetsrv.warnings.WarningEnvioCorreo;

import org.sine95.kernel.util.Vacio;
import org.sine95.kernel.base.Result;;

/**
 * Service for sending emails.
 * <p>
 * We use the @Async annotation to send emails asynchronously.
 */
@SuppressWarnings("unused")
@Service
public class MailService {

    private final Logger log = LoggerFactory.getLogger(MailService.class);

    private static final String USER = "user";

    private static final String BASE_URL = "baseUrl";

    private final JHipsterProperties jHipsterProperties;

    private final JavaMailSender javaMailSender;

    private final MessageSource messageSource;

    private final SpringTemplateEngine templateEngine;

    public MailService(JHipsterProperties jHipsterProperties, JavaMailSender javaMailSender,
            MessageSource messageSource, SpringTemplateEngine templateEngine) {

        this.jHipsterProperties = jHipsterProperties;
        this.javaMailSender = javaMailSender;
        this.messageSource = messageSource;
        this.templateEngine = templateEngine;
    }

    
    public Result<Vacio> sendEmail(String idCorreo,String to, String subject, String content, boolean isMultipart, boolean isHtml) {
        return sendEmail(idCorreo,new String[] {to},null,null,jHipsterProperties.getMail().getFrom(),subject,content,isMultipart,isHtml,null,null,ContingenciaCorreo.ERROR);
    }
    public Result<Vacio> sendEmail(String idCorreo,String []tos,String[] cc,String[] bcc, String subject, String content, boolean isMultipart, boolean isHtml,String[]adjuntos,byte[][] dataAdjuntos,ContingenciaCorreo contingencia)
    {
    	return sendEmail(idCorreo,tos,cc,bcc, null,subject, content, isMultipart, isHtml,adjuntos,dataAdjuntos,contingencia);
    }
    
    public Result<Vacio> sendEmail(String idCorreo,String []tos,String[] cc,String[] bcc, String from,String subject, String content, boolean isMultipart, boolean isHtml,String[]adjuntos,byte[][] dataAdjuntos,ContingenciaCorreo contingencia) {
    	Result<Vacio> res= new Result<Vacio>();
        log.debug("Send email[multipart '{}' and html '{}'] to '{}' with subject '{}' and content={}",
            isMultipart, isHtml, tos, subject, content);

        // Prepare message using a Spring helper
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, isMultipart, StandardCharsets.UTF_8.name());
            for(String to:tos)
            {
            	message.addTo(to);
            }
            if(cc!=null)for(String to:cc)
            {
            	if(!"".equals(to)) message.addCc(to);
            }
            if(bcc!=null)for(String to:bcc)
            {
            	if(!"".equals(to)) message.addBcc(to);
            }
            if(from!=null)
            {
            	message.setFrom(from);
            }
            else {
            	message.setFrom(jHipsterProperties.getMail().getFrom());
            }
            message.setSubject(subject);
            message.setText(content, isHtml);
            if(adjuntos!=null && adjuntos.length>0)
            {
	            for(int i=0;i<adjuntos.length;i++)
	            {
	            	InputStreamSource stream = new ByteArrayResource(dataAdjuntos[i]);
	            	message.addAttachment(adjuntos[i], stream);
	            }
            }
            javaMailSender.send(mimeMessage);
            log.debug("Sent email to User '{}'", tos);
        } catch (Exception e) {
            if (log.isDebugEnabled()) {
                log.warn("Email could not be sent to user '{}'", tos, e);
            } else {
                log.warn("Email could not be sent to user '{}': {}", tos, e.getMessage());
            }
            
            if(contingencia==ContingenciaCorreo.WARNING)
            {
            	res.addWarning(new WarningEnvioCorreo(idCorreo, content));
            }
            else
            {
            	res.addError(new ErrorEnvioCorreo(idCorreo, content));
            }
        }
        
		return res;
    }

    @Async
    public void sendEmailFromTemplate(J314User user, String templateName, String titleKey) {
        Locale locale = Locale.forLanguageTag(user.getLang_key());
        Context context = new Context(locale);
        context.setVariable(USER, user);
        context.setVariable(BASE_URL, jHipsterProperties.getMail().getBaseUrl());
        String content = templateEngine.process(templateName, context);
        String subject = messageSource.getMessage(titleKey, null, locale);
        sendEmail(templateName,user.getEmail(), subject, content, false, true);

    }

    @Async
    public void sendActivationEmail(J314User user) {
        log.debug("Sending activation email to '{}'", user.getEmail());
        sendEmailFromTemplate(user, "mail/activationEmail", "email.activation.title");
    }

    @Async
    public void sendCreationEmail(J314User user) {
        log.debug("Sending creation email to '{}'", user.getEmail());
        sendEmailFromTemplate(user, "mail/creationEmail", "email.activation.title");
    }

    @Async
    public void sendPasswordResetMail(J314User user) {
        log.debug("Sending password reset email to '{}'", user.getEmail());
        sendEmailFromTemplate(user, "mail/passwordResetEmail", "email.reset.title");
    }
}
