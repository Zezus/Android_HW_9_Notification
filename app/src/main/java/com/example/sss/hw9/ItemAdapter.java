package com.example.sss.hw9;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sss on 02.04.2018.
 */

public class ItemAdapter extends ArrayAdapter {

    private Context context;
    private List<Item> items;

    public ItemAdapter(@NonNull Context context, @NonNull List<Item> items) {
        super(context, R.layout.item, items);
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = View.inflate(context, R.layout.item, null);

        TextView textView = convertView.findViewById(R.id.text_view);

        Item item = items.get(position);

        textView.setText(item.getTitle());

        return convertView;
    }
}
