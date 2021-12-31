package vn.hust.edu.json_project;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity
{
    private ImageView imageView;
    private TextView name, username, email, address, phone, company;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_layout);
        Bundle bundle = getIntent().getExtras();
        if (bundle==null){
            return;
        }
        ItemModel item = (ItemModel) bundle.get("object_item");
        imageView = findViewById(R.id.image1);
        name = findViewById(R.id.text_name);
        username = findViewById(R.id.text_username);
        email = findViewById(R.id.text_email);
        address = findViewById(R.id.text_address);
        phone = findViewById(R.id.text_phone);
        company = findViewById(R.id.text_company);
        //imageView.setImageResource(item.getAvatar());
        name.setText(item.getName());
        username.setText(item.getUsername());
        email.setText(item.getEmail());
        address.setText(item.getAddress());
        phone.setText(item.getPhone());
        company.setText(item.getCompany());
    }

}
