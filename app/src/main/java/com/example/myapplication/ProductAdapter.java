package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.Product;

import java.util.List;


public class ProductAdapter extends BaseAdapter {
    private Context context;
    private int idLayout;
    private List<Product> listProduct;
    private int positionSelect = -1;

    public ProductAdapter(Context context, int idLayout, List<Product> listProduct) {
        this.context = context;
        this.idLayout = idLayout;
        this.listProduct = listProduct;
    }

    @Override
    public int getCount() {
        if (listProduct.size() != 0 && !listProduct.isEmpty()) {
            return listProduct.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("DefaultLocale")
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(idLayout, parent, false);
        }
        TextView tvProductName = (TextView) convertView.findViewById(R.id.txtName);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imgItem);

        final Product product = listProduct.get(position);

        if (listProduct != null && !listProduct.isEmpty()) {
            tvProductName.setText(product.getName());
            imageView.setImageResource(product.getImg());
        }
        return convertView;
    }
}
