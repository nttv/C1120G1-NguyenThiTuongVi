package furama_resort.services;

import java.util.List;

public abstract class AdditionalService<T> implements CRUDService<T> {
    public abstract List<T> sortById();
}
