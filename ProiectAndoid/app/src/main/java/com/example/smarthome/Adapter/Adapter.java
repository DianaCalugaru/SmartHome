package com.example.smarthome.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.smarthome.R;

import java.util.List;
public class Adapter extends ArrayAdapter<String> {

    private Context context;
    private List<String> wordList;
    private List<String> numberList;

    public Adapter(Context context, List<String> wordList, List<String> numberList) { // A doua lista adaugata aici
        super(context, 0, wordList);
        this.context = context;
        this.wordList = wordList;
        this.numberList = numberList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        TextView wordTextView = convertView.findViewById(R.id.word_text_view);
        TextView numberTextView = convertView.findViewById(R.id.number_text_view); // TextView nou

        String word = wordList.get(position);
        wordTextView.setText(word);

        // Verifica daca numarul exista in lista
        if (position < numberList.size()) {
            String number = numberList.get(position);
            numberTextView.setText(number);
        }

        return convertView;
    }
}
