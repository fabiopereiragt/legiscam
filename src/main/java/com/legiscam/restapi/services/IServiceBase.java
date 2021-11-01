package com.legiscam.restapi.services;

import java.util.List;

public interface IServiceBase<T> {    
    T salva(T model);
    T atualiza(T model);
    T buscarPorId(Long id);
    List<T> buscaTodos();
    boolean deleta(Long id);
    void existeNoBanco(Long id);
}
