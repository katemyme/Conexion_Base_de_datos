package dao;

import java.util.List;

public interface CRUDinterface <T> {

    public List<T> listar();

    public void guardar ( T object );


}
