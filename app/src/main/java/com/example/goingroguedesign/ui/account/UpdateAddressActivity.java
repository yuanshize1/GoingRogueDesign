package com.example.goingroguedesign.ui.account;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.goingroguedesign.MainActivity;
import com.example.goingroguedesign.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateAddressActivity extends AppCompatActivity {

    String address, id;
    EditText etStreetAddress;
    TextView confirmBtn;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_address);
        ((AppCompatActivity) UpdateAddressActivity.this).getSupportActionBar().hide();

        TextView tvCancelUpdate = findViewById(R.id.tvCancelAdd);
        confirmBtn = findViewById(R.id.tvSubmit);
        etStreetAddress = findViewById(R.id.etStreetAddress);

        getData();
        setData();
        tvCancelUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DocumentReference addressRef = db.collection("Customer").document(id);
                addressRef
                        .update("customerAddress", etStreetAddress.getText().toString())
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(UpdateAddressActivity.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(UpdateAddressActivity.this, MainActivity.class);
                                intent.putExtra("id", 3);
                                startActivity(intent);
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(UpdateAddressActivity.this, "Server Error", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        });
            }
        });

    }

    private void getData() {
        if(getIntent().hasExtra("id") &&
                getIntent().hasExtra("address")) {
            id = getIntent().getStringExtra("id");
            address = getIntent().getStringExtra("address");
        } else {
            Toast.makeText(this, "Error Retrieving data.", Toast.LENGTH_SHORT).show();
        }

    }

    private void setData() {
        etStreetAddress.setText(address);
    }
}
