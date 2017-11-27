package lilin.bwie.com.lilin20171120.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import lilin.bwie.com.lilin20171120.Bean.NewsBean;
import lilin.bwie.com.lilin20171120.R;

/**
 * Created by せしおゆ on 2017/11/20.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
    Context context;
    NewsBean newsBean;

    public MyAdapter(Context context, NewsBean newsBean) {
        this.context = context;
        this.newsBean = newsBean;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        MyViewHolder myviewHolder = new MyViewHolder(view);
        return myviewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
      holder.tv_title.setText(newsBean.getRet().getList().get(position).getTitle());
        String ss=newsBean.getRet().getList().get(position).getPic();
        Uri uri=Uri.parse(ss);
      holder.img.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return newsBean.getRet().getList().size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
       ImageView img;
        TextView tv_title;
        public MyViewHolder(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            tv_title=itemView.findViewById(R.id.tv_title);
        }
    }
}
