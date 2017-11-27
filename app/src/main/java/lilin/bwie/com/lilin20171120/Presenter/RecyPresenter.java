package lilin.bwie.com.lilin20171120.Presenter;

import lilin.bwie.com.lilin20171120.Bean.NewsBean;
import lilin.bwie.com.lilin20171120.Model.RecyModel;
import lilin.bwie.com.lilin20171120.OnNetListener;
import lilin.bwie.com.lilin20171120.VIew.IRecyView;

/**
 * Created by せしおゆ on 2017/11/20.
 */

public class RecyPresenter implements OnNetListener{
    IRecyView view;
    RecyModel model;

    public RecyPresenter(IRecyView view) {
        this.view = view;
        model=new RecyModel();
    }
    public void relevance(String catalogId,String pnum){
        model.findData(catalogId,pnum,this);
    }
    @Override
    public void OnSuccess(NewsBean nb) {
         view.getData(nb);
    }


}
