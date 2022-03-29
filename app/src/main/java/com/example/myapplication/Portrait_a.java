package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Portrait_a extends AppCompatActivity  {
    private ListView listView;
    private ArrayList<Product> products;
    private ProductAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.portrait_a);

        listView = findViewById(R.id.listview);

        products = new ArrayList<>();
        products.add(new Product("Nike shoes-discount 50%", R.drawable.shoes_rm_preview_b));
        products.add(new Product("Adidas shoes-discount 80%", R.drawable.shoes_rm_preview_a));
        products.add(new Product("Yonex shoes-discount 50%", R.drawable.shoes_rm_purple));
        products.add(new Product("Victor shoes-discount 50%", R.drawable.shoes_rm_preview));
        products.add(new Product("Lining shoes-discount 50%", R.drawable.shoes_white_removebg_preview));
        products.add(new Product("Binh Minh shoes-discount 90%", R.drawable.colorremovebgpreview));


        adapter = new ProductAdapter(this,R.layout.listview,products);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Portrait_a.this, Portrait_b.class);
                Bundle b = new Bundle();
                b.putString("name", products.get(position).getName());
                b.putInt("img", products.get(position).getImg());
                i.putExtras(b);
                startActivity(i);
            }
        });
    }
}
