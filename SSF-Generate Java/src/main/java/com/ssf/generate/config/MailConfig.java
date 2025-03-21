package com.ssf.generate.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

        //CONFIGURANDO ESSA JOÇA DE EMAIL
        @Bean
        public JavaMailSender javaMailSender() {
            // Cria uma instância de JavaMailSenderImpl
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

            // Configura o host do servidor SMTP
            mailSender.setHost("smtp.example.com");

            // Configura a porta do servidor SMTP
            mailSender.setPort(587);

            // Configura o nome de usuário para autenticação no servidor SMTP
            mailSender.setUsername("your-email@example.com");

            // Configura a senha para autenticação no servidor SMTP
            mailSender.setPassword("your-email-password");

            // Configura propriedades adicionais para o envio de e-mails
            Properties props = mailSender.getJavaMailProperties();
            props.put("mail.transport.protocol", "smtp"); // Protocolo de transporte
            props.put("mail.smtp.auth", "true"); // Habilita autenticação SMTP
            props.put("mail.smtp.starttls.enable", "true"); // Habilita STARTTLS
            props.put("mail.debug", "true"); // Habilita modo de depuração

            // Retorna a instância configurada de JavaMailSender
            return mailSender;
        }



}
