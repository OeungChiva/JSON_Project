package vn.hust.edu.json_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
      //  RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
//        recyclerView.setAdapter(adapter);

        new DownloadTask(this).execute("https://lebavui.github.io/jsons/users.json");

        try {
            List<ItemModel> items = new ArrayList<>();
            items.add(new ItemModel(12, "peter", "Peter", "peter@gmail.com","","","",""));
            items.add(new ItemModel(13, "john", "John", "john@gmail.com","","","",""));

            JSONArray jArr = new JSONArray();
            for (int i = 0; i < items.size(); i++) {
                ItemModel item = items.get(i);
                JSONObject jObj = new JSONObject();
                jObj.put("id", item.getId());
                jObj.put("username", item.getUsername());
                jObj.put("name", item.getName());
                jObj.put("email", item.getEmail());
                jObj.put("avatar", item.getAvatar());
                jObj.put("phone", item.getPhone());
                jObj.put("address",item.getAddress());
                jObj.put("company", item.getCompany());
                jArr.put(jObj);
            }

            Log.v("TAG", jArr.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    class DownloadTask extends AsyncTask<String, Void, JSONArray> {
        ProgressDialog dialog;
        Context context;

        public DownloadTask(Context context) {
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(context);
            dialog.setMessage("Loading data...");
            dialog.show();
        }

        @Override
        protected JSONArray doInBackground(String... params) {
            try {
                URL url = new URL(params[0]);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                String line;
                StringBuilder builder = new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line = reader.readLine()) != null)
                    builder.append(line);
                reader.close();
                String jsonString = builder.toString();
                return new JSONArray(jsonString);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(JSONArray jsonArray) {
            dialog.dismiss();
            if (jsonArray != null) {
                ItemJSONAdapter adapter = new ItemJSONAdapter(jsonArray);
                recyclerView.setAdapter(adapter);
            }
        }
    }
}