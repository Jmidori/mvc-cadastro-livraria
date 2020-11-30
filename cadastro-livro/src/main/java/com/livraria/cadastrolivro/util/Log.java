package com.livraria.cadastrolivro.util;

import org.slf4j.Logger;

import java.time.LocalDateTime;

public class Log {
    private LocalDateTime dateTime;
    private String identifier;
    private String occurrence;
    private static Logger log;

    public Log() {
    }

    public void generateErrorLog(LocalDateTime dateTime, String identifier, String occurrence){
        log.error(dateTime + " - Erro na operacao: " + identifier + ". Erro: " + occurrence);
    }

    public void generateRegisterLog(LocalDateTime dateTime, String s) {
        log.info(dateTime + s);
    }
}
