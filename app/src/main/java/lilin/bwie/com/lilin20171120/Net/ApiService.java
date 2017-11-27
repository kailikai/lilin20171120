package lilin.bwie.com.lilin20171120.Net;

import lilin.bwie.com.lilin20171120.Bean.NewsBean;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by せしおゆ on 2017/11/20.
 */

public interface ApiService {
    //String s="http://api.svipmovie.com/
    // front/columns/getVideoList.do/catalogId=402834815584e463015584e539330016&pnum=2";
    @GET("front/columns/getVideoList.do")
    Observable<NewsBean> getlist(@Query("catalogId") String catalogId,@Query("pnum")String pnum);

}
