package com.example.chatplus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chatplus.Models.Users;
import com.example.chatplus.databinding.ActivityProfileImageViewBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import okhttp3.internal.cache.DiskLruCache;

public class ProfileImageViewActivity extends AppCompatActivity {

   ActivityProfileImageViewBinding binding;
   FirebaseDatabase database;
   FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileImageViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

        database = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();


        String recieveId = getIntent().getStringExtra("ReciverId");





        database.getReference().child("Users").child(recieveId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String username = snapshot.child("username").getValue(String.class);
                binding.username.setText(username);
                String status = snapshot.child("status").getValue(String.class);
                binding.status.setText(status);

                String profilePic = snapshot.child("profilePic").getValue().toString();
                Picasso.get().load(profilePic).placeholder(R.drawable.avatar).into(binding.profileImage);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





        binding.backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileImageViewActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}