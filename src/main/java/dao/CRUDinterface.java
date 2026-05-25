package dao;

import java.util.List;

public interface CRUDinterface <T> {

    public List<T> listar();

    public void guardar ( T object );

    public void  eliminar (Long id);

    public void Actualizar ( T Object );


}
