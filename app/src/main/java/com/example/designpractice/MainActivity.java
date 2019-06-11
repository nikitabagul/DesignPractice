package com.example.designpractice;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Development development_frag;
    Design design_frag;
    Marking marking_flag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        development_frag = new Development();
        design_frag = new Design();
        marking_flag = new Marking();

        BottomNavigationView nav = findViewById(R.id.nav);
        final FrameLayout content = findViewById(R.id.content_layout);//final becoz we are not changing the fragment we are just changing fragment content

        change_Fragment(development_frag); //method to change the fragments again and again

        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch(menuItem.getItemId())
                {
                    case R.id.Development:
                        change_Fragment(development_frag);
                        Animation animationq = AnimationUtils.loadAnimation(MainActivity.this,R.anim.custom_animation);
                        content.startAnimation(animationq);
                        return true;
                    case R.id.Design:
                        change_Fragment(design_frag);
                        Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.custom_animation);
                        content.startAnimation(animation);
                        return true;
                    case R.id.Marking:
                        change_Fragment(marking_flag);
                        Animation animatio = AnimationUtils.loadAnimation(MainActivity.this,R.anim.custom_animation);
                        content.startAnimation(animatio);
                        return true;

                    default:
                        return false;
                }
            }
        });


    }

    private void change_Fragment(Fragment fragment) { //choose version 4 for fragment

        FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();//transaction maintains the changes happening in the fragment
        fragmentTransaction3.replace(R.id.content_layout,fragment);//fragmment same just passing the fragment object which changes again and again
        fragmentTransaction3.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.Development:
                Toast.makeText(MainActivity.this, "Development", Toast.LENGTH_SHORT).show();
                break;

            case R.id.Design:
                Toast.makeText(MainActivity.this, "Design", Toast.LENGTH_SHORT).show();
                break;

            case R.id.Marking:
                Toast.makeText(MainActivity.this, "Marking", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
