package com.imran.tubesakb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.imran.tubesakb.data.DataModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.ViewHolder> {

    private ArrayList<DataModel> listKategori = new ArrayList<DataModel>();

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView iniImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iniImage = itemView.findViewById(R.id.iv_image_rvLayout);
        }

        void halo(DataModel dataModel){
            Picasso.get().load(dataModel.getImageURL()).resize(500,700).into(iniImage);
        }
    }

    public void kategoriAdapter(ArrayList<DataModel> listData){
        listKategori = listData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_kategori_layout,parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.halo(listKategori.get(position));
    }

    @Override
    public int getItemCount() {
        return listKategori.size();
    }


}
