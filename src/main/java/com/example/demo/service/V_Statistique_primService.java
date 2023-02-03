package com.example.demo.service;

import com.example.demo.repository.*;
import com.example.demo.model.*;
public class V_Statistique_primService extends CrudService<V_Statistique_prim, V_Statistique_primRepo>{
    public V_Statistique_primService(V_Statistique_primRepo repo) {
        super(repo);
    }
}
