package com.walfud.flowimageloader.dna.action;

import android.graphics.Bitmap;

import com.google.gson.Gson;
import com.walfud.cache.Cache;
import com.walfud.flowimageloader.dna.Dna;
import com.walfud.flowimageloader.dna.gene.Gene;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by walfud on 2016/3/19.
 */
public class CacheAction extends Action {

    private Cache<Bitmap> mCache;
    public CacheAction(Cache<Bitmap> cache) {
        mCache = cache;
    }

    @Override
    public Observable<Object> onAct(Dna dna, List<Gene> todoGeneList) {
        return Observable.just(0)
                .observeOn(Schedulers.io())
                .map(object -> {
                    String cacheId = new Gson().toJson(dna.getGeneList());
                    Bitmap bitmap = dna.getBitmap();
                    if (mCache.get(cacheId) == null) {
                        mCache.put(cacheId, bitmap);
                    }

                    return object;
                });
    }
}
