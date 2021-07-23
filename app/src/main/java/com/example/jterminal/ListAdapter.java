package com.example.jterminal;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final String[] itemcount;
    private final String[] itembarcode;
    private final String[] itemprice;

    public ListAdapter(Activity context, String[] itemname, String[] itemcount, String[] itembarcode,String[] itemprice) {
        super(context, R.layout.listviewdesign, itemname);
        // TODO Auto-generated constructor stub

        this.context = context;
        this.itemname = itemname;
        this.itemcount = itemcount;
        this.itembarcode = itembarcode;
        this.itemprice = itemprice;

    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.listviewdesign, null, true);

        TextView itemname = (TextView) rowView.findViewById(R.id.itemname);
        TextView itemcount = (TextView) rowView.findViewById(R.id.itemcount);
        TextView itembarcode = (TextView) rowView.findViewById(R.id.itembarcode);
        TextView itemprice = (TextView) rowView.findViewById(R.id.itemprice);

        itemname.setText(this.itemname[position]);
        itemcount.setText(this.itemcount[position]);
        itembarcode.setText(this.itembarcode[position]);
        itemprice.setText(this.itemprice[position]);

        return rowView;

    }

    ;
}