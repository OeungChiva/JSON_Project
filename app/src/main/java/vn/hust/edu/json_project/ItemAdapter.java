package vn.hust.edu.json_project;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    List<ItemModel> items;
    public Context mContext;

    public ItemAdapter(List<ItemModel> items,Context context) {

        this.mContext = context;
        this.items = items;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        final ItemModel item = items.get(position);
        holder.textUsername.setText(item.getUsername());
        holder.textEmail.setText(item.getEmail());
        Picasso.get().load(items.get(position).getAvatar()).into(holder.imageView);
        //holder.imageView.setImageResource(Integer.parseInt(item.getAvatar()));
        //new onclick
       // Glide.with(mContext)
                //.load(items.get(position).getAvatar())
               // .into(holder.imageView);

        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
                onClickGoToDetail(item);


           }

            private void onClickGoToDetail(ItemModel item) {
                Intent intent = new Intent(mContext, DetailsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("object_item",item);
                intent.putExtras(bundle);
                mContext.startActivity(intent);

            }
        });

    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        LinearLayout itemLayout;
        TextView textUsername;
        TextView textEmail;
        ImageView imageView;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemLayout = itemView.findViewById(R.id.item_layout);
            textUsername = itemView.findViewById(R.id.text_username);
            textEmail = itemView.findViewById(R.id.text_email);
            imageView = itemView.findViewById(R.id.image1);
        }
    }
}
