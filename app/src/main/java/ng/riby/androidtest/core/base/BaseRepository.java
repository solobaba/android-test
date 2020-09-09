package ng.riby.androidtest.core.base;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Flowable;

public interface BaseRepository<T, P> {

    Flowable<T> create(P data, HashMap query);

    Flowable<T> edit(String id, P data, HashMap query);

    Flowable<T> get(String id, HashMap query);

    Flowable<List<T>> find(HashMap query);

    Flowable<T> delete(String id);
}
