package lilin.bwie.com.lilin20171120;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;

import com.mcxtzhang.layoutmanager.swipecard.CardConfig;
import com.mcxtzhang.layoutmanager.swipecard.OverLayCardLayoutManager;
import com.mcxtzhang.layoutmanager.swipecard.RenRenCallback;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import lilin.bwie.com.lilin20171120.Adapter.MyAdapter;
import lilin.bwie.com.lilin20171120.Bean.NewsBean;
import lilin.bwie.com.lilin20171120.Presenter.RecyPresenter;
import lilin.bwie.com.lilin20171120.VIew.IRecyView;

public class MainActivity extends AppCompatActivity implements IRecyView{
    int page;
    @BindView(R.id.mrv)
    RecyclerView mrv;
    @BindView(R.id.change)
    Button change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        page=1;
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                page=getNextPage();
                String pnum=String.valueOf(page);
                RecyPresenter presenter=new RecyPresenter(MainActivity.this);
                presenter.relevance("402834815584e463015584e539330016",pnum);
            }
        });

    }


    @Override
    public void getData(NewsBean nb) {
        List<NewsBean.RetBean.ListBean> list=nb.getRet().getList();
        List<String> imglist=new ArrayList<>();
        List<String> title=new ArrayList<>();
        for (int i = 0; i <list.size() ; i++) {
            String img=list.get(i).getPic();
            imglist.add(img);
        }
        MyAdapter mAdapter=new MyAdapter(this,nb);
        mrv.setLayoutManager(new OverLayCardLayoutManager());
        CardConfig.initConfig(this);
        ItemTouchHelper.Callback callback = new RenRenCallback(mrv, mAdapter,list);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(mrv);
        mrv.setAdapter(mAdapter);

    }
    private int getNextPage() {

        page = getRandomNumber(1, 108);

        return page;
    }
    public static int getRandomNumber(int min, int max) {
        return new Random().nextInt(max) % (max - min + 1) + min;
    }

}
