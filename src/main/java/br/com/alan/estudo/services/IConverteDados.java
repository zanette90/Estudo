package br.com.alan.estudo.services;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);

}
