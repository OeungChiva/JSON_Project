package vn.hust.edu.json_project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

public class ItemJSONAdapter extends RecyclerView.Adapter<ItemJSONAdapter.ItemViewHolder> {

    JSONArray jsonArray;

    public ItemJSONAdapter(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        try {
            JSONObject jsonObject = jsonArray.getJSONObject(position);
            holder.textUsername.setText(jsonObject.getString("username"));
            holder.textEmail.setText(jsonObject.getString("email"));
           // Picasso.get().load(jsonArray.get(position).getString("avatar")).into(holder.imageView);
            holder.imageView.setImageResource(Integer.parseInt(jsonObject.getString("avatar")));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return jsonArray.length();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textUsername;
        TextView textEmail;
        ImageView imageView;
        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            textUsername = itemView.findViewById(R.id.text_username);
            textEmail = itemView.findViewById(R.id.text_email);
            imageView = itemView.findViewById(R.id.image1);
        }
    }
}
