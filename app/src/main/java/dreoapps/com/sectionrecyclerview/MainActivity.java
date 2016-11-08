package dreoapps.com.sectionrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        rv.setAdapter(new RVAdapter());
    }


    static class RVAdapter extends SectionRecyclerviewAdapter{

        @Override
        public int getSectionsCount() {
            return 3;
        }

        @Override
        public int getItemCountForSection(int section) {
            switch (section){
                case 0:
                    return 2;
                case 1:
                    return 1;
                case 2:
                    return 3;
            }
            return 0;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolderSection(ViewGroup parent, int section) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            switch (section){
                case 0:
                    return new CustomViewHolder(inflater.inflate(R.layout.title,parent,false));
                case 1:
                    return new CustomViewHolder(inflater.inflate(R.layout.title,parent,false));
                case 2:
                    return new CustomViewHolder(inflater.inflate(R.layout.title,parent,false));
            }
            return null;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolderForSection(ViewGroup parent, int section) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            switch (section) {
                case 0:
                    return new CustomViewHolder(inflater.inflate(R.layout.news, parent,false));
                case 1:
                    return new CustomViewHolder(inflater.inflate(R.layout.news, parent,false));
                case 2:
                    return new CustomViewHolder(inflater.inflate(R.layout.news, parent,false));
            }
            return null;
        }

        @Override
        public void onBindViewHolderForSection(RecyclerView.ViewHolder holder, int position, int section) {

            switch (section){

            }

        }

        @Override
        public void onBindViewHolderSection(RecyclerView.ViewHolder holder, int section) {
            switch (section){

            }

        }


        class CustomViewHolder extends RecyclerView.ViewHolder{

            public CustomViewHolder(View itemView) {
                super(itemView);
            }
        }
    }
}
