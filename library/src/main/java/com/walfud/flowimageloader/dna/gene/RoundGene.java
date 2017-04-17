package com.walfud.flowimageloader.dna.gene;

import android.graphics.Bitmap;

import com.walfud.flowimageloader.dna.Dna;
import com.walfud.walle.graphic.BitmapTransformer;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by walfud on 2016/3/19.
 */
public class RoundGene extends Gene {
    public double radiusX;
    public double radiusY;

    public RoundGene(double radiusX, double radiusY) {
        this.radiusX = radiusX;
        this.radiusY = radiusY;
    }

    @Override
    public Observable<Bitmap> onInject(Dna dna) {
        return Observable.just(0)
                .observeOn(Schedulers.computation())
                .map(object -> {
                    Bitmap src = dna.getBitmap();
                    return new BitmapTransformer(src)
                            .round(radiusX, radiusY)
                            .get();
                });
    }
}
