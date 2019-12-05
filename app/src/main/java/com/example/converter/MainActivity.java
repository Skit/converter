package com.example.converter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements ClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        final RecyclerView recyclerView = findViewById(R.id.recycler_view);
        MainAdapter adapter = new MainAdapter(this);
        recyclerView.setAdapter(adapter);
        adapter.update(Arrays.asList(Convertation.values()));
    }

    @Override
    public void onItemClick(@NonNull Convertation convertation) {
        Toast.makeText(this, "Item Clicked", Toast.LENGTH_LONG).show();
        final Intent intent = Main2Activity.getStartIntent(this, convertation);
        startActivity(intent);
    }
}
