package com.example.dyagilev.vsurest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewItem extends AppCompatActivity {

    private TextView title;
    private TextView description;
    private TextView date;
    private TextView author;

    NewsObject news;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_item);

        String id = getIntent().getStringExtra("item_id");

        title = (TextView) findViewById(R.id.title);
        description = (TextView) findViewById(R.id.view_description);
        date = (TextView) findViewById(R.id.date);
        author = (TextView) findViewById(R.id.author);

        App.getApi().getItem(id).enqueue(new Callback<NewsObject>() {
            @Override
            public void onResponse(Call<NewsObject> call, Response<NewsObject> response) {
                news = response.body();

                title.setText(news.getTitle());
                description.setText(news.getDescription());
                date.setText(news.getDate());
                author.setText(news.getAuthor());
            }

            @Override
            public void onFailure(Call<NewsObject> call, Throwable t) {
                Toast.makeText(ViewItem.this, "An error occurred during networking", Toast.LENGTH_SHORT).show();
            }
        });

        Button back_button = (Button)findViewById(R.id.back_button);
        back_button.setOnClickListener(btnListener);
    }

    private View.OnClickListener btnListener = new View.OnClickListener()
    {
        public void onClick(View v)
        {
            finish();
        }
    };
}
