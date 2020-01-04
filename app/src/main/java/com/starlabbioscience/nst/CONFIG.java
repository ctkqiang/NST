package com.starlabbioscience.nst;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CONFIG {
    private static Context context;
    private clientList.ClientAdapter ada;

    static class clientList extends RecyclerView.ViewHolder {
        private TextView EMAIL;
        private TextView PASSWORD;

        private String key;

        public clientList(ViewGroup parent){
            super(LayoutInflater.from(context)
                    .inflate(R.layout.list, parent,false));

            EMAIL = (TextView) itemView.findViewById(R.id.Email);
            PASSWORD = (TextView) itemView.findViewById(R.id.Password);
        }

        public void bind(DATA data,  String key){
            EMAIL.setText(data.getEMAIL());
            PASSWORD.setText(data.getPASSWORD());
            this.key = key;
        }

        static class ClientAdapter extends RecyclerView.Adapter<clientList>{
            private List<DATA> datalist;
            private List<String> theKey;

            public ClientAdapter(List<DATA> datalist, List<String> theKey) {
                this.datalist = datalist;
                this.theKey = theKey;
            }

            @NonNull
            @Override
            public clientList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return new clientList(parent);
            }

            @Override
            public void onBindViewHolder(@NonNull clientList holder, int position) {
                holder.bind(datalist.get(position), theKey.get(position));
            }

            @Override
            public int getItemCount() {
                return datalist.size();
            }
        }
    }
    public void setConfig(RecyclerView rv, Context c, List<DATA> d, List<String> key){
        context = c;
        ada = new clientList.ClientAdapter(d, key);
        rv.setLayoutManager(new LinearLayoutManager(context));
        rv.setAdapter(ada);
    }
}