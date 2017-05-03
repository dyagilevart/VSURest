package com.example.dyagilev.vsurest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;
import static android.content.res.Configuration.ORIENTATION_PORTRAIT;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<NewsObject> news;
    private Context context;

    public MyAdapter(List<NewsObject> news) {
        this.news = news;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v_news = LayoutInflater.from(parent.getContext()).inflate(R.layout.news, parent, false);
        View v_advert = LayoutInflater.from(parent.getContext()).inflate(R.layout.advert, parent, false);
        switch (viewType) {
            case 0: return new ViewHolderNews(v_news);
            case 1: return new ViewHolderAdvert(v_advert);
        }
        return new ViewHolderNews(v_news);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        NewsObject news_object = news.get(position);

        switch (holder.getItemViewType()){
            case 0:
                holder.getItemViewType();
                ViewHolderNews viewHolderNews = (ViewHolderNews) holder;
                viewHolderNews.title.setText(news_object.getTitle());
                viewHolderNews.description.setText(news_object.getDescription());
                viewHolderNews.author.setText(news_object.getAuthor());
                viewHolderNews.date.setText(news_object.getDate());
                break;
            case 1:
                ViewHolderAdvert viewHolderAdvert = (ViewHolderAdvert) holder;
                viewHolderAdvert.title.setText(news_object.getTitle());
                viewHolderAdvert.description.setText(news_object.getDescription());
                break;
        }

    }

    @Override
    public int getItemCount() {
        if (news == null)
            return 0;
        return news.size();
    }

    @Override
    public int getItemViewType(int position) {
        NewsObject news_object = news.get(position);
        switch (news_object.getType()){
            case "news" :
                return 0;
            default:
                return 1;
        }
    }

    class ViewHolderNews extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;
        TextView author;
        TextView date;

        public ViewHolderNews(final View itemView) {
            super(itemView);
            context = itemView.getContext();
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.view_description);
            author = (TextView) itemView.findViewById(R.id.author);
            date = (TextView) itemView.findViewById(R.id.date);

            itemView.setClickable(true);
            itemView.setFocusableInTouchMode(true);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NewsObject news_object = news.get(getAdapterPosition());

                    if (v.getResources().getConfiguration().orientation == ORIENTATION_PORTRAIT) {
                        final Intent intent;

                        intent = new Intent(context, ViewItem.class);
                        intent.putExtra("item_id", news_object.getId().toString());

                        context.startActivity(intent);
                    }
                    else if (v.getResources().getConfiguration().orientation == ORIENTATION_LANDSCAPE){

                        TextView title = (TextView) v.getRootView().findViewById(R.id.view_title);
                        TextView description = (TextView) v.getRootView().findViewById(R.id.view_desc);
                        TextView date = (TextView) v.getRootView().findViewById(R.id.view_date);
                        TextView author = (TextView) v.getRootView().findViewById(R.id.view_author);

                        title.setText(news_object.getTitle());
                        description.setText(news_object.getDescription());
                        date.setText(news_object.getDate());
                        author.setText(news_object.getAuthor());

                        //Toast.makeText(itemView.getContext(), "title: " + news_object.getTitle(), Toast.LENGTH_LONG).show();
                    }
                }
            });

        }
    }

    class ViewHolderAdvert extends RecyclerView.ViewHolder {
        TextView title;
        TextView description;

        public ViewHolderAdvert(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.view_description);
        }
    }
}

