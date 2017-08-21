package com.sandeep.imagecropmaster.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.sandeep.imagecropmaster.R;
import com.sandeep.imagecropmaster.adapter.ImageAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final int REQUEST_IMAGE_CAPTURE = 2;
    private List<String> list;
    private RecyclerView recyclerView;
    private ImageAdapter imageAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Button selctImageBtn;
  //  private ArrayList<String> imagesPathList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();
        recyclerView = (RecyclerView)findViewById(R.id.recyler);
        selctImageBtn = (Button)findViewById(R.id.selectImagebtn);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        selctImageBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.selectImagebtn:

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);


                startActivityForResult(Intent.createChooser(intent, "Select Picture"), REQUEST_IMAGE_CAPTURE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            // imagesPathList = new ArrayList<String>();
            String[] imagesPath = data.getStringExtra("data").split("\\|");

            if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data

                for (int i = 0; i < imagesPath.length; i++) {
                    list.add(imagesPath[i]);
                }
                imageAdapter = new ImageAdapter(this,list);
                recyclerView.setAdapter(imageAdapter);

            } else {
                Toast.makeText(this, "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }
    }
}
