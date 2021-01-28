package FuramaResort.Services;

import java.util.List;

public abstract class Service<T> implements CRUDService<T> {
    public abstract List<T> sortById();
}
