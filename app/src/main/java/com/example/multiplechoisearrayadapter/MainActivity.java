package com.example.multiplechoisearrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String[] countries={"США", "Канада", "Мексика", "Эквадор", "Египет"};
    TextView selection;
    ListView countriesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //получаем элемент TextView
        selection=findViewById(R.id.selection);
        //получаем элемент ListView
        countriesList=findViewById(R.id.countriesList);

        //создаем адаптер
        ArrayAdapter<String> adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, countries);
        //устанавливаем для списка адаптер
        countriesList.setAdapter(adapter);
        //добавляем для списка слушатель
        countriesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SparseBooleanArray sp=countriesList.getCheckedItemPositions();
                String selectedItems="";
                for (int i=0; i<countries.length; i++){
                    if (sp.get(i))
                        selectedItems+=countries[i]+",";
                }
                //установка текста элемента TextView
                selection.setText("Выбрано: " + selectedItems);
            }
        });
    }
}
