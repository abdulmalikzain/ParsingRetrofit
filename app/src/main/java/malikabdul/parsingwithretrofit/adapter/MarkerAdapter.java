package malikabdul.parsingwithretrofit.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import malikabdul.parsingwithretrofit.R;
import malikabdul.parsingwithretrofit.beans.Marker;

/**
 * Created by malikabdul on 17/03/18.
 */

public class MarkerAdapter extends RecyclerView.Adapter<MarkerAdapter.CustomViewHolder> {
    private List<Marker> markers;

    public MarkerAdapter(List<Marker> markers) {
        this.markers = markers;
    }

    @Override
    public MarkerAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.users_list, parent, false);

        return new MarkerAdapter.CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MarkerAdapter.CustomViewHolder holder, int position) {
        Marker marker = markers.get(position);
        holder.employeeName.setText(marker.getUsername());
        holder.email.setText(marker.getTelephone());
        Picasso.get().load(marker.getImage()).error(R.mipmap.ic_launcher).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return markers.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView employeeName, designation, email, salary, dob,contactNumber;
        public ImageView imageView;

        public CustomViewHolder(View view) {
            super(view);
            employeeName = (TextView) view.findViewById(R.id.tv_nama);
            email = (TextView) view.findViewById(R.id.tv_email);
            imageView = view.findViewById(R.id.iv_foto);
        }
    }


}
