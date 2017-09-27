package com.examples.tylerhopkins.hopkinsapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.io.ByteArrayOutputStream;

import io.realm.Realm;

public class NewBulldogActivity extends Activity {

    private EditText editName;
    private EditText editAge;
    private Button saveButton;
    private ImageButton bulldogPhoto;
    private Realm realm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_bulldog);

        editName = (EditText) findViewById(R.id.name_field);
        editAge = (EditText) findViewById(R.id.age_field);
        saveButton = (Button) findViewById(R.id.save_button);
        bulldogPhoto = (ImageButton) findViewById(R.id.bulldog_image_add);
        realm = Realm.getDefaultInstance();

        bulldogPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(takePictureIntent.resolveActivity(getPackageManager()) != null)
                {
                    startActivityForResult(takePictureIntent, 1);
                }
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(!editName.getText().toString().matches("") && !editAge.getText().toString().matches("") && bulldogPhoto.getDrawable() != null)
                {
                    realm.executeTransaction(new Realm.Transaction()
                    {
                        @Override
                        public void execute(Realm realm)
                        {
                            Bulldog bulldog = new Bulldog(editName.getText().toString(), editAge.getText().toString(),realm.where(Bulldog.class).findAllSorted("id").last().getId() + 1);
                            BitmapDrawable image = (BitmapDrawable) bulldogPhoto.getDrawable();
                            ByteArrayOutputStream baos = new ByteArrayOutputStream();
                            image.getBitmap().compress(Bitmap.CompressFormat.JPEG, 100, baos);
                            byte[] imageUpload = baos.toByteArray();
                            bulldog.setImage(imageUpload);
                            realm.copyToRealm(bulldog);
                            finish();

                        }
                    });
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            bulldogPhoto.setImageBitmap(imageBitmap);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close the Realm instance.
        realm.close();
    }
}
