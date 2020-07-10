package com.example.androidtasksoftxpert.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.androidtasksoftxpert.Model.ModelDataResponse;
import com.example.androidtasksoftxpert.R;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterData extends RecyclerView.Adapter<AdapterData.ViewHolder> {

    Context context;
    private List<ModelDataResponse.DataBean> carsList = new ArrayList<>();

    public AdapterData(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.txtPrand.setText(carsList.get(position).getBrand());
        holder.txtYear.setText(carsList.get(position).getConstructionYear());
        Glide.with(context)
                .load(carsList.get(position).getImageUrl())
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .error(R.drawable.ic_image)
                .into(holder.imgProfile);
        if (carsList.get(position).isIsUsed())
            holder.txtUsed.setText("Used");
        else
            holder.txtUsed.setText("New");

    }

    @Override
    public int getItemCount() {
        return carsList.size();
    }

    public void setCarsList(List<ModelDataResponse.DataBean> carList) {
        if (carList != null)
            carsList.addAll(carList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_profile)
        CircleImageView imgProfile;
        @BindView(R.id.txt_prand)
        TextView txtPrand;
        @BindView(R.id.txt_year)
        TextView txtYear;
        @BindView(R.id.txt_used)
        TextView txtUsed;
        @BindView(R.id.card_doctor)
        CardView car_card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
