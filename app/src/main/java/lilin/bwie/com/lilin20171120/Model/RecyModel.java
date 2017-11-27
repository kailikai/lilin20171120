package lilin.bwie.com.lilin20171120.Model;

import android.util.Log;

import lilin.bwie.com.lilin20171120.Bean.NewsBean;
import lilin.bwie.com.lilin20171120.Net.Api;
import lilin.bwie.com.lilin20171120.Net.ApiService;
import lilin.bwie.com.lilin20171120.OnNetListener;
import lilin.bwie.com.lilin20171120.Utils.RetrofitUtils;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by せしおゆ on 2017/11/20.
 */

public class RecyModel {
  public  void findData(String catalogId,String pnum, final OnNetListener onNetListener){
      ApiService apiService= RetrofitUtils.getInstance().getApiService(Api.myurl,ApiService.class);
      Observable<NewsBean> observable=apiService.getlist(catalogId,pnum);
      Log.i("xxc","传参"+catalogId+pnum);
      observable.subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(new Subscriber<NewsBean>() {
                  @Override
                  public void onCompleted() {

                  }

                  @Override
                  public void onError(Throwable e) {
                         Log.i("xxc",e.getMessage());
                  }

                  @Override
                  public void onNext(NewsBean newsBean) {
                        onNetListener.OnSuccess(newsBean);
                  }
              });
  }
}
